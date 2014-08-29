package com.poc;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

/**
 * Created by benk on 8/28/2014.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class HelloWorld {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = startServer();
        server.start();

        System.out.println("Server running");
        System.out.println("Visit: http://localhost:9998/helloworld");
        System.out.println("Hit return to stop...");
        System.in.read();
        System.out.println("Stopping server");
        server.shutdown();
        System.out.println("Server stopped");
    }

    protected static HttpServer startServer() throws IOException {
        System.out.println("Starting grizzly...");
        System.setProperty("user.timezone", "GMT");
        ResourceConfig rc = new ResourceConfig();
        rc.packages("com.poc");

        URI uri = UriBuilder.fromUri("http://localhost:9998").build();
        return GrizzlyHttpServerFactory.createHttpServer(uri, rc);
    }
}
