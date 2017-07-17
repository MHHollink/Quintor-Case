package nl.quintor.persistance;

import nl.quintor.model.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ArtistService implements PersistenceService<Long, Artist> {

    private EntityManagerFactory factory;
    private EntityManager manager;
    private EntityTransaction transaction;

    public ArtistService() {
        factory = Persistence.createEntityManagerFactory("libraryDatabase");
        manager = factory.createEntityManager();
        transaction = null;
    }

    private void setup() {
        transaction = manager.getTransaction();
        transaction.begin();
    }

    private void tearDown(){
        transaction.commit();
        manager.close();
        factory.close();
    }

    @Override
    public List<Artist> getAll() {
        List<Artist> response;

        setup();

        Query query = manager.createQuery("SELECT a FROM Artist a");
        //noinspection unchecked
        response = query.getResultList();

        tearDown();

        return response;
    }

    @Override
    public Artist getOne(Long id) {

        setup();

        Artist response = manager.find(Artist.class, id);

        tearDown();

        return response;
    }

    @Override
    public Artist save(Artist artist) {
        setup();

        if(artist.getID() == null)
            manager.persist(artist);
        else
            manager.merge(artist);

        Artist response = manager.find(Artist.class, artist);

        tearDown();

        return response;
    }

    @Override
    public void delete(Long id) {
        manager.remove(
                manager.find(Artist.class, id)
        );
    }
}
