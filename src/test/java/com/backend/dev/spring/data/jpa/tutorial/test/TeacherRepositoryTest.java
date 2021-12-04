package com.backend.dev.spring.data.jpa.tutorial.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.dev.spring.data.jpa.tutorial.entity.Course;
import com.backend.dev.spring.data.jpa.tutorial.entity.CourseMaterial;
import com.backend.dev.spring.data.jpa.tutorial.entity.Teacher;
import com.backend.dev.spring.data.jpa.tutorial.repository.TeacherRepository;

@SpringBootTest
public class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepo;

	@Test
	public void saveTeacherCourse() {
		
		Course course = Course.builder()
				.title("DSA")
				.credit(5)
				.build();
		
		Course course2 = Course.builder()
				.title("OOP")
				.credit(9)
				.build();
		
		Teacher teacher = Teacher
				.builder()
				.firstName("Kale")
				.lastName("Sir")
				.courses(List.of(course, course2))
				.build();
		
		teacherRepo.save(teacher);
	}
	
	/*@Test
	public void saveTeacherCourseCourseMaterial() {
		CourseMaterial courseMaterial = CourseMaterial
												.builder()
												.url("www.javatpoint.com")
												.build();
		
		CourseMaterial courseMaterial2 = CourseMaterial
												.builder()
												.url("www.w3school.com")
												.build();
				
		Course course = Course.builder()
				.title("DBA")
				.credit(5)
				.courseMaterial(courseMaterial)
				.build();
		
		Course course2 = Course.builder()
				.title("SQL")
				.credit(9)
				.courseMaterial(courseMaterial2)
				.build();
		
		Teacher teacher = Teacher
				.builder()
				.firstName("Khan")
				.lastName("Sir")
				.courses(List.of(course, course2))
				.build();
		
		teacherRepo.save(teacher);
	}*/
}
