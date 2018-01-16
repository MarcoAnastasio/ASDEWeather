package it.unical.asde.weather.config.spring.security;

import it.unical.asde.weather.core.services.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * 
 * @author haze
 * This file configures the Spring-security module and it's relative filter-chain
 */

@Configuration
@EnableWebSecurity
public class MultiHttpSecurityConfig {


	
	/*
	 * Define the pasword encoder bean 
	 */
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Autowired
	UserService userService;
	
	
	
	/*
	 * Configures the chain
	 */
	@Configuration
	@Order(1)                                                        
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {

			http
			  .csrf()
			    .disable()
			  .cors()			//check if it also work whitout it
			    .and()
			  .sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()

//				uncomment to use h2 console				
//				.headers().frameOptions().disable().and()

			  .authorizeRequests().antMatchers("/api/auth/**").hasRole("USER").and().httpBasic()
			    ;
			
			
		}
	}

	
	
	/*
	 * Configure chain for login form
	 */
	
	@Configuration
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
//			http.authorizeRequests().antMatchers("/registration","/registration**").permitAll();
			
//			unccoment ot use H" console
//			http.headers().frameOptions().disable();
			http.csrf().disable().authorizeRequests().antMatchers("/","/resources/**","/registration**",
					"/test","/console/**").permitAll();
			
		}
	}
	
	
}
