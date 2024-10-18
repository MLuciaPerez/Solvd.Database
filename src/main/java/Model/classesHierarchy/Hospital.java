package Model.classesHierarchy;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "hospital")
public class Hospital {

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    private List<Department> departments;

    @XmlElementWrapper(name = "doctors")
    @XmlElement(name = "doctor")
    private List<Doctor> doctors;

    @XmlElementWrapper(name = "nurses")
    @XmlElement(name = "nurse")
    private List<Nurse> nurses;

    @XmlElementWrapper(name = "patients")
    @XmlElement(name = "patient")
    private List<Patient> patients;

    @XmlElementWrapper(name = "rooms")
    @XmlElement(name = "room")
    private List<Room> rooms;

    @XmlElementWrapper(name = "appointments")
    @XmlElement(name = "appointment")
    private List<Appointment> appointments;

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "departments=" + departments +
                ", nurses=" + nurses +
                ", doctors=" + doctors +
                ", patients=" + patients +
                ", rooms=" + rooms +
                ", appointments=" + appointments +
                '}';
    }
}