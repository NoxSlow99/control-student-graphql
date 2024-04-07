package com.controlStudents.service.implementation;

import com.controlStudents.graphql.AuthCreateUserRequest;
import com.controlStudents.graphql.AuthLoginRequest;
import com.controlStudents.graphql.AuthResponse;
import com.controlStudents.persistence.entities.Role;
import com.controlStudents.persistence.entities.UserEntity;
import com.controlStudents.persistence.repository.IRoleDAO;
import com.controlStudents.persistence.repository.IUserDAO;
import com.controlStudents.service.IAuthService;
import com.controlStudents.util.JwtUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthService implements IAuthService, UserDetailsService {

    private final IUserDAO userDAO;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final IRoleDAO roleDAO;

    public AuthService(IUserDAO userDAO, PasswordEncoder passwordEncoder, JwtUtils jwtUtils, IRoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.roleDAO = roleDAO;
    }

    @Override
    public AuthResponse loginUser(AuthLoginRequest authLoginRequest) {
        String username = authLoginRequest.username();
        String password = authLoginRequest.password();

        Authentication authentication = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);

        return new AuthResponse(username, "User loged succesfully", accessToken, true);
    }

    @Override
    public AuthResponse createUser(AuthCreateUserRequest createUserRequest) {
        String username = createUserRequest.username();
        String password = createUserRequest.password();
        List<String> roleRequest = createUserRequest.roleRequest().roleListName();

        Set<Role> roleList = new HashSet<>(roleDAO.findRoleByRoleEnumIn(roleRequest));

        if (roleList.isEmpty()) {
            throw new IllegalArgumentException("The roles specified doesn't exist");
        }

        UserEntity user = UserEntity.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles(roleList)
                .isEnabled(true)
                .accountNoLocked(true)
                .accountNoExpired(true)
                .credentialNoExpired(true)
                .build();

        UserEntity userSaved = userDAO.save(user);

        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userSaved.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));
        userSaved.getRoles().stream().flatMap(role -> role.getPermissionList().stream())
                .forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getName())));

        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), authorities);

        String accessToken = jwtUtils.createToken(authentication);

        return new AuthResponse(username, "User created successfully", accessToken, true);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userDAO.findUserEntityByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("El usuario " + username + " no existe."));

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        userEntity.getRoles().forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));

        userEntity.getRoles().stream().flatMap(role -> role.getPermissionList().stream())
                .forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getName())));

        return new User(userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.isEnabled(),
                userEntity.isAccountNoExpired(),
                userEntity.isCredentialNoExpired(),
                userEntity.isAccountNoLocked(),
                authorityList);
    }

    public Authentication authenticate(String username, String password) {
        UserDetails userDetails = this.loadUserByUsername(username);

        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username or password");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Incorrect password");
        }

        return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities());
    }
}
