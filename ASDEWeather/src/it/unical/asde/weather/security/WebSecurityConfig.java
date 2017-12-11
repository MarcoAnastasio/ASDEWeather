package it.unical.asde.weather.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/*
@Configuration
@EnableWebSecurity
*/
@Deprecated
public class WebSecurityConfig {
/*
	extends WebSecurityConfigurerAdapter {
	     
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Autowired
	WeatherUserDetailService userDetailsService;
	 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	     
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	/*
  	      http.authorizeRequests()
	      .antMatchers("/").permitAll()
	        .antMatchers("/admin**").access("hasRole('ADMIN')")
	    	 */        
	   
	    	
//	    	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	//http.authorizeRequests().antMatchers("/","/registration","/test").permitAll().anyRequest();
	  
	/*
	    	http.csrf().disable().authorizeRequests()
			.anyRequest().authenticated()
	    	.and().formLogin();
//			.and().httpBasic();
	    			
	    	/*
			http.httpBasic().and().authorizeRequests()
			.antMatchers("/","/registration","/test").permitAll()
			.anyRequest().authenticated()
			.and().formLogin();
			/*
			.antMatchers("/registration","/test").permitAll()
			.antMatchers("/").access("hasRole('ROLE_USER')")
			.antMatchers("/auth/**").access("hasRole('ROLE_USER')")	        
			 */
	       

}
