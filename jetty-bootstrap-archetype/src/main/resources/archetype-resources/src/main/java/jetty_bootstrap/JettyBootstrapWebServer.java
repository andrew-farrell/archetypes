#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.jetty_bootstrap;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;


import com.sun.jersey.spi.container.servlet.ServletContainer;


public class JettyBootstrapWebServer {
	 public static void main(String[] args) throws Exception {

		 try
			{
				Server server = new Server(8081);
				ServletHolder servletHolder = new ServletHolder(ServletContainer.class);

				servletHolder.setInitParameter("com.sun.jersey.config.property.resourceConfigClass",
						"com.sun.jersey.api.core.PackagesResourceConfig");
	            // IMPORTANT: you have to specify the package where your resources are located in order for Jetty to pick them up
				servletHolder.setInitParameter("com.sun.jersey.config.property.packages", "com.andrewfarrell");
	                        
	            // comment out to hide debug information
				servletHolder.setInitParameter("com.sun.jersey.config.feature.Debug", "true");
				servletHolder.setInitParameter("com.sun.jersey.config.feature.Trace", "true");
				servletHolder.setInitParameter("com.sun.jersey.spi.container.ContainerRequestFilters",
						"com.sun.jersey.api.container.filter.LoggingFilter");
				servletHolder.setInitParameter("com.sun.jersey.spi.container.ContainerResponseFilters",
						"com.sun.jersey.api.container.filter.LoggingFilter");

				ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
				context.setContextPath("/");
				context.addServlet(servletHolder, "/*");

				server.setHandler(context);

				QueuedThreadPool queuedThreadPool = new QueuedThreadPool(10);
				queuedThreadPool.setName("ApiServe");
				

				server.start();
				server.join();
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		 
	    }
}
