package JavaProject.model;
public class Customer extends Person {
    private String customerID;
    private String customerEmail;

    public Customer() {}

    public Customer(String customerID, String customerEmail) {
        this.customerID = customerID;
        this.customerEmail = customerEmail;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void Booking() {
        System.out.println("Booking room for customer " + customerID);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Customer ID: " + customerID + ", Email: " + customerEmail);
    }
}
