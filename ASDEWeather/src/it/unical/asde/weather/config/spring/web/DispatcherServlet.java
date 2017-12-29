package it.unical.asde.weather.config.spring.web;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module.Feature;



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
	
	
	
	 @Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

		 
//		 Hibernate5Module module = new Hibernate5Module(sf);
//			 Hibernate5Module module = new Hibernate5Module();
//		     module.disable(Feature.USE_TRANSIENT_ANNOTATION);
//		     module.enable(Feature.FORCE_LAZY_LOADING);
		 
		 	Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	        builder.dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm"));
	        builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	        builder.featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

	        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));

	}


}
