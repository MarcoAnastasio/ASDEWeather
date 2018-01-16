package it.unical.asde.weather.config.spring.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.h2.server.web.WebServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import it.unical.asde.weather.config.hibernate.HibernateConfig;
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

	//h2 console 
	@Override
	public void onStartup(ServletContext servletContext) 
	  throws ServletException {
	  super.onStartup(servletContext);
	  ServletRegistration.Dynamic servlet = servletContext
	    .addServlet("h2-console", new WebServlet());
	  servlet.setLoadOnStartup(2);
	  servlet.addMapping("/console/*");
	}
}
