package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDAO<T, ID> implements GenericDAO<T, ID> {
    protected abstract String getInsertQuery();
    protected abstract String getUpdateQuery();
    protected abstract String getDeleteQuery();
    protected abstract String getSelectByIdQuery();
    protected abstract String getSelectAllQuery();
    protected String tableName;

    protected abstract void setPreparedStatementForInsert(PreparedStatement preparedStatement, T entity) throws SQLException;
    protected abstract void setPreparedStatementForUpdate(PreparedStatement preparedStatement, T entity) throws SQLException;
    protected abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    @Override
    public void save(T entity) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(getInsertQuery())) {

            setPreparedStatementForInsert(statement, entity);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(T entity) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(getUpdateQuery())) {

            setPreparedStatementForUpdate(statement, entity);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ID id) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(getDeleteQuery())) {

            statement.setObject(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(getSelectByIdQuery())) {

            statement.setObject(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(mapResultSetToEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public List<T> findAll() {
        List<T> results = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName();

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Itera sobre el ResultSet y convierte cada fila en un objeto de tipo T
            while (rs.next()) {
                T obj = mapResultSetToEntity(rs); // Convierte el ResultSet a un objeto T usando el método definido
                results.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }
}