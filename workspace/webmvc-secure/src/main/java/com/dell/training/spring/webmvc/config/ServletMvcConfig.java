package com.dell.training.spring.webmvc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.dell.training.spring.webmvc")
@PropertySource("classpath:application.properties")
public class ServletMvcConfig {

	@Value("${view.prefix}")
	private String prefix;
	
	@Value("${view.suffix}")
	private String suffix;
	
	
	// every spring component is auto injected with Environment variable
	@Autowired
	private Environment env;
	
	// add config for DataSource for JDBCTemplate
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		// config the dataSource Object
		/*dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/studentdb");
		dataSource.setUsername("root");
		dataSource.setPassword("");*/
		
		dataSource.setDriverClassName(this.env.getProperty("jdbc.driver"));
		dataSource.setUrl(this.env.getProperty("jdbc.url"));
		dataSource.setUsername(this.env.getProperty("jdbc.username"));
		dataSource.setPassword(this.env.getProperty("jdbc.password"));
		
		
		return dataSource;
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		//viewResolver.setPrefix("/WEB-INF/views/");
		//viewResolver.setSuffix(".jsp");
		viewResolver.setPrefix(this.prefix);
		viewResolver.setSuffix(this.suffix);
		return viewResolver;
	}
}
