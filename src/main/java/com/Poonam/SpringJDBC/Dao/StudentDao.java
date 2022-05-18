package com.Poonam.SpringJDBC.Dao;

import java.util.List;

import com.Poonam.SpringJDBC.entities.Student;

public interface StudentDao {
 public int insert(Student student);
 public int change(Student student);
 public int delete(int studentId);
 public Student getStudents(int studentId);
 public List<Student> getAllStudents();
}
