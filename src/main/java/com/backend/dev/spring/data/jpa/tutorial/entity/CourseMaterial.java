package com.backend.dev.spring.data.jpa.tutorial.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@ToString(exclude = "course")
public class CourseMaterial {

	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, 
			generator = "course_material_sequence"
	)
	@SequenceGenerator(
			name = "course_material_sequence",
			sequenceName = "course_material_sequence",
			allocationSize = 1
	)
	private Long courseMateralId;

	private String url;
	
	@OneToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
			//optional = false
	)
	@JoinColumn(
			name = "course_id",
			referencedColumnName = "courseId"
	)
	private Course course;
}
