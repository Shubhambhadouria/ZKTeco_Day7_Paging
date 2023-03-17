package com.zkteco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zkteco.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	List<Student> findByFirstName(String firstName);
	
	List<Student> findByFirstNameContaining(String name);
	
	List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	
	@Query("select s from Student s where s.emailId=?1")
	Student getStudentByEmailAddress(String EmailId);

	
	// Native Query
	
	@Query(
			value = "SELECT * FROM student_table s where s.student_email=?1",
			nativeQuery = true
	)
	Student getStudentByEmailAddressNative(String emailId);
	
	
	// Native Named Parameters
	
	@Query(
			value = "SELECT * FROM student_table s where s.student_email= :emailId",
			nativeQuery = true
	)
	Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
	
	@Modifying
	@Transactional
	@Query(
			value = "update student_table set first_name = ?1 where email_address =?2",
			nativeQuery = true
	)
	Student updateStudentNameByEmailId(String firstName, String emailId);
	
	
}
