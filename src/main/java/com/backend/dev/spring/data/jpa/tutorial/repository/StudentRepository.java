package com.backend.dev.spring.data.jpa.tutorial.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.dev.spring.data.jpa.tutorial.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	public List<Student> findByFirstName(String firstName);
	
	public List<Student> findByFirstNameContaining(String firstName);
	
	public List<Student> findByLastNameNotNull();
	
	public List<Student> findByGuardianNameContaining(String name);
	
	Student findByFirstNameAndLastName(String firstName, String lastName);
	
	//JPQL
	@Query(value = "select s from Student s where s.emailId = ?1")
	Student getStudentByEmailAddress(String emailAddress);
	
	// Native SQL
	@Query(
			value = "select * from Student where email_address = ?1",
			nativeQuery = true
	)
	Student getStudentByEmailAddressNative(String emailAddress);
	
	// Native SQL with @Param
	@Query(
			value = "select * from Student where email_address = :emailId",
			nativeQuery = true
	)
	Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
	
	@Modifying
	@Transactional
	@Query(
			value="update student set first_name = ?1 where email_address = ?2",
			nativeQuery = true
	)
	int updateStudentNameByEmailId(String firstName, String emailId);
}
