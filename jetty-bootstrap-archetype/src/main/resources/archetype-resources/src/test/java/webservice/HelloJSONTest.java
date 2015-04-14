#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.webservice;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class HelloJSONTest {

	@Test
	public void testHelloWorld() {
	   
	    HelloJSON service = new HelloJSON();
	    String response = service.helloWorld();
	    assertNotNull(response);
	}

}
