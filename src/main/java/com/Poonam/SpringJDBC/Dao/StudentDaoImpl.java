package com.Poonam.SpringJDBC.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.Poonam.SpringJDBC.entities.Student;


@Component("studentDaoImpl")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Student student) {
		String insert="insert into student(std_id,std_name,std_address) values(?,?,?)";
		int result=this.jdbcTemplate.update(insert,student.getStd_id(),student.getStd_name(),student.getStd_address());
		return result;
	}

	public int change(Student student) {
		// Updating data
		String query="update student set std_name=?,std_address=? where std_id=?";
		int result=this.jdbcTemplate.update(query,student.getStd_name(),student.getStd_address(),student.getStd_id());
		return result;
	}

	public int delete(int studentId) {
		String query="delete from student where std_id=?";
		int r=this.jdbcTemplate.update(query,studentId);
		return r;
	}

	public Student getStudents(int studentId) {
		//select query for single row
		String query="Select * from student where std_id=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student student=this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
		return student;
	}

	public List<Student> getAllStudents() {
		//selecting number of rows from table
		String query="select * from student";
		List <Student> students=this.jdbcTemplate.query(query,new RowMapperImpl());
		return students;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}





}
