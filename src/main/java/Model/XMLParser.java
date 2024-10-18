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
                LOGGER.info(" - Department ID: " + department.getElementsByTagName("departmentId").item(0).getTextContent());
                LOGGER.info("   Department Name: " + department.getElementsByTagName("departmentName").item(0).getTextContent());
            }

            // Get nurses
            Element nurses = (Element) document.getElementsByTagName("nurses").item(0);
            LOGGER.info("Nurses:");
            for (int i = 0; i < nurses.getElementsByTagName("nurse").getLength(); i++) {
                Element nurse = (Element) nurses.getElementsByTagName("nurse").item(i);
                LOGGER.info(" - Nurse ID: " + nurse.getElementsByTagName("id").item(0).getTextContent());
                LOGGER.info("   Name: " + nurse.getElementsByTagName("firstName").item(0).getTextContent() + " " +
                        nurse.getElementsByTagName("lastName").item(0).getTextContent());
                LOGGER.info("   Shift: " + nurse.getElementsByTagName("shift").item(0).getTextContent());
                LOGGER.info("   Department ID: " + nurse.getElementsByTagName("departmentId").item(0).getTextContent());
                LOGGER.info("   Department Name: " + nurse.getElementsByTagName("departmentName").item(0).getTextContent());
            }

            // Get doctors
            Element doctors = (Element) document.getElementsByTagName("doctors").item(0);
            LOGGER.info("Doctors:");
            for (int i = 0; i < doctors.getElementsByTagName("doctor").getLength(); i++) {
                Element doctor = (Element) doctors.getElementsByTagName("doctor").item(i);
                LOGGER.info(" - Doctor ID: " + doctor.getElementsByTagName("id").item(0).getTextContent());
                LOGGER.info("   Name: " + doctor.getElementsByTagName("firstName").item(0).getTextContent() + " " +
                        doctor.getElementsByTagName("lastName").item(0).getTextContent());
                LOGGER.info("   Specialization: " + doctor.getElementsByTagName("specialization").item(0).getTextContent());
                LOGGER.info("   Department ID: " + doctor.getElementsByTagName("departmentId").item(0).getTextContent());
            }

            // Get patients
            Element patients = (Element) document.getElementsByTagName("patients").item(0);
            LOGGER.info("Patients:");
            for (int i = 0; i < patients.getElementsByTagName("patient").getLength(); i++) {
                Element patient = (Element) patients.getElementsByTagName("patient").item(i);
                LOGGER.info(" - Patient ID: " + patient.getElementsByTagName("id").item(0).getTextContent());
                LOGGER.info("   Name: " + patient.getElementsByTagName("firstName").item(0).getTextContent() + " " +
                        patient.getElementsByTagName("lastName").item(0).getTextContent());
                LOGGER.info("   Birth Date: " + patient.getElementsByTagName("birthDate").item(0).getTextContent());
                LOGGER.info("   Address: " + patient.getElementsByTagName("address").item(0).getTextContent());
            }

            // Get rooms
            Element rooms = (Element) document.getElementsByTagName("rooms").item(0);
            LOGGER.info("Rooms:");
            for (int i = 0; i < rooms.getElementsByTagName("room").getLength(); i++) {
                Element room = (Element) rooms.getElementsByTagName("room").item(i);
                LOGGER.info(" - Room ID: " + room.getElementsByTagName("roomId").item(0).getTextContent());
                LOGGER.info("   Room Number: " + room.getElementsByTagName("roomNumber").item(0).getTextContent());
                LOGGER.info("   Room Type: " + room.getElementsByTagName("roomType").item(0).getTextContent());
                LOGGER.info("   Availability: " + room.getElementsByTagName("availability").item(0).getTextContent());
            }

            // Get appointments
            Element appointments = (Element) document.getElementsByTagName("appointments").item(0);
            LOGGER.info("Appointments:");
            for (int i = 0; i < appointments.getElementsByTagName("appointment").getLength(); i++) {
                Element appointment = (Element) appointments.getElementsByTagName("appointment").item(i);
                LOGGER.info(" - Appointment ID: " + appointment.getElementsByTagName("appointmentId").item(0).getTextContent());
                LOGGER.info("   Date: " + appointment.getElementsByTagName("date").item(0).getTextContent());
                LOGGER.info("   Time: " + appointment.getElementsByTagName("appointmentTime").item(0).getTextContent());

                // Doctor details
                Element doctor = (Element) appointment.getElementsByTagName("doctor").item(0);
                LOGGER.info("   Doctor: " + doctor.getElementsByTagName("firstName").item(0).getTextContent() + " " +
                        doctor.getElementsByTagName("lastName").item(0).getTextContent());

                // Patient details
                Element patient = (Element) appointment.getElementsByTagName("patient").item(0);
                LOGGER.info("   Patient: " + patient.getElementsByTagName("firstName").item(0).getTextContent() + " " +
                        patient.getElementsByTagName("lastName").item(0).getTextContent());

                // Room details
                Element room = (Element) appointment.getElementsByTagName("room").item(0);
                LOGGER.info("   Room Number: " + room.getElementsByTagName("roomNumber").item(0).getTextContent());
            }

        } catch (Exception e) {
            LOGGER.severe("An error occurred while parsing XML: " + e.getMessage());
        }
    }
}