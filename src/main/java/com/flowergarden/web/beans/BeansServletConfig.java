/**
 * 
 */
package com.flowergarden.web.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author SOIERR
 *
 */
@EnableWebMvc
@Configuration
@ComponentScan("com.flowergarden.web.controllers")
public class BeansServletConfig {
	
/*	  @Bean
	  public UrlBasedViewResolver urlBasedViewResolver() {
		  
	    UrlBasedViewResolver resolver = new UrlBasedViewResolver();
	    resolver.setViewClass(JstlView.class);
	    resolver.setPrefix("/WEB-INF/views/");
	    resolver.setSuffix(".jsp");
	    return resolver;
	  }*/
	  
	  @Bean
	  public InternalResourceViewResolver internalResourceViewResolver() {
		  
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();	    
	    resolver.setPrefix("/WEB-INF/views/jsp/");
	    resolver.setSuffix(".jsp");
	    return resolver;
	  }
}
