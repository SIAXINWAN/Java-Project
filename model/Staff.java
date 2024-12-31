package JavaProject.model;
public class Staff extends Person {
    private String staffID;
    private boolean gender;
    private String dateOfBirth;

    public Staff() {}

    public Staff(String staffID, boolean gender, String dateOfBirth) {
        this.staffID = staffID;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
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

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Staff ID: " + staffID + ", Gender: " + (gender ? "Male" : "Female") + ", DOB: " + dateOfBirth);
    }
}