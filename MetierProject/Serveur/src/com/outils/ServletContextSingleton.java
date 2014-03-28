package com.outils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

public class ServletContextSingleton extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static ServletContextSingleton instance;
	private static ServletContext servletcontext; 
	
	public static synchronized ServletContextSingleton getInstance(ServletContext servletContext) {
		if (null == instance) { 
			if (null == instance) {
				instance = new ServletContextSingleton(servletContext);
			}
		}
		return instance;
	}

	private ServletContextSingleton(ServletContext servletContext) {
		servletcontext = servletContext;
	}

	public static ServletContext getServletcontext() {
		return servletcontext;
	}

}
