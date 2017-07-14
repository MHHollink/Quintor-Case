package nl.quintor.persistance;

import nl.quintor.model.Artist;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ArtistService implements PersistenceService<Long, Artist> {

    EntityManagerFactory factory;
    EntityManager manager;
    EntityTransaction transaction;

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
        List<Artist> reponse = new ArrayList<>();

        setup();

        Query query = manager.createQuery("SELECT a FROM Artist a");
        reponse = query.getResultList();

        tearDown();

        return reponse;
    }

    @Override
    public Artist getOne(Long id) {

        setup();

        Artist reponse = manager.find(Artist.class, id);

        tearDown();

        return reponse;
    }

    @Override
    public Artist save(Artist artist) {
        setup();

        if(artist.getID() == null)
            manager.persist(artist);
        else
            manager.merge(artist);

        Artist reponse = manager.find(Artist.class, artist);

        tearDown();

        return reponse;
    }

    @Override
    public void delete(Long id) {
        manager.remove(
                manager.find(Artist.class, id)
        );
    }
}
