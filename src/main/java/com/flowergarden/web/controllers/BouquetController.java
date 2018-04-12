/**
 * 
 */
package com.flowergarden.web.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flowergarden.flowers.GeneralFlower2;
import com.flowergarden.services.BouquetService;
import com.flowergarden.services.ResponseBouquetFreshness;

/**
 * @author SOIERR
 *
 */
@Controller
@RequestMapping("/bouquet")
public class BouquetController {
	
	@Resource(type=BouquetService.class)
	BouquetService bouquetService = null;

	@RequestMapping(value = "/price/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getPrice(@PathVariable("id") int bouquetId, Model model){
		
		float price = 0;
		
		if((price = bouquetService.getPrice(bouquetId)) >=0 ){

			model.addAttribute("price", price);
			
		}else{
			
			model.addAttribute("price", "not found"); 
		}
		
		return "bouquet_price";
	}

	@RequestMapping(value = "/freshnessdec/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String decrementFreshness(@PathVariable("id") int bouquetId, Model model){
		
		ResponseBouquetFreshness response = bouquetService.decrementFreshness(bouquetId);
		
		String view = null;
		
		switch(response.getResult()){
		
			case OK_ALL: {
				
				model.asMap().put("listFlowersUpdated", response.getListFlowersUpdated());
				view = "bouquet_freshness_ok_all";
				break;
			}
			
			case OK_SPECIFIC: {

				model.asMap().put("listFlowersUpdated", response.getListFlowersUpdated());
				model.asMap().put("listFlowersZeroPrice", response.getListFlowersZeroPrice());
				view = "bouquet_freshness_ok_spec";
				break;
			}
			
			case NOK_ALL: {

				model.asMap().put("listFlowersUpdated", response.getListFlowersUpdated());
				view = "bouquet_freshness_nok_all";
				break;
			}
			
			case NOT_FOUND: {

				view = "bouquet_not_found";
				break;
			}
		}
		
		return view;
	}
	
	@RequestMapping(value = "/flowers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getFlowers(@PathVariable("id") int bouquetId, Model model){
		
		List<GeneralFlower2> listFlowers = bouquetService.getFlowers(bouquetId);
		
		String view = null;
		
		if(listFlowers == null){
			
			view = "bouquet_flowers_found_none";
			
		}else{
			
			model.asMap().put("listFlowers", listFlowers);			
			view = "bouquet_flowers_found";
		}
		
		return view;

	}

}
