import Model.*;
import Model.DAO.DoctorDAO;
import Model.classesHierarchy.Doctor;
import Model.classesHierarchy.Hospital;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.SQLException;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        DoctorDAO doctorDAO = new DoctorDAO();

        // Add a new doctor
        try {
            int departmentId = 1;
            Doctor newDoctor = new Doctor(0, "Juan", "Lopez", "123-456-7890", "john.doe@example.com", "Cardiology", departmentId);
            doctorDAO.save(newDoctor);
            logger.info("Doctor added: " + newDoctor.getFirstName() + " " + newDoctor.getLastName());
        } catch (SQLException e) {
            logger.error("Error adding doctor", e);
        }

        // List all doctors
        try {
            logger.info("Doctor list:");
            doctorDAO.findAll().forEach(doctor -> {
                logger.info("ID: " + doctor.getId() + ", Name: " + doctor.getFirstName() + " " + doctor.getLastName() +
                        ", Specialization: " + doctor.getSpecialization() + ", Phone: " + doctor.getPhone() +
                        ", Email: " + doctor.getEmail() + ", Department ID: " + doctor.getDepartmentId());
            });
        } catch (SQLException e) {
            logger.error("Error retrieving doctor list", e);
        }




        // Validate the XML file
        XMLValidator.validateXML("src/main/resources/hospital.xml");

        // Parse the XML file
        XMLParser.parseXML();




        logger.info("JAXB");

        // JAXB XML parsing
        try {
            // Create JAXB context for the Hospital class
            JAXBContext context = JAXBContext.newInstance(Hospital.class);

            // Create an Unmarshaller
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Parse the XML to a Java object
            File file = new File("src/main/resources/hospital.xml");
            Hospital hospital = (Hospital) unmarshaller.unmarshal(file);

            // Log the parsed object
            logger.info("Hospital parsed from XML: ");
            logger.info(hospital.toString());

        } catch (JAXBException e) {
            logger.error("Error parsing XML", e);
        }

    }
    }

