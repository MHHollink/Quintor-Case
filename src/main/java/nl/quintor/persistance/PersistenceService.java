package nl.quintor.persistance;

import nl.quintor.model.Model;

import java.util.List;

public interface PersistenceService<ID, M extends Model> {

    List<M> getAll();
    M getOne(ID id);

    M save(M model);

    void delete(ID id);

}
