package Model.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, ID> {
    void save(T entity) throws SQLException;

    void update(T entity) throws SQLException;

    void delete(ID id) throws SQLException;

    T findById(ID id) throws SQLException;

    List<T> findAll() throws SQLException;
}