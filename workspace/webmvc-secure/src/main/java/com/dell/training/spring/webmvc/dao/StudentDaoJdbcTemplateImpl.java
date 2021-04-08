package com.dell.training.spring.webmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.dell.training.spring.webmvc.model.Student;

// custom class to map DB records with Model Object
class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		// logic to map single record to Student object
		Student student = new Student();
		student.setUname(rs.getString("name").toUpperCase());
		student.setEmail(rs.getString("email"));
		return student;
	}
	
}

@Component
public class StudentDaoJdbcTemplateImpl implements IStudentDao {

	// dependency
	private DataSource dataSource;
	
	// works on templated sql queries
	private JdbcTemplate jdbcTemplate;
	
	// SQL Template queries
	private final String SQL_FETCH_ALL = "select * from student";
	private final String SQL_INSERT = "insert into student(name,email) values(?, ?)";
	
	
	// constructor based DI
	@Autowired
	public StudentDaoJdbcTemplateImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}
	
	@Override
	public List<Student> findAll() {
		// this.jdbcTemplate.query(<template query>,<mapper>);
		// mapper will hold logic to map the DB records to model object
		List<Student> students = this.jdbcTemplate.query(this.SQL_FETCH_ALL,
														 new StudentRowMapper());
								// new BeanPropertyRowMapper<Student>(Student.class));
		return students;
	}

	@Override
	public boolean add(Student student) {
		int n = this.jdbcTemplate.update(this.SQL_INSERT, 
								 new Object[] {student.getUname(), student.getEmail()});
		
		if(n>0)
			return true;	
		return false;
	}

}
