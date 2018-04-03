/**
 * 
 */
package com.flowergarden.web.processors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.flowergarden.flowers.GeneralFlower2;
import com.flowergarden.services.FlowerService;
import com.flowergarden.web.Shared;

/**
 * @author SOIERR
 *
 */
@Path("/flowers")
public class FlowerProcessor {
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFlower(@PathParam("id") int flowerId){
		
		FlowerService fs = Shared.CONTEXT().getBean("flowerService", FlowerService.class);
		
		GeneralFlower2 flower = null;
		
		if((flower= fs.getFlower(flowerId)) == null){
			
			return Response.status(Status.NO_CONTENT).entity("No flowers found").build();
		}
	
		return Response.status(Status.OK).entity(flower).build();
	}

}
