package Model;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, ID> {
    void save(T entity);
    void update(T entity);
    void delete(ID id);
    Optional<T> findById(ID id);
    List<T> findAll();
}