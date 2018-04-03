/**
 * 
 */
package com.flowergarden.web;

import javax.servlet.ServletContextEvent;

import org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap;

/**
 * @author SOIERR
 *
 */
public class ServletContextListenerRestEasyImpl extends ResteasyBootstrap{	

	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		Shared.INITCONTEXT();
		
		super.contextInitialized(event);
	}
}
