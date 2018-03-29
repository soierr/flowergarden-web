/**
 * 
 */
package com.flowergarden.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author SOIERR
 *
 */
public class ServletContextListenerImpl implements ServletContextListener{


	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		Shared.INITCONTEXT();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
		
	}

}
