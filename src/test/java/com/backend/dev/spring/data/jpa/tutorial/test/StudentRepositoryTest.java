package com.backend.dev.spring.data.jpa.tutorial.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.dev.spring.data.jpa.tutorial.entity.Guardian;
import com.backend.dev.spring.data.jpa.tutorial.entity.Student;
import com.backend.dev.spring.data.jpa.tutorial.repository.StudentRepository;

@SpringBootTest
public class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		Guardian guardian = Guardian
				.builder()
				.name("Manjur Pathan")
				.email("manjurpathan@gmail.com")
				.mobile("7875172857")
				.build();
		
		Student student = Student
				.builder()
				.firstName("Amjad")
				.lastName("Pathan")
				.emailId("amjadpathan2025@gmail.com")
				.guardian(guardian)
				.build();
		
		studentRepository.save(student);
	}
	
	@Test
	public void saveStudentWithGuardian() {
		Guardian guardian = Guardian
				.builder()
				.name("Manoj Jadhav")
				.email("manoj@gmail.com")
				.mobile("8888557733")
				.build();
		
		Student student = Student
				.builder()
				.firstName("Amol")
				.lastName("Jadhav")
				.emailId("amoljadhav@gmail.com")
				.guardian(guardian)
				.build();
		
		studentRepository.save(student);
	}

	@Test
	public void printStudents() {
		List<Student> studentList = studentRepository.findAll();
		System.out.println(studentList);
	}
	
	@Test
	public void printStudentByFirstName() {
		List<Student> studentList = studentRepository.findByFirstName("Nikhil");

		System.out.println(studentList);
	}
	
	@Test
	public void printStudentByFirstNameContaining() {
		List<Student> studentList = studentRepository.findByFirstNameContaining("A");

		System.out.println(studentList);
	}
	
	@Test
	public void printStudentByLastName() {
		List<Student> studentList = studentRepository.findByLastNameNotNull();

		System.out.println(studentList);
	}

	@Test
	public void printStudentByGuardianName() {
		List<Student> studentList = studentRepository.findByGuardianNameContaining("Manjur");

		System.out.println(studentList);
	}
	
	@Test
	public void printStudentByFirstNameAndLastName() {
		Student student = studentRepository.findByFirstNameAndLastName("Amjad", "Pathan");

		System.out.println(student);
	}
	
	@Test
	public void printStudentByEmailId() {
		Student student = studentRepository.getStudentByEmailAddress("amjadpathan2025@gmail.com");

		System.out.println(student);
	}
	
	@Test
	public void printStudentByEmailIdNativeQuery() {
		Student student = studentRepository.getStudentByEmailAddressNative("nikhilkumar@gmail.com");

		System.out.println(student);
	}
	
	@Test
	public void printStudentByEmailIdNativeQueryParam() {
		Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("amoljadhav@gmail.com");

		System.out.println(student);
	}
	
	@Test
	public void updateStudentByEmailIdNativeQuery() {
		int num = studentRepository.updateStudentNameByEmailId("Amol", "amoljadhav@gmail.com");

		System.out.println(num);
	}
}
