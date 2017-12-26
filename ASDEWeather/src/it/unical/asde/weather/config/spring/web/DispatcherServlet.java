package it.unical.asde.weather.config.spring.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



/***
 * @author haze
 * This substitute the Dispatcher-serverlet.xml file
 */

@Configuration
@EnableWebMvc
@ComponentScan({"it.unical.asde.weather"})
public class DispatcherServlet implements WebMvcConfigurer{

	private final String prefix = "/WEB-INF/views/";
	private final String suffix = ".jsp";
	
	private final String resource_location = "/resources/";
	
	
	/*
	 * Declares the view resolver with @prefix and @suffix
	 */
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix(prefix);
		resolver.setSuffix(suffix);
		return resolver;
	}
	
	
	/* Declaring static resources
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
	 * 
	 */
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**").addResourceLocations(resource_location);

	}
	
}
