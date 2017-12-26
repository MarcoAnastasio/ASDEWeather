package it.unical.asde.weather.config.spring.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import it.unical.asde.weather.config.spring.HibernateConfig;
import it.unical.asde.weather.config.spring.security.MultiHttpSecurityConfig;


/**
 * 
 * @author haze
 * This class substitute the web.xml file, here every module and Servlets have to be registered 
 */

public class ASDEWeatherInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
	
		return new Class[] {DispatcherServlet.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
