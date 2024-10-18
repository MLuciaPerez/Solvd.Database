package Model.classesHierarchy;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "doctor")
public class Doctor extends Person {
    private String specialization;
    private int departmentId;


    // Constructor

    public Doctor() {}

    public Doctor(int id, String firstName, String lastName, String phone, String email, String specialization, int departmentId) {
        super(id, firstName, lastName, phone, email);
        this.specialization = specialization;
        this.departmentId = departmentId;
    }

    @XmlElement
    public String getSpecialization() {
        return specialization;
    }

    @XmlElement
    public int getDepartmentId() {
        return departmentId;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "specialization='" + specialization + '\'' +
                ", departmentId=" + departmentId +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}