package com.dell.training.spring.webmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	// configure the credential repository
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/********** in-memory auth *************/
		UserBuilder builder = User.withDefaultPasswordEncoder();
		
		// in memory repository
		auth.inMemoryAuthentication()
			.withUser(builder.username("First").password("abc").roles("MENTOR"))
			.withUser(builder.username("Second").password("abc").roles("STUDENT"))
			.withUser(builder.username("Admin").password("abc").roles("MENTOR","STUDENT"));
		
	}
	// define the accessibility rules
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() // start defining the rules
			.anyRequest() // all url request
			.authenticated()
		.and()
			.formLogin(); // how authentication to take place
		
	}
	
	// config the third party auth : OAuth/JWT token
	/*@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}*/
}
