package JavaProject.FramePage;

import JavaProject.FramePage.Customer.CustomerConfirm;
import JavaProject.FramePage.Customer.CustomerDetail;
import JavaProject.FramePage.Customer.CustomerPage1;
import JavaProject.FramePage.Staff.StaffDetail;
import JavaProject.FramePage.Staff.StaffPage;
import JavaProject.model.Booking;
import JavaProject.model.Customer;
import JavaProject.model.Staff;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MainFrame {

    private static Staff[] staffList = {
            new Staff("P01", "Chiew Chin Kuan", "0129318660", "S01", false, "07/02/2005"),
            new Staff("P02", "Sia Xin Wan", "0123456789", "S02", true, "03/05/2005"),
            new Staff("P03", "A'isyah Insyirah", "0148754099", "S03", false, "17/12/2005"),
            new Staff("P04", "Teoh Hui Yu", "0189518451", "S04", false, "27/10/2005")
    };

    static int[] singleRChoice = {1};
    static int[] familyRChoice = {1};
    static int[][] addonChoiceS = {{0, 0}};
    static int[][] addonChoiceF = {{0, 0, 0, 0, 0}};

    public static Vector<Booking> bookingDetails = new Vector<>(4, 2) {
        {
            //add(new Booking("B0002", "5/1/2025", "10/1/2025", 2, 1, 1, new int[]{1}, new int[]{1}, new int[][]{{0}}, new int[][]{{0, 0}}));
            add(new Booking("B0001", "1/1/2025", "7/1/2025", 2, 1, 1, singleRChoice, familyRChoice, addonChoiceS, addonChoiceF));
        }
    };// use to store run time booking details 

    
    
    private static Staff currentLoggedInStaff = null;

    public static Staff getCurrentStaff() {
        return currentLoggedInStaff;
    }

    public static void setCurrentStaff(Staff staff) {
        currentLoggedInStaff = staff;
    }

    
    

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cats Hotel Booking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        Customer customer = new Customer();

        // Card Panel to hold pages
        JPanel cardPanel = new JPanel(new CardLayout());

        // CardLayout instance
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();

        // Create pages
        WelcomePage welcomePage = new WelcomePage(
                e -> cardLayout.show(cardPanel, "CustomerPage1"), // Navigate to Customer Page 1
                e -> cardLayout.show(cardPanel, "Staff") // Navigate to Staff Page
        );

        CustomerPage1 customerPage1 = new CustomerPage1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to WelcomePage
                cardLayout.show(cardPanel, "Welcome");

            }
        }, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to CustomerPage
                cardLayout.show(cardPanel, "Customer");
            }
        }, bookingDetails);

        //CustomerPage customerPage = new CustomerPage(e -> cardLayout.show(cardPanel, "CustomerPage1"));

        StaffPage staffPage = new StaffPage(
                e -> cardLayout.show(cardPanel, "Welcome"), // Navigate to Welcome Page
                cardLayout, // CardLayout instance
                cardPanel,
                staffList);

        StaffDetail staffDetailPage = new StaffDetail(
                e -> cardLayout.show(cardPanel, "Welcome"));

        CustomerDetail customerDetail = new CustomerDetail(e -> cardLayout.show(cardPanel, "Customer"),customer);


        CustomerConfirm customerConfirm = new CustomerConfirm(e-> cardLayout.show(cardPanel, "CustomerDetail"),customer);

        // Add pages to card panel
        cardPanel.add(welcomePage, "Welcome");
        cardPanel.add(customerPage1, "CustomerPage1");
        //cardPanel.add(customerPage, "Customer");
        cardPanel.add(staffPage, "Staff");
        cardPanel.add(staffDetailPage, "StaffDetail");
        cardPanel.add(customerDetail, "CustomerDetail");
        cardPanel.add(customerConfirm, "CustomerConfirm");

        // Add card panel to frame
        frame.add(cardPanel, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}
