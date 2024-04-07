package com.controlStudents.persistence.repository;

import com.controlStudents.persistence.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleDAO extends JpaRepository<Role, Long> {
    List<Role> findRoleByRoleEnumIn (List<String> roleNames);
}
