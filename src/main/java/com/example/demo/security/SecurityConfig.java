package com.example.demo.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("SELECT email as principal, password as credentials, etat FROM user WHERE email = ?")
		.authoritiesByUsernameQuery("SELECT  u.email as principal, r.nom as role FROM user u, roles r, user_roles ur WHERE u.id = ur.id_user AND r.id = ur.id_roles AND u.email = ?")
		.rolePrefix("ROLE_");
		
	}
	
	@Override 
	protected void configure(HttpSecurity http) {
		try {
			http.formLogin().loginPage("/login"); //personnaliser le formulaire de login
			// les droits d'un utilsateur
			http.authorizeRequests().antMatchers("/client/**", "/village/**").hasRole("ADMIN");
			
			// les droits d'un Admin
			http.authorizeRequests().antMatchers("/user/**", "roles/**").hasRole("SUPERADMIN");
			
			//  gestion des droits
			http.exceptionHandling().accessDeniedPage("/Admin/403");
			http.csrf().disable();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	  
}
