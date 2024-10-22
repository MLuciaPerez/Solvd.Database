package Model.classesHierarchy;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "appointment")
@XmlType(propOrder = {"appointmentId", "date", "appointmentTime", "doctor", "patient", "room"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Appointment {

    @JsonProperty("appointmentId")
    private int appointmentId;
    @JsonProperty("date")
    private String date;
    @JsonProperty("appointmentTime")
    private String appointmentTime;
    @JsonProperty("doctor")
    private Doctor doctor;
    @JsonProperty("patient")
    private Patient patient;
    @JsonProperty("room")
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