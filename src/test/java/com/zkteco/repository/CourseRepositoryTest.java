package com.zkteco.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.zkteco.entity.Course;
import com.zkteco.entity.CourseMaterial;
import com.zkteco.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	CourseRepository courseRepository;
	
	@Test
	public void printCourses() {
		List<Course> list= courseRepository.findAll();
		System.out.println(list);
	}
	
//	@Test
//	public void saveCourse() {
//		CourseMaterial courseMaterial = CourseMaterial.builder()
//				.url("ww.asp.com")
//				.build();
//		
//		Course course = Course.builder()
//				.title("ASP")
//				.courseMaterial(courseMaterial)
//				.credit(8)
//				.build();
//		
//		courseRepository.save(course);
//		
//		System.out.println(course);
//	}

	
	@Test
	public void saveCourseWithTeacher() {
		
		Teacher teacher = Teacher
				.builder()
				.firstName("Priyanka")
				.lastName("Awasthi")
				.build();
		
		Course course = Course
				.builder()
				.title("Full Stack")
				.credit(9)
				.teacher(teacher)
				.build();
		
		courseRepository.save(course);
	}
	
	@Test
	public void findAllPagination() {
		Pageable firstPageWithThreeRecords = 
				PageRequest.of(0, 3);
		Pageable secondPageWithTwoRecords = 
				PageRequest.of(1, 3);
		
		Pageable firstPage = PageRequest.of(0, 1);
		
		List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords)
				.getContent();
		
		long totalElements = courseRepository.findAll(firstPageWithThreeRecords)
				.getTotalElements();
		
		long totalPages = courseRepository.findAll(firstPageWithThreeRecords)
				.getTotalPages();
		
		System.out.println(totalPages);
		
		System.out.println(totalElements);
		
		System.out.println(courses);
	}
	
	@Test
	public void findAllSorting() {
		
		Pageable sortByTitle = PageRequest.
				of(0, 2, Sort.by("title"));
		
		Pageable sortByCreditDesc = PageRequest.
				of(0, 2, Sort.by("credit").descending());
		
		Pageable sortByTitleAndCreditDesc = PageRequest.
				of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));
		
		List<Course> courses 
			= courseRepository.findAll(sortByTitle).getContent();
		
		System.out.println(courses);
				
	}
	
	@Test
	public void printfindByTitleContaining() {
		Pageable firstPageTenRecords = PageRequest.of(0, 10);
		
		List<Course> courses = courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();
	}
	
}
