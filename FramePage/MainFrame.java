package JavaProject.FramePage;

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

    public static Staff[] staffList = {
            new Staff("P01", "Chiew Chin Kuan", "0129318660", "S01", false, "07/02/2005"),
            new Staff("P02", "Sia Xin Wan", "0123456789", "S02", true, "03/05/2005"),
            new Staff("P03", "A'isyah Insyirah", "0148754099", "S03", false, "17/12/2005"),
            new Staff("P04", "Teoh Hui Yu", "0189518451", "S04", false, "27/10/2005")
    };

    public static Vector<Customer> customerDetails = new Vector<>(4, 2) {
        {
            add(new Customer("C0001", "Alexandar Khoo", "018-2834765", "alexk@gmail.com"));
            add(new Customer("C0002", "Siti Khadijah", "016-8764582", "sk123@yahoo.com"));
            add(new Customer("C0003", "Mutu", "012-4563728", "mutu@gmail.com"));
            add(new Customer("C0004", "Tan Xiao Ming", "011-5432567", "xiaoming@gmail.com"));
        }
    };

    static int[] singleRChoice = { 1 };
    static int[] familyRChoice = { 1 };
    static int[][] addonChoiceS = { { 0, 0 } };
    static int[][] addonChoiceF = { { 0, 0, 0, 0, 0 } };

    public static Vector<Booking> bookingDetails = new Vector<>(4, 2) {
        {
            add(new Booking("B0001", "1/1/2025", "7/1/2025", 6, 2, 1, 1, singleRChoice, familyRChoice, addonChoiceS,
                    addonChoiceF, "C0001"));
            add(new Booking("B0002", "6/2/2025", "9/2/2025", 6, 2, 1, 1, singleRChoice, familyRChoice, addonChoiceS,
                    addonChoiceF, "C0002"));
            add(new Booking("B0003", "16/2/2025", "18/2/2025", 6, 2, 1, 1, singleRChoice, familyRChoice, addonChoiceS,
                    addonChoiceF, "C0003"));
            add(new Booking("B0004", "4/3/2025", "5/3/2025", 6, 2, 1, 1, singleRChoice, familyRChoice, addonChoiceS,
                    addonChoiceF, "C0004"));
        }
    };

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

        JPanel cardPanel = new JPanel(new CardLayout());

        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();

        WelcomePage welcomePage = new WelcomePage(
                e -> cardLayout.show(cardPanel, "CustomerPage1"),
                e -> cardLayout.show(cardPanel, "Staff"));

        CustomerPage1 customerPage1 = new CustomerPage1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Welcome");

            }
        }, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Customer");
            }
        }, bookingDetails);

        StaffPage staffPage = new StaffPage(
                e -> cardLayout.show(cardPanel, "Welcome"),
                cardLayout,
                cardPanel,
                staffList);

        StaffDetail staffDetailPage = new StaffDetail(
                e -> cardLayout.show(cardPanel, "Welcome"));

        cardPanel.add(welcomePage, "Welcome");
        cardPanel.add(customerPage1, "CustomerPage1");
        cardPanel.add(staffPage, "Staff");
        StaffDetail.refreshData();
        cardPanel.add(staffDetailPage, "StaffDetail");

        frame.add(cardPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
