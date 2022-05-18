package com.Poonam.SpringJDBC;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//import com.Poonam.SpringJDBC.Dao.StudentDao;
//import com.Poonam.SpringJDBC.Dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = "com.Poonam.SpringJDBC.Dao")
public class JdbcConfig {
	
	
	@Bean("dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("Poonam@8989");		
		return ds;
	}

	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	//As we are adding component annotation we wont use this block 
	/*
	 * @Bean(name="studentDaoImpl") public StudentDao getStudentDao() {
	 * StudentDaoImpl studentDao=new StudentDaoImpl();
	 * studentDao.setJdbcTemplate(getTemplate()); return studentDao; }
	 */
}
