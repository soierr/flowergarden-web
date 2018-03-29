/**
 * 
 */
package com.flowergarden.web;

import org.springframework.context.ApplicationContext;

import com.flowergarden.run.Run;

/**
 * @author SOIERR
 *
 */
public class Shared {
	
	private final static ApplicationContext ctx = Run.startContainer();
	
	public static ApplicationContext INITCONTEXT(){
		
		System.out.println("--- Spring Application Container has been initialized ---");
		return ctx; 
	}
	
	public static ApplicationContext CONTEXT(){
		
		return ctx; 
	}
}
