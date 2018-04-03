/**
 * 
 */
package com.flowergarden.web.processors;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.flowergarden.flowers.GeneralFlower2;
import com.flowergarden.services.BouquetService;
import com.flowergarden.web.Shared;

/**
 * @author SOIERR
 *
 */
@Path("bouquet")
public class BouquetProcessor {
	
	@GET
	@Path("/price/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPrice(@PathParam("id") int bouquetId){
		
		BouquetService bs = Shared.CONTEXT().getBean("bouquetService", BouquetService.class);
		
		float price = 0;
		
		if((price = bs.getPrice(bouquetId)) >=0 ){
			
			return Response.status(Status.OK).entity("Bouquet with id=[" + bouquetId + "] has price=[" + price + "]" ).build();
			
		}else{
			
			return Response.status(Status.NO_CONTENT).entity("Bouquet is not found").build();
		}		
		
	}
	
	@PUT
	@Path("/freshnessdec/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response decrementFreshness(@PathParam("id") int bouquetId){
		
		BouquetService bs = Shared.CONTEXT().getBean("bouquetService", BouquetService.class);
		
		/*we return collections with size equals to size of list flowers of current bouquet
		 * initially it's initalized with nulls. not null entry means flower has current freshnes 0*/
		List<GeneralFlower2> listFlowersNegative = bs.decrementFreshness(bouquetId);
		
		if(listFlowersNegative.indexOf(null) == 0){			
			return Response.status(Status.OK).entity("Freshness of all flowers in bouquet is decremented").build();			
		}else if(listFlowersNegative.indexOf(null) == listFlowersNegative.size()-1){
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("None of flower freshness in bouquet is decremented. All zeroed").build();
		}else{
			return Response.status(Status.OK).entity(listFlowersNegative).build();
		}		
	}
	
	@GET
	@Path("/flowers/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFlowers(@PathParam("id") int bouquetId){
	
		BouquetService bs = Shared.CONTEXT().getBean("bouquetService", BouquetService.class);
		
		List<GeneralFlower2> listFlowers = bs.getFlowers(bouquetId);
		
		if(listFlowers == null){			
			return Response.status(Status.NO_CONTENT).entity("No flowers found").build();
		}else{
			return Response.status(Status.OK).entity(listFlowers).build();
		}

	}

}
