package Model.DAO;

import Model.DAO.DoctorDAO;
import Model.classesHierarchy.Doctor;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DoctorServiceImpl {
    private DoctorDAO doctorDAO;

    public DoctorServiceImpl() {
        this.doctorDAO = new DoctorDAO();
    }

    public void addDoctor(Doctor doctor) {
        try {
            doctorDAO.save(doctor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDoctor(Doctor doctor) {
        try {
            doctorDAO.update(doctor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDoctor(int doctorId) {
        try {
            doctorDAO.delete(doctorId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Doctor getDoctorById(int doctorId) {
        try {
            return doctorDAO.findById(doctorId); // Retorna el Doctor directamente, o null si no lo encuentra
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Doctor> getAllDoctors() {
        try {
            return doctorDAO.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}