package Model.classesHierarchy;

public class Patient extends Person {
    private String birthDate;
    private String address;

    // Constructor
    public Patient(int id, String firstName, String lastName, String phone, String email, String birthDate, String address) {
        super(id, firstName, lastName, phone, email);
        this.birthDate = birthDate;
        this.address = address;
    }

    // Getters y Setters
    public String getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}