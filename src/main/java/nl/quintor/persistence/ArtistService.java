package nl.quintor.persistence;

import nl.quintor.interceptor.Log;
import nl.quintor.model.Artist;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

@Default
@ApplicationScoped
public class ArtistService implements ArtistServiceInterface{

    @PersistenceContext(unitName = "libraryDatabase", type = PersistenceContextType.EXTENDED)
    private EntityManager manager;

    public ArtistService() {
        // Empty constructor
    }

    @Log
    @Override
    public List<Artist> getAll() {
        List<Artist> response;

        Query query = manager.createQuery("SELECT a FROM Artist a");
        //noinspection unchecked
        response = query.getResultList();

        return response;
    }

    @Log
    @Override
    public Artist getOne(Long id) {
        return manager.find(Artist.class, id);
    }

    @Log
    @Override
    public Artist save(Artist artist) {
        if(artist.getID() == null)
            manager.persist(artist);
        else
            manager.merge(artist);

        return manager.find(Artist.class, artist);
    }

    @Log
    @Override
    public void delete(Long id) {
        manager.remove(
                manager.find(Artist.class, id)
        );
    }
}
