package Model.classesHierarchy;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "nurse")
public class Nurse extends Person {
    private String shift;
    private Department department;

    // Constructor

    public Nurse() {}

    public Nurse(int id, String firstName, String lastName, String phone, String email, String shift, Department department) {
        super(id, firstName, lastName, phone, email);
        this.shift = shift;
        this.department = department;
    }

    // Getters
    @XmlElement
    public String getShift() {
        return shift;
    }

    @XmlElement
    public Department getDepartment() {
        return department;
    }

    // Setters
    public void setShift(String shift) {
        this.shift = shift;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "shift='" + shift + '\'' +
                ", department=" + department +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
