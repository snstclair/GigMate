package gigmate.util;


import gigmate.entity.Band;
import gigmate.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/bands")
public class Bands {
    private GenericDao bandsDao = new GenericDao(Band.class);
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response getAllSkills() {
        List<Band> bands = (List<Band>) bandsDao.getAll();
        String output = "Bands: ";
        for(Band band : bands) {
            output += band.toString();
        }

        return Response.status(200).entity(output).build();
    }

    @GET
    @Produces("text/plain")
    @Path("{id}")
    public Response getBandById(@PathParam("id") String id) {
        Band band = (Band) bandsDao.getById(Integer.parseInt(id));
        String output = band.toString();

        return Response.status(200).entity(output).build();
    }
}
