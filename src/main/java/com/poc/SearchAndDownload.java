package com.poc;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by benk on 8/28/2014.
 */
@Path("/searchanddownload")
public class SearchAndDownload {
    @GET
    @Path("/{term}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response searchAndDownload(@PathParam("term") String term, @Context HttpServletResponse response) {
        return Response.ok().build();
    }
}
