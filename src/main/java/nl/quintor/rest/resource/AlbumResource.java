package nl.quintor.rest.resource;

import nl.quintor.model.Album;
import nl.quintor.persistence.album.AlbumServiceInterface;

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

@Path("albums")
@RequestScoped
public class AlbumResource {

    private AlbumServiceInterface service;

    @Inject
    public AlbumResource(AlbumServiceInterface service){
        this.service = service;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Album> getAlbums() {
        return service.getAll();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Album createAlbum(Album album) {
        return service.save(album);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Album getAlbum(@PathParam("id") long id) {
        return service.getOne(id);
    }


    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Album updateAlbum(Album album, @PathParam("id") long id) {
        // TODO, checks on ID
        return service.save(album);
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Album deleteArtist(@PathParam("id") long id) {
        service.delete(id);
        return service.getOne(id); // should return null...
    }
}
