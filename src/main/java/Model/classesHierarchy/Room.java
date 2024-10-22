package Model.classesHierarchy;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "room")
@XmlAccessorType(XmlAccessType.FIELD)
public class Room {

    @JsonProperty("roomId")
    private int roomId;
    @JsonProperty("roomNumber")
    private String roomNumber;
    @JsonProperty("roomType")
    private String roomType;
    @JsonProperty("availability")
    private boolean availability;

    // Constructor
    public Room() {}

    public Room(int roomId, String roomNumber, String roomType, boolean availability) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.availability = availability;
    }

    // Getters

    @XmlElement(name = "isAvailable")
    public boolean isAvailable() {
        return availability;
    }

    // Setters
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                ", availability=" + availability +
                '}';
    }
}