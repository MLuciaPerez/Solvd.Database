import Model.*;
import Model.DAO.DoctorDAO;
import Model.classesHierarchy.Doctor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        DoctorDAO doctorDAO = new DoctorDAO();

        // Añadir un nuevo doctor
        try {
            int departmentId = 1;
            Doctor newDoctor = new Doctor(0, "Juan", "Lopez", "123-456-7890", "john.doe@example.com", "Cardiology", departmentId);
            doctorDAO.save(newDoctor);
            logger.info("Doctor added: " + newDoctor.getFirstName() + " " + newDoctor.getLastName());
        } catch (SQLException e) {
            logger.info("Error adding doctor");
        }

        // Listar todos los doctores
        try {
            logger.info("Doctor list:");
            doctorDAO.findAll().forEach(doctor -> {
                logger.info("ID: " + doctor.getId() + ", Name: " + doctor.getFirstName() + " " + doctor.getLastName() +
                        ", Specialization: " + doctor.getSpecialization() + ", Phone: " + doctor.getPhone() +
                        ", Email: " + doctor.getEmail() + ", Department ID: " + doctor.getDepartmentId());
            });
        } catch (SQLException e) {
            logger.info( "Error retrieving doctor list", e);
        }





        // Validate XML
        XMLValidator.validateXML("src/main/resources/hospital.xml");
        // Parse XML
        XMLParser.parseXML();
    }
    }

