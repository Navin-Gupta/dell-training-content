package com.dell.training.jpaimpl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.dell.training.jpaimpl.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>, CustomStudentRepository{

	// implementation is provided
	List<Student> findStudentsByEmail(String email);
	
	Student findByEmail(String email);
	
	/*@Query("select s from Student s where s.age>:providedAge and s.gpa >:providedGpa")
	List<Student> getStudentBySpecificCriteria(@Param("providedAge") Integer age, 
											   @Param("providedGpa") Double gpa);*/
	
}

// Adding custom functionalities
// 1. Naming convention 
// 2. Custom query method : @Query annotation : by default JPQL
// 3. Custom interface 