package JavaProject.model;
public class Customer extends Person {
    private String customerID; //C0001      max = 9999
    private String customerName;
    private String customerEmail;
    private String customerPhoneNO;

    public Customer() {}

    public Customer(String customerID, String customerName, String customerPhone, String customerEmail) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerPhoneNO = customerPhone;
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

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhoneNO() {
        return customerPhoneNO;
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
