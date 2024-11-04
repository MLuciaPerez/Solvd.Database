import Model.*;
import Model.DAO.DoctorDAO;
import Model.classesHierarchy.Department;
import Model.classesHierarchy.Doctor;
import Model.classesHierarchy.Hospital;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
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



        logger.info("JSON ");
        // Create ObjectMapper for JSON operations
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Create sample data
        Department cardiology = new Department(1, "Cardiology");
        Doctor doctor1 = new Doctor(1, "Juan", "Perez", "123-456-7890", "juan@example.com", "Cardiologist", cardiology.getDepartmentId());

        Hospital hospital = new Hospital();
        hospital.getDepartments().add(cardiology);
        hospital.getDoctors().add(doctor1);

        // Create the HospitalContainer
        HospitalContainer container = new HospitalContainer();
        container.setHospital(hospital);

        // Serialize HospitalContainer object to JSON
        try {
            String hospitalJson = mapper.writeValueAsString(container);
            logger.info("Serialized JSON:\n" + hospitalJson);

            // Save JSON to file
            mapper.writeValue(new File("hospital.json"), container);
            logger.info("JSON file created: hospital.json");

        } catch (JsonProcessingException e) {
            logger.error("Error serializing hospital object to JSON", e);
        } catch (IOException e) {
            logger.error("Error writing JSON file", e);
        }

        // Deserialize JSON file to HospitalContainer object
        try {
            HospitalContainer containerFromJson = mapper.readValue(new File("hospital.json"), HospitalContainer.class);
            Hospital hospitalFromJson = containerFromJson.getHospital();
            logger.info("Deserialized Hospital from JSON: " + hospitalFromJson);

        } catch (IOException e) {
            logger.error("Error deserializing JSON file", e);
        }

        // READ JSON
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("src/main/resources/hospital.json");


            HospitalContainer container2 = objectMapper.readValue(file, HospitalContainer.class);


            Hospital hospital2 = container2.getHospital();
            System.out.println("Hospital read from JSON:");
            System.out.println(hospital2);

            logger.info("Hospital read successfully from JSON.");

        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error reading JSON", e);
        }


        String xmlFilePath = "src/main/resources/hospital.xml";

        // Parsear usando SAX
        logger.info("Parsing XML using SAX...");
        XMLParserSAX.parseXML();

        // Parsear usando StAX
        logger.info("Parsing XML using StAX...");
        XMLParserStAX.parseXML(xmlFilePath);

    }
    }

