package com.dell.training.mongodbimplembed.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dell.training.mongodbimplembed.document.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{

}
