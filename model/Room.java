package JavaProject.model;
public class Room {
    private String roomNumber;
    private String roomType;
    private double price;
    private double grandPrice;
    private String roomAddons;

    public Room() {}

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setRoomAddons(String roomAddons) {
        this.roomAddons = roomAddons;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomAddons() {
        return roomAddons;
    }

    public double getPrice() {
        return price;
    }

    public double calculateGrandPrice() {
        grandPrice = price + (roomAddons != null ? 50 : 0); // Example calculation
        return grandPrice;
    }

    public void displayInfo() {
        System.out.println("Room Number: " + roomNumber + ", Type: " + roomType + ", Price: " + price);
    }
}