package Model.classesHierarchy;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;

public abstract class Person {
    @JsonProperty("id")
    protected int id;
    @JsonProperty("firstName")
    protected String firstName;
    @JsonProperty("lastName")
    protected String lastName;
    @JsonProperty("phone")
    protected String phone;
    @JsonProperty("email")
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
