#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/test")
public class HelloJSON{

	
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		public String helloWorld()
		{
			return "Hello World!";
		}
	

}
