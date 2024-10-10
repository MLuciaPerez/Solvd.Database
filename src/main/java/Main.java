import Model.Doctor;
import Model.DoctorServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        DoctorServiceImpl doctorService = new DoctorServiceImpl();

        // Agregar un nuevo doctor
        Doctor newDoctor = new Doctor(0, "John", "Doe", "Cardiology", "123-456-7890", "john.doe@example.com", 1);
        doctorService.addDoctor(newDoctor);
        logger.info("Doctor added: {} {}", newDoctor.getFirstName(), newDoctor.getLastName());

        // Obtener y mostrar todos los doctores
        logger.info("Doctor list:");
        List<Doctor> doctors = doctorService.getAllDoctors();
        for (Doctor doctor : doctors) {
            logger.info("ID: {}, Name: {} {}, Specialization: {}, Phone: {}, Email: {}, Department ID: {}",
                    doctor.getDoctorId(), doctor.getFirstName(), doctor.getLastName(),
                    doctor.getSpecialization(), doctor.getPhone(), doctor.getEmail(), doctor.getDepartmentId());
        }

        // Actualizar un doctor
        if (!doctors.isEmpty()) {
            Doctor firstDoctor = doctors.get(0);
            firstDoctor.setPhone("987-654-3210");
            doctorService.updateDoctor(firstDoctor);
            logger.info("Doctor updated: {} {}, new phone: {}", firstDoctor.getFirstName(), firstDoctor.getLastName(), firstDoctor.getPhone());
        }

        // Eliminar un doctor
        if (!doctors.isEmpty()) {
            int doctorIdToDelete = doctors.get(0).getDoctorId();
            doctorService.deleteDoctor(doctorIdToDelete);
            logger.info("Doctor deleted with ID: {}", doctorIdToDelete);
        }

        // Muestra la lista actualizada de doctores
        logger.info("Doctor list after deletion:");
        doctors = doctorService.getAllDoctors();
        for (Doctor doctor : doctors) {
            logger.info("ID: {}, Name: {} {}", doctor.getDoctorId(), doctor.getFirstName(), doctor.getLastName());
        }
    }
}