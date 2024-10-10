package Model;
import Model.AbstractDAO;
import Model.Doctor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorDAO extends AbstractDAO<Doctor, Integer> {

    public DoctorDAO() {
        this.tableName = "Doctor"; // Establece el nombre de la tabla
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Doctor (first_name, last_name, specialization, phone, email, department_id) VALUES (?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Doctor SET first_name = ?, last_name = ?, specialization = ?, phone = ?, email = ?, department_id = ? WHERE doctor_id = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM Doctor WHERE doctor_id = ?";
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM Doctor WHERE doctor_id = ?";
    }

    @Override
    protected String getSelectAllQuery() {
        return "SELECT * FROM Doctor";
    }

    @Override
    protected void setPreparedStatementForInsert(PreparedStatement preparedStatement, Doctor entity) throws SQLException {
        preparedStatement.setString(1, entity.getFirstName());
        preparedStatement.setString(2, entity.getLastName());
        preparedStatement.setString(3, entity.getSpecialization());
        preparedStatement.setString(4, entity.getPhone());
        preparedStatement.setString(5, entity.getEmail());
        preparedStatement.setInt(6, entity.getDepartmentId());
    }

    @Override
    protected void setPreparedStatementForUpdate(PreparedStatement preparedStatement, Doctor entity) throws SQLException {
        preparedStatement.setString(1, entity.getFirstName());
        preparedStatement.setString(2, entity.getLastName());
        preparedStatement.setString(3, entity.getSpecialization());
        preparedStatement.setString(4, entity.getPhone());
        preparedStatement.setString(5, entity.getEmail());
        preparedStatement.setInt(6, entity.getDepartmentId());
        preparedStatement.setInt(7, entity.getDoctorId());
    }

    @Override
    protected Doctor mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new Doctor(
                resultSet.getInt("doctor_id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("specialization"),
                resultSet.getString("phone"),
                resultSet.getString("email"),
                resultSet.getInt("department_id")
        );
    }
}