package Model.classesHierarchy;

public class Room {
    private int roomId;
    private String roomNumber;
    private String roomType;
    private boolean availability;

    // Constructor
    public Room(int roomId, String roomNumber, String roomType, boolean availability) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.availability = availability;
    }

    // Getters
    public int getRoomId() {
        return roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

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
}