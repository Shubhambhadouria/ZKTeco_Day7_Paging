package com.zkteco.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zkteco.entity.Course;
import com.zkteco.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
		
		Course courseDSA = Course.builder()
				.title("DSA")
				.credit(5)
				.build();
		
		Course courseJava = Course.builder()
				.title("Java")
				.credit(6)
				.build();
		
		Teacher teacher = Teacher.builder()
				.firstName("Rohit")
				.lastName("Yadav")
//				.courses(List.of(courseDSA,courseJava))
				.build();
		
		teacherRepository.save(teacher);
	}

}
