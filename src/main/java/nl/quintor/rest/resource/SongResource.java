package nl.quintor.rest.resource;

import nl.quintor.model.Song;
import nl.quintor.persistence.song.SongServiceInterface;

import javax.enterprise.context.RequestScoped;
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

@Path("songs")
@RequestScoped
public class SongResource {

    private SongServiceInterface service;

    @Inject
    public SongResource(SongServiceInterface service){
        this.service = service;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Song> getSongs() {
        return service.getAll();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Song createSong(Song song) {
        return service.save(song);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Song getSong(@PathParam("id") long id) {
        return service.getOne(id);
    }


    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Song updateSong(Song song, @PathParam("id") long id) {
        // TODO, checks on ID
        return service.save(song);
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Song deleteArtist(@PathParam("id") long id) {
        service.delete(id);
        return service.getOne(id); // should return null...
    }
}
