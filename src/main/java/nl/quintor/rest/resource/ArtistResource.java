package nl.quintor.rest.resource;

import nl.quintor.model.Artist;
import nl.quintor.persistance.ArtistService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("artists")
public class ArtistResource {

    ArtistService service = new ArtistService();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Artist> getArtists() {
        return service.getAll();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Artist createArtist(Artist artist) {
        return service.save(artist);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Artist getArtist(@PathParam("id") long id) {
        return service.getOne(id);
    }


    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Artist updateArtist(Artist artist, @PathParam("id") long id) {
        // TODO, checks on ID
        return service.save(artist);
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Artist deleteArtist(@PathParam("id") long id) {
        service.delete(id);
        return service.getOne(id); // should return null...
    }
}
