package nl.quintor.persistence.song;

import nl.quintor.model.Song;

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
public class SongService implements SongServiceInterface {

    @PersistenceContext(unitName = "libraryDatabase", type = PersistenceContextType.EXTENDED)
    private EntityManager manager;

    @Override
    public List<Song> getAll() {
        return null;
    }

    @Override
    public Song getOne(Long aLong) {
        return null;
    }

    @Override
    public Song save(Song model) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
