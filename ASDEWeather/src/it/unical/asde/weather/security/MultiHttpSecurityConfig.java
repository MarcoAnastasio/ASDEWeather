package it.unical.asde.weather.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MultiHttpSecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Autowired
	WeatherUserDetailService userDetailsService;
	
	@Configuration
	@Order(1)                                                        
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.antMatcher("/api**").authorizeRequests().anyRequest().hasRole("USER").and().httpBasic();
			
			http.authorizeRequests().antMatchers("/registration","/registration**","/test**").permitAll();
	/*		
			http
			.antMatcher("/api**").authorizeRequests().anyRequest().hasRole("USER").and().httpBasic();
			*/
		}
	}

	@Configuration
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
//			http.authorizeRequests().antMatchers("/registration","/registration**").permitAll();
			
			http.csrf().disable().authorizeRequests().antMatchers("/","/resources/**","/registration**",
					"/test").permitAll();
			
		}
	}
	
	
}
