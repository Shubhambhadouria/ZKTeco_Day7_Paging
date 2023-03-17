package com.zkteco.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zkteco.entity.Course;
import com.zkteco.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	@Test
	public void saveCourseMaterial() {
		
		Course course = Course.builder()
						.title("DSA")
						.credit(6)
						.build();
		
		CourseMaterial courseMaterial = CourseMaterial.builder()
										.url("www.google.com")
										.course(course)
										.build();
		
		courseMaterialRepository.save(courseMaterial);
	}

	@Test
	public void printAllCousreMaterial() {
		List<CourseMaterial> list = courseMaterialRepository.findAll();
		System.out.println(list);
	}
	
	
}
