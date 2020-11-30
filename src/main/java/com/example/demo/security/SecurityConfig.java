package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		BCryptPasswordEncoder passwordEncoder = passwordEncode();
		System.out.println("=============================================");
		System.out.println("Mot de passe "+passwordEncoder.encode("passer"));
		System.out.println("=============================================");
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("SELECT email as principal, password as credentials, etat FROM user WHERE email = ?")
		.authoritiesByUsernameQuery("SELECT  u.email as principal, r.nom as role FROM user u, roles r, user_roles ur WHERE u.id = ur.id_user AND r.id = ur.id_roles AND u.email = ?")
		.passwordEncoder(passwordEncoder)
		.rolePrefix("ROLE_");
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncode() {
		BCryptPasswordEncoder password = new BCryptPasswordEncoder();
		return password;
		
	}
	@Override 
	protected void configure(HttpSecurity http) {
		try {
			http.formLogin().loginPage("/login"); //personnaliser le formulaire de login
			// les droits d'un utilsateur
			http.authorizeRequests().antMatchers("/client/**", "/village/**", "index").hasAnyRole("ADMIN", "USER");
			
			// les droits d'un Admin
			http.authorizeRequests().antMatchers("/user/**", "roles/**").hasRole("ADMIN");
			
			//  gestion des droits
			http.exceptionHandling().accessDeniedPage("/403");
			http.csrf().disable();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	  
}
