package com.propentus.vrkconnector.util.grails;

import org.codehaus.groovy.grails.web.context.ServletContextHolder;
import org.springframework.context.ApplicationContext;

/**
 * Utility class to load ApplicationContext and beans.
 */
public class GrailsUtil {

	public static ApplicationContext getApplicationContext() {
		ApplicationContext ctx = (ApplicationContext) ServletContextHolder.getServletContext().getAttribute(org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes.APPLICATION_CONTEXT);
		return ctx;
	}
	
	public static <T> T getBean(Class<T> clazz) {
		return (T) getApplicationContext().getBean(clazz);
	}
	
}
