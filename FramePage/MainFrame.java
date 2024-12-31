package JavaProject.FramePage;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cats Hotel Booking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Card Panel to hold pages
        JPanel cardPanel = new JPanel(new CardLayout());

        // CardLayout instance
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();

        // Create pages
        WelcomePage welcomePage = new WelcomePage(
            e -> cardLayout.show(cardPanel, "Customer"), // Navigate to Customer Page
            e -> cardLayout.show(cardPanel, "Staff")     // Navigate to Staff Page
        );

        CustomerPage customerPage = new CustomerPage(
            e -> cardLayout.show(cardPanel, "Welcome")  // Navigate to Welcome Page
        );

        StaffPage staffPage = new StaffPage(
            e -> cardLayout.show(cardPanel, "Welcome")  // Navigate to Welcome Page
        );

        // Add pages to card panel
        cardPanel.add(welcomePage, "Welcome");
        cardPanel.add(customerPage, "Customer");
        cardPanel.add(staffPage, "Staff");

        // Add card panel to frame
        frame.add(cardPanel, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}

