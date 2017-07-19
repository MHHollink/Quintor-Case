package nl.quintor.persistence.album;

import nl.quintor.model.Album;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Default
@ManagedBean
@ApplicationScoped
public class AlbumService implements AlbumServiceInterface {

    @PersistenceContext(unitName = "libraryDatabase", type = PersistenceContextType.EXTENDED)
    private EntityManager manager;

    @Override
    public List<Album> getAll() {
        return null;
    }

    @Override
    public Album getOne(Long aLong) {
        return null;
    }

    @Override
    public Album save(Album model) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
