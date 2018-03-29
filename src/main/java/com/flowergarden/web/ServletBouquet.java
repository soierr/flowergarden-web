/**
 * 
 */
package com.flowergarden.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flowergarden.services.BouquetService;

/**
 * @author SOIERR
 *
 */
public class ServletBouquet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private final String BOUQUET_ID = "id";

	@Override
    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response ) throws ServletException,IOException{
    	
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        BouquetService bs = Shared.CONTEXT().getBean("bouquetService", BouquetService.class);
        
        String id = request.getParameter(BOUQUET_ID);
        
        if(id == null){
        	
        	response.getWriter().println("No ID provided");
        	return;
        	
        }
        
        String json = bs.getBouquet(Integer.valueOf(id));
        
        if(json == null){
        	
        	return;
        }
        
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h2>Bouquet JSON</h2>");
        response.getWriter().println("<pre id=\"bouquetJson\"></pre>");
        response.getWriter().println("<script>");
        response.getWriter().println("var myJSON = JSON.stringify(JSON.parse('" + json + "'), null, 4);");
        response.getWriter().println("document.getElementById(\"bouquetJson\").innerHTML = myJSON;");
        response.getWriter().println("</script>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
        
    }

}
