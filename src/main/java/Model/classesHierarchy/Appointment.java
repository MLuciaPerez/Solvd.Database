package Model.classesHierarchy;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "appointment")
@XmlType(propOrder = {"appointmentId", "date", "appointmentTime", "doctor", "patient", "room"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Appointment {
    private int appointmentId;
    private String date;
    private String appointmentTime;
    private Doctor doctor;
    private Patient patient;
    private Room room;

    // Constructor
    public Appointment() {}

    public Appointment(int appointmentId, String date, String appointmentTime, Doctor doctor, Patient patient, Room room) {
        this.appointmentId = appointmentId;
        this.date = date;
        this.appointmentTime = appointmentTime;
        this.doctor = doctor;
        this.patient = patient;
        this.room = room;
    }


    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }


    public void setAppointmentDate(String date) {
        this.date = date;
    }


    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }


    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", date='" + date + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", room=" + room +
                '}';
    }
}