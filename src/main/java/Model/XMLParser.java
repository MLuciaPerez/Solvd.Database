package Model;


import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.logging.Logger;

public class XMLParser {
    private static final String XML_FILE_PATH = "src/main/resources/hospital.xml";
    private static final Logger LOGGER = Logger.getLogger(XMLParser.class.getName());

    public static void parseXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(XML_FILE_PATH));

            // Normalize the XML structure
            document.getDocumentElement().normalize();
            LOGGER.info("Root element: " + document.getDocumentElement().getNodeName());

            // Get departments
            Element departments = (Element) document.getElementsByTagName("departments").item(0);
            LOGGER.info("Departments:");
            for (int i = 0; i < departments.getElementsByTagName("department").getLength(); i++) {
                Element department = (Element) departments.getElementsByTagName("department").item(i);
                LOGGER.info(" - ID: " + department.getElementsByTagName("id").item(0).getTextContent());
                LOGGER.info("   Name: " + department.getElementsByTagName("name").item(0).getTextContent());
            }

            // Get nurses
            Element nurses = (Element) document.getElementsByTagName("nurses").item(0);
            LOGGER.info("Nurses:");
            for (int i = 0; i < nurses.getElementsByTagName("nurse").getLength(); i++) {
                Element nurse = (Element) nurses.getElementsByTagName("nurse").item(i);
                LOGGER.info(" - ID: " + nurse.getElementsByTagName("id").item(0).getTextContent());
                LOGGER.info("   Name: " + nurse.getElementsByTagName("firstName").item(0).getTextContent() + " " +
                        nurse.getElementsByTagName("lastName").item(0).getTextContent());
                LOGGER.info("   Shift: " + nurse.getElementsByTagName("shift").item(0).getTextContent());
            }

            // Get doctors
            Element doctors = (Element) document.getElementsByTagName("doctors").item(0);
            LOGGER.info("Doctors:");
            for (int i = 0; i < doctors.getElementsByTagName("doctor").getLength(); i++) {
                Element doctor = (Element) doctors.getElementsByTagName("doctor").item(i);
                LOGGER.info(" - ID: " + doctor.getElementsByTagName("id").item(0).getTextContent());
                LOGGER.info("   Name: " + doctor.getElementsByTagName("firstName").item(0).getTextContent() + " " +
                        doctor.getElementsByTagName("lastName").item(0).getTextContent());
                LOGGER.info("   Specialty: " + doctor.getElementsByTagName("specialty").item(0).getTextContent());
            }

            // Get patients
            Element patients = (Element) document.getElementsByTagName("patients").item(0);
            LOGGER.info("Patients:");
            for (int i = 0; i < patients.getElementsByTagName("patient").getLength(); i++) {
                Element patient = (Element) patients.getElementsByTagName("patient").item(i);
                LOGGER.info(" - ID: " + patient.getElementsByTagName("id").item(0).getTextContent());
                LOGGER.info("   Name: " + patient.getElementsByTagName("firstName").item(0).getTextContent() + " " +
                        patient.getElementsByTagName("lastName").item(0).getTextContent());
            }

            // Get rooms
            Element rooms = (Element) document.getElementsByTagName("rooms").item(0);
            LOGGER.info("Rooms:");
            for (int i = 0; i < rooms.getElementsByTagName("room").getLength(); i++) {
                Element room = (Element) rooms.getElementsByTagName("room").item(i);
                LOGGER.info(" - Room ID: " + room.getElementsByTagName("roomId").item(0).getTextContent());
                LOGGER.info("   Number: " + room.getElementsByTagName("roomNumber").item(0).getTextContent());
            }

            // Get appointments
            Element appointments = (Element) document.getElementsByTagName("appointments").item(0);
            LOGGER.info("Appointments:");
            for (int i = 0; i < appointments.getElementsByTagName("appointment").getLength(); i++) {
                Element appointment = (Element) appointments.getElementsByTagName("appointment").item(i);
                LOGGER.info(" - Appointment ID: " + appointment.getElementsByTagName("appointmentId").item(0).getTextContent());
                LOGGER.info("   Date: " + appointment.getElementsByTagName("appointmentDate").item(0).getTextContent());
                LOGGER.info("   Time: " + appointment.getElementsByTagName("appointmentTime").item(0).getTextContent());
            }

        } catch (Exception e) {
            LOGGER.info("An error occurred while parsing XML");
        }
    }
}