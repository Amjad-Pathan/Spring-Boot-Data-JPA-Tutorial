package com.backend.dev.spring.data.jpa.tutorial.test;

import static org.assertj.core.api.Assertions.contentOf;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.dev.spring.data.jpa.tutorial.entity.Course;
import com.backend.dev.spring.data.jpa.tutorial.entity.CourseMaterial;
import com.backend.dev.spring.data.jpa.tutorial.repository.CourseMateraialRepository;

@SpringBootTest
public class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMateraialRepository courseMaterialRepo;
	
	@Test
	public void saveCourseMaterial() {
		
		Course course = Course
						.builder()
						.title("Java")
						.credit(5)
						.build();
		
		CourseMaterial courseMaterial = CourseMaterial
											.builder()
											.url("www.google.com")
											.course(course)
											.build();
		
		courseMaterialRepo.save(courseMaterial);
	}
	
	@Test
	public void printAllCourseMaterial() {
		List<CourseMaterial> courseMaterials = courseMaterialRepo.findAll();
		
		System.out.println(courseMaterials);
		
	}
}
