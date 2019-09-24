package com.index.git.api.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class RestAppInitializer implements WebApplicationInitializer{

	private static final Logger logger = Logger.getLogger(RestAppInitializer.class);
	
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
											  webContext.register(RestConfig.class);
											  webContext.setServletContext(servletContext);
											  
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
									servlet.addMapping("/");
									servlet.setLoadOnStartup(1);
									
		logger.info("Application Initialized...!");
	}
}