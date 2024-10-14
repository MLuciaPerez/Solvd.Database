package Model.classesHierarchy;

public class Doctor extends Person {
    private String specialization;
    private int departmentId;

    // Constructor
    public Doctor(int id, String firstName, String lastName, String phone, String email, String specialization, int departmentId) {
        super(id, firstName, lastName, phone, email);
        this.specialization = specialization;
        this.departmentId = departmentId;
    }

    // Getters
    public String getSpecialization() {
        return specialization;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    // Setters
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}