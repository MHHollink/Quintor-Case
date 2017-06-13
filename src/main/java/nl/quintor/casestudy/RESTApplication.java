package nl.quintor.casestudy;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

/**
 * This file is created on Tuesday 13 June, 2017 at 12:20 AM
 */
@Path("/MyRestService")
@ApplicationPath("/resources")
public class RESTApplication extends Application{

    // http://localhost:8080/Quintor-Case/resources/MyRestService/sayHello
    @GET
    @Path("/sayHello")
    public String getHelloMessage() {
        return "Hello world";
    }

    @GET
    @Path("/echo")
    public Response getResponseMessage(@QueryParam("message") String message){
        return Response.ok("Your message was: "+ message).build();
    }
}

//  https://www.youtube.com/watch?v=dmMdLW92hBA
