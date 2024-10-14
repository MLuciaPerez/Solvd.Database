package Model.classesHierarchy;

public class Nurse extends Person {
    private String shift;
    private Department department;

    // Constructor
    public Nurse(int id, String firstName, String lastName, String phone, String email, String shift, Department department) {
        super(id, firstName, lastName, phone, email);
        this.shift = shift;
        this.department = department;
    }

    // Getters
    public String getShift() {
        return shift;
    }

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
}
