package JavaProject.model;

public class Booking {
    public static final int roomMax = 10;
    public static final int SingleMax = 3;
    public static final int FamilyMax = 7;
    public static final int AddonSingleBil = 2;
    public static final int AddonFamilyBil = 5;

    private String BookingID; // B0001      max = 9999
    private String CustomerID;
    private String CheckInDate;
    private String CheckOutDate;

    private int roomBil;
    private int singleRoom;
    private int familyRoom;

    private int SingleRChoice[] = new int[SingleMax];
    private int FamilyRChoice[] = new int[FamilyMax];
    private int AddonChoiceS[][] = new int[SingleMax][AddonSingleBil];
    private int AddonChoiceF[][] = new int[FamilyMax][AddonFamilyBil];

    public Booking(String BookingID)
    {
        this.BookingID = BookingID;
    }

    public Booking(String BookingID, String CheckInDate, String CheckOutDate, int roomBil, int singleRoom, int familyRoom, 
        int SingleRChoice[], int FamilyRChoice[], int AddonChoiceS[][], int AddonChoiceF[][], String customerID)
    {
        this.BookingID = BookingID;
        this.CheckInDate = CheckInDate;
        this.CheckOutDate = CheckOutDate;
        this.roomBil = roomBil;
        this.singleRoom = singleRoom;
        this.familyRoom = familyRoom;
        this.SingleRChoice = SingleRChoice;
        this.FamilyRChoice = FamilyRChoice;
        this.AddonChoiceS = AddonChoiceS;
        this.AddonChoiceF = AddonChoiceF;
        this.CustomerID = customerID;
    }

    public String getBookingID()
    {
        return this.BookingID;
    }

    public void setCustomerID(String customerID)
    {
        this.CustomerID = customerID;
    }

    public String getCustomerID()
    {
        return this.CustomerID;
    }

    public void setCheckDate(String CheckInDate, String CheckOutDate)
    {
        this.CheckInDate = CheckInDate;
        this.CheckOutDate = CheckOutDate;
    }

    public String getCheckInDate()
    {
        return this.CheckInDate;
    }

    public String getCheckOutDate()
    {
        return this.CheckOutDate;
    }

    public void setRoomBilangan(int roomBil, int singleRoom, int familyRoom)
    {
        this.roomBil = roomBil;
        this.singleRoom = singleRoom;
        this.familyRoom = familyRoom;
    }

    public int getroomBil()
    {
        return this.roomBil;
    }

    public int getsingleRoom()
    {
        return this.singleRoom;
    }

    public int getfamilyRoom()
    {
        return this.familyRoom;
    }

    public void setRoomChoises(int[] SingleRChoice, int[] FamilyRChoice)
    {
        this.SingleRChoice = SingleRChoice;
        this.FamilyRChoice = FamilyRChoice;
    }

    public int[] getSingleRChoice()
    {
        return SingleRChoice;
    }

    public int[] getFamilyRChoice()
    {
        return FamilyRChoice;
    }

    public void setAddonChoises(int[][] AddonChoiceS, int[][] AddonChoiceF)
    {
        this.AddonChoiceS = AddonChoiceS;
        this.AddonChoiceF = AddonChoiceF;
    }

     public int[][] getAddonChoiceS()
    {
        return AddonChoiceS;
    }

    public int[][] getAddonChoiceF()
    {
        return AddonChoiceF;
    }
}
