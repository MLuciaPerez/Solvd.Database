package Model.classesHierarchy;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "patient")
public class Patient extends Person {
    private String birthDate;
    private String address;

    // Constructor
    public Patient() {}

    public Patient(int id, String firstName, String lastName, String phone, String email, String birthDate, String address) {
        super(id, firstName, lastName, phone, email);
        this.birthDate = birthDate;
        this.address = address;
    }

    // Getters y Setters
    @XmlElement
    public String getBirthDate() {
        return birthDate;
    }

    @XmlElement
    public String getAddress() {
        return address;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "birthDate='" + birthDate + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}