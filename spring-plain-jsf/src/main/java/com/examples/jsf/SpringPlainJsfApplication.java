package com.examples.jsf;

import java.util.Arrays;
import java.util.List;

import javax.faces.webapp.FacesServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.examples.jsf.config.Initializer;
import com.examples.jsf.config.WebConfigInitializer;

@EnableAutoConfiguration
@ComponentScan(basePackages="com.examples.jsf")
@SpringBootApplication
public class SpringPlainJsfApplication extends SpringBootServletInitializer{

	  @Override
	    protected SpringApplicationBuilder configure(
	      SpringApplicationBuilder builder) {
	        return builder.sources(SpringPlainJsfApplication.class,WebConfigInitializer.class, Initializer.class);
	    }

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringPlainJsfApplication.class, args);
		
		List<String> list = Arrays.asList(context.getBeanDefinitionNames());
		list.sort( ( x,  y)->{
			return x.compareTo(y);
		});
		for (String bean : list) {
			System.out.println(String.format("%-500s  %-500s", bean,context.getBean(bean)));
		}
	}
	
	   @Bean
	    public ServletRegistrationBean servletRegistrationBean() {
	        FacesServlet servlet = new FacesServlet();
	        return new ServletRegistrationBean(servlet, "*.xhtml","*.jsf", "*.faces");
	    }

//	    @Bean
//	    public FilterRegistrationBean rewriteFilter() {
//	        FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
//	        rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
//	                DispatcherType.ASYNC, DispatcherType.ERROR));
//	        rwFilter.addUrlPatterns("/*");
//	        return rwFilter;
//	    }
	
}
