package com.Poonam.SpringJDBC;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Poonam.SpringJDBC.Dao.StudentDao;
import com.Poonam.SpringJDBC.Dao.StudentDaoImpl;
import com.Poonam.SpringJDBC.entities.Student;
 

public class App 
{
	public static void main( String[] args )
	{
		System.out.println("My Program Started");
		//Springjdbc => Jdbc Template

		//ApplicationContext context=new ClassPathXmlApplicationContext("com/Poonam/SpringJDBC/Config.xml");
		ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDao studentDao=context.getBean("studentDaoImpl",StudentDao.class);
		/*//Insertion code
		 * Student student=new Student(); student.setStd_id(4);
		 * student.setStd_name("Abc"); student.setStd_address("Kukatpally");
		 * 
		 * //int result=studentDao.insert(student);
		 */
		/*//Update code
		 * Student student=new Student(); student.setStd_id(4);
		 * student.setStd_name("Name"); student.setStd_address("New city"); int
		 * result=studentDao.change(student);
		 * System.out.println("Data updated...."+result);
		 */
		
		
		/*
		 * //Delete code int result=studentDao.delete(3);
		 * System.out.println("Data deleted ...."+result);
		 * 
		 */
		
		/*
		 * //select code Student student=studentDao.getStudents(1);
		 * System.out.println(student);
		 */
		
		
		//Multiple rows select query
		List<Student> students=studentDao.getAllStudents();
		for(Student s:students)
		{
			System.out.println(s);
		}
		
		
		//System.out.println("Student details added "+result);
		
		
		/*
		 * //Insert query //String
		 * insert="insert into student(std_id,std_name,std_address) values(?,?,?)";
		 * 
		 * 
		 * //inserting data into db //int
		 * result=template.update(insert,3,"Poonam Tirumalanagaram ","Hyderabad");
		 * 
		 * //System.out.println("Number of records inserted are ..."+result);
		 */
	}
}
