package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDAO<T, ID> implements GenericDAO<T, ID> {
    protected String tableName;

    protected abstract String getInsertQuery();
    protected abstract String getUpdateQuery();
    protected abstract String getDeleteQuery();
    protected abstract String getSelectByIdQuery();
    protected abstract String getSelectAllQuery();
    protected abstract void setPreparedStatementForInsert(PreparedStatement preparedStatement, T entity) throws SQLException;
    protected abstract void setPreparedStatementForUpdate(PreparedStatement preparedStatement, T entity) throws SQLException;
    protected abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    public void save(T entity) throws SQLException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getInsertQuery())) {
            setPreparedStatementForInsert(preparedStatement, entity);
            preparedStatement.executeUpdate();
        }
    }

    public void update(T entity) throws SQLException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getUpdateQuery())) {
            setPreparedStatementForUpdate(preparedStatement, entity);
            preparedStatement.executeUpdate();
        }
    }

    public void delete(ID id) throws SQLException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getDeleteQuery())) {
            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public T findById(ID id) throws SQLException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getSelectByIdQuery())) {
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToEntity(resultSet); // Retorna la entidad mapeada
            }
            return null; // Retorna null si no se encuentra
        }
    }

    public List<T> findAll() throws SQLException {
        List<T> entities = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getSelectAllQuery());
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                entities.add(mapResultSetToEntity(resultSet));
            }
        }
        return entities;
    }
}