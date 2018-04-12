/**
 * 
 */
package com.flowergarden.web.controllers;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flowergarden.flowers.GeneralFlower2;
import com.flowergarden.services.FlowerService;

/**
 * @author SOIERR
 *
 */
@Controller
@RequestMapping("/flower")
public class FlowerController {
	
	@Resource(type=FlowerService.class)
	FlowerService flowerService = null;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getFlower(@PathVariable("id") int flowerId, Model model){
		
		GeneralFlower2 flower = null;
		
		if((flower= flowerService.getFlower(flowerId)) != null){
			
			model.addAttribute("flower", flower);
			return "flower_found";
		}
		
		return "flower_found_none";

	}
}
