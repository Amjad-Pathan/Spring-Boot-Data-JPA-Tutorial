package com.backend.dev.spring.data.jpa.tutorial.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.backend.dev.spring.data.jpa.tutorial.entity.Course;
import com.backend.dev.spring.data.jpa.tutorial.entity.Student;
import com.backend.dev.spring.data.jpa.tutorial.entity.Teacher;
import com.backend.dev.spring.data.jpa.tutorial.repository.CourseRepository;

@SpringBootTest
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepo;

	@Test
	public void printCourses() {
		List<Course> courseList = courseRepo.findAll();

		System.out.println(courseList);
	}
	
	@Test
	public void saveCourseTeacher() {
		Teacher teacher = Teacher
				.builder()
				.firstName("Priyanka")
				.lastName("Singh")
				.build();
		
		/*
		 * CourseMaterial courseMaterial = CourseMaterial .builder()
		 * .url("www.javatpoint.com") .build();
		 */
		
		Course course = Course
				.builder()
				.title("Python")
				.credit(7)
				.teacher(teacher)
				//.courseMaterial(courseMaterial)
				.build();
		
		courseRepo.save(course);
	}
	
	@Test
    public void findAllPagination(){
        Pageable firstPagewithThreeRecords =
                PageRequest.of(0, 2);
        Pageable secondPageWithTwoRecords = 
                PageRequest.of(1,2);
        
        List<Course> courses =
        		courseRepo.findAll(secondPageWithTwoRecords)
                        .getContent();

        long totalElements =
        		courseRepo.findAll(secondPageWithTwoRecords)
                .getTotalElements();

        long totalPages =
        		courseRepo.findAll(secondPageWithTwoRecords)
                .getTotalPages();

        System.out.println("totalPages = " + totalPages);
        
        System.out.println("totalElements = " + totalElements);

        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                        );
        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                        .descending()
                        .and(Sort.by("credit"))
                );
        
        List<Course> courses
                = courseRepo.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void printfindByTitleContaining() {
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

        List<Course> courses =
        		courseRepo.findByTitleContaining(
                        "D",
                        firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }

	@Test
	public void saveCourseWithStudentAndTeacher() {

		Teacher teacher = Teacher
				.builder()
				.firstName("Lizze")
				.lastName("Morgan")
				.build();

		Student student = Student
				.builder()
				.firstName("Abhishek")
				.lastName("Singh")
				.emailId("abhishek@gmail.com")
				.build();

		Course course = Course
				.builder()
				.title("AI")
				.credit(12)
				.teacher(teacher)
				.build();

		course.addStudents(student);

		courseRepo.save(course);
	}
	 

}
