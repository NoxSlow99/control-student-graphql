package com.controlStudents;

import com.controlStudents.persistence.entities.*;
import com.controlStudents.persistence.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ControlStudentGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlStudentGraphqlApplication.class, args);
	}

	@Bean
	CommandLineRunner init(IUserDAO userRepository, IStudentDAO studentDAO, IDivisionDAO divisionDAO,
						   ICampuDAO campuDAO, ICarreraDAO carreraDAO) {
		return args -> {
			/* Create PERMISSIONS */
			Permission createPermission = Permission.builder()
					.name("CREATE")
					.build();

			Permission readPermission = Permission.builder()
					.name("READ")
					.build();

			Permission updatePermission = Permission.builder()
					.name("UPDATE")
					.build();

			Permission deletePermission = Permission.builder()
					.name("DELETE")
					.build();

			/* Create ROLES */
			Role roleAdmin = Role.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			Role roleInvited = Role.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionList(Set.of(readPermission))
					.build();

			/* CREATE USERS */
			UserEntity userAngel = UserEntity.builder()
					.username("angel")
					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity userInvited = UserEntity.builder()
					.username("invitado")
					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleInvited))
					.build();

			userRepository.saveAll(List.of(userAngel, userInvited));

			// Crear instancias de Division, Carrera y Campu
			Division division = Division.builder()
					.name("División de Ciencias y Tecnología")
					.students(new ArrayList<>())
					.carreras(new ArrayList<>())
					.campus(new ArrayList<>())
					.build();

			Carrera carrera = Carrera.builder()
					.name("Ingenieria en Redes")
					.students(new ArrayList<>())
					.campus(new ArrayList<>())
					.division(division)
					.build();

			Campu campu = Campu.builder()
					.name("Chetumal Bahía")
					.students(new ArrayList<>())
					.carreras(new ArrayList<>())
					.divisiones(new ArrayList<>())
					.build();

			Division division1 = Division.builder()
					.name("División de Humanidades")
					.students(new ArrayList<>())
					.carreras(new ArrayList<>())
					.campus(new ArrayList<>())
					.build();

			Carrera carrera1 = Carrera.builder()
					.name("Derecho")
					.students(new ArrayList<>())
					.campus(new ArrayList<>())
					.division(division)
					.build();

			Campu campu1 = Campu.builder()
					.name("Cancun")
					.students(new ArrayList<>())
					.carreras(new ArrayList<>())
					.divisiones(new ArrayList<>())
					.build();

			division.getCarreras().add(carrera);
			division.getCampus().add(campu);
			carrera.getCampus().add(campu);
			campu.getCarreras().add(carrera);
			campu.getDivisiones().add(division);

			division1.getCarreras().add(carrera1);
			division1.getCampus().add(campu1);
			carrera1.getCampus().add(campu1);
			campu1.getCarreras().add(carrera1);
			campu1.getDivisiones().add(division1);

			// Guardar las entidades Division, Carrera y Campu antes de crear y guardar Student
			divisionDAO.saveAll(List.of(division, division1));
			carreraDAO.saveAll(List.of(carrera, carrera1));
			campuDAO.saveAll((List.of(campu, campu1)));

			// Crear una instancia de Student usando el patrón Builder
			Student student = Student.builder()
					.name("Angel Colli")
					.edad(24)
					.email("angel@email.com")
					.carrera(carrera)
					.campu(campu)
					.division(division)
					.build();

			Student student1 = Student.builder()
					.name("Juan")
					.edad(20)
					.email("juan@example.com")
					.carrera(carrera1)
					.campu(campu1)
					.division(division1)
					.build();

			division.getStudents().add(student);
			carrera.getStudents().add(student);
			campu.getStudents().add(student);

			division1.getStudents().add(student1);
			carrera1.getStudents().add(student1);
			campu1.getStudents().add(student1);

			// Guardar la entidad Student
			studentDAO.saveAll(List.of(student, student1));
		};
	}
}
