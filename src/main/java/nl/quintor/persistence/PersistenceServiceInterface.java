package nl.quintor.persistence;

import nl.quintor.model.Model;

import java.util.List;

/**
 *
 * @param <ID>
 * @param <M>
 */
public interface PersistenceServiceInterface<ID, M extends Model> {

    /**
     *
     * @return
     */
    List<M> getAll();
    M getOne(ID id);

    M save(M model);

    void delete(ID id);

}
