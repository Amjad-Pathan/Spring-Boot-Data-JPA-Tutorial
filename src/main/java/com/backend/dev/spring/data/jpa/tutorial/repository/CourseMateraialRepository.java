package com.backend.dev.spring.data.jpa.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.dev.spring.data.jpa.tutorial.entity.CourseMaterial;

@Repository
public interface CourseMateraialRepository extends JpaRepository<CourseMaterial, Long> {

}
