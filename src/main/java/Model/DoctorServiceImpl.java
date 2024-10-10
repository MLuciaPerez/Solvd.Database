package Model;

import Model.Doctor;
import Model.DoctorDAO;

import java.util.List;

public class DoctorServiceImpl {
    private DoctorDAO doctorDAO;

    public DoctorServiceImpl() {
        this.doctorDAO = new DoctorDAO();
    }

    public void addDoctor(Doctor doctor) {
        doctorDAO.save(doctor);
    }

    public void updateDoctor(Doctor doctor) {
        doctorDAO.update(doctor);
    }

    public void deleteDoctor(int doctorId) {
        doctorDAO.delete(doctorId);
    }

    public Doctor getDoctorById(int doctorId) {
        return doctorDAO.findById(doctorId).orElse(null);
    }

    public List<Doctor> getAllDoctors() {
        return doctorDAO.findAll();
    }
}