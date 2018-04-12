/**
 * 
 */
package com.flowergarden.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author SOIERR
 *
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String index(){

		return "index";
	}

}
