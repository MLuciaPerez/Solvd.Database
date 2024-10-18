package Model.classesHierarchy;

import javax.xml.bind.annotation.XmlElement;

public abstract class Person {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String phone;
    protected String email;

    // Constructor
    public Person() {}

    public Person(int id, String firstName, String lastName, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    // Getters
    @XmlElement
    public int getId() {
        return id;
    }

    @XmlElement
    public String getFirstName() {
        return firstName;
    }

    @XmlElement
    public String getLastName() {
        return lastName;
    }

    @XmlElement
    public String getPhone() {
        return phone;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    // Setters
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
