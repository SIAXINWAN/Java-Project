package JavaProject.model;
public class Staff extends Person {
    private String staffID;
    private boolean gender; // 1 - male     0 - female
    private String dateOfBirth;
    private String passwordString;

    public Staff() {}

    public Staff(String personID, String name, String phoneNumber, String staffID, boolean gender, String dateOfBirth) {
        super(personID, name, phoneNumber);
        this.staffID = staffID;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.passwordString = personID + staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStaffID() {
        return staffID;
    }

    public boolean getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPassword()
    {
        return passwordString;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Staff ID: " + staffID + ", Gender: " + (gender ? "Male" : "Female") + ", DOB: " + dateOfBirth);
    }
}