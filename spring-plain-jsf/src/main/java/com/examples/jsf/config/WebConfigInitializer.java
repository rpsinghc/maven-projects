package com.examples.jsf.config;

import com.sun.faces.config.FacesInitializer;

import javax.faces.FactoryFinder;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@Configuration
public class WebConfigInitializer extends FacesInitializer   implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		FactoryFinder.setFactory(FactoryFinder.FACES_CONTEXT_FACTORY,"com.sun.faces.context.FacesContextFactoryImpl");
		AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
	    root.register(SpringCoreConfig.class);
	    servletContext.addListener(new ContextLoaderListener(root));
	   servletContext.addListener(new RequestContextListener());
	   servletContext.addListener(com.sun.faces.config.ConfigureListener.class);
	   
	   servletContext.addServlet("Faces Servlet", "javax.faces.webapp.FacesServlet").addMapping(".jsf","*.xhtml");
	   
	   
	}

}
