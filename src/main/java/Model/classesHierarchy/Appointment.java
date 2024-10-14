package Model.classesHierarchy;

public class Appointment {
    private int appointmentId;
    private String appointmentDate;
    private String appointmentTime;
    private Doctor doctor;
    private Patient patient;
    private Room room;

    // Constructor
    public Appointment(int appointmentId, String appointmentDate, String appointmentTime, Doctor doctor, Patient patient, Room room) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.doctor = doctor;
        this.patient = patient;
        this.room = room;
    }

    // Getters
    public int getAppointmentId() {
        return appointmentId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Room getRoom() {
        return room;
    }

    // Setters
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
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
}