package JavaProject.FramePage;

import javax.swing.*;

import JavaProject.FramePage.Staff.StaffDetail;
import JavaProject.FramePage.Staff.StaffPage;
import JavaProject.model.Staff;

import java.awt.*;

public class MainFrame {

    private static Staff[] staffList = {
        new Staff("P01", "Chiew Chin Kuan", "0129318660", "S01", false, "07/02/2005"),
        new Staff("P02", "Chiew Chin Kuan", "0129318660", "S02", false, "07/02/2005"),
        new Staff("P03", "Chiew Chin Kuan", "0129318660", "S03", false, "07/02/2005"),
        new Staff("P04", "Chiew Chin Kuan", "0129318660", "S04", false, "07/02/2005")
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

        // Card Panel to hold pages
        JPanel cardPanel = new JPanel(new CardLayout());

        // CardLayout instance
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();

        final Staff[] currentStaff = new Staff[1];

        // Create pages
        WelcomePage welcomePage = new WelcomePage(
            e -> cardLayout.show(cardPanel, "Customer"), // Navigate to Customer Page
            e -> cardLayout.show(cardPanel, "Staff")     // Navigate to Staff Page
        );

        CustomerPage customerPage = new CustomerPage(
            e -> cardLayout.show(cardPanel, "Welcome")  // Navigate to Welcome Page
        );

        StaffPage staffPage = new StaffPage(
            e -> cardLayout.show(cardPanel, "Welcome"), // Navigate to Welcome Page
            cardLayout,                                 // CardLayout instance
            cardPanel,
            staffList
        );

        StaffDetail staffDetailPage = new StaffDetail(
            e -> cardLayout.show(cardPanel, "Welcome")
           );

        // Add pages to card panel
        cardPanel.add(welcomePage, "Welcome");
        cardPanel.add(customerPage, "Customer");
        cardPanel.add(staffPage, "Staff");
        cardPanel.add(staffDetailPage, "StaffDetail");

        // Add card panel to frame
        frame.add(cardPanel, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}

