package JavaProject;
public class Person {
    private String personID;
    private String name;
    private String phoneNumber;

    public Person() {}

    public Person(String personID, String name, String phoneNumber) {
        this.personID = personID;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPersonID() {
        return personID;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void displayInfo() {
        System.out.println("ID: " + personID + ", Name: " + name + ", Phone: " + phoneNumber);
    }
}
