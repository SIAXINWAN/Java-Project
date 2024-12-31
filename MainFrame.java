package JavaProject;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Cats Hotel Booking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Card Panel to hold all pages
        JPanel cardPanel = new JPanel(new CardLayout());

        // Welcome Page
        JPanel welcomePage = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome to Cats Hotel Booking System", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomePage.add(welcomeLabel, BorderLayout.CENTER);

        JPanel welcomeButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        JButton toCustomerPage = new JButton("Customer");
        JButton toStaffPage = new JButton("Staff");
        toCustomerPage.setFont(new Font("Arial", Font.BOLD, 22));
        toStaffPage.setFont(new Font("Arial", Font.BOLD, 22));

        // Set button size
        toCustomerPage.setPreferredSize(new Dimension(300, 120)); 
        toStaffPage.setPreferredSize(new Dimension(300, 120));

        // Add buttons to the panel
        welcomeButtonsPanel.add(toCustomerPage);
        welcomeButtonsPanel.add(toStaffPage);
        welcomePage.add(welcomeButtonsPanel, BorderLayout.SOUTH);

        // Customer Page
        JPanel customerPage = new JPanel(new BorderLayout());
        JLabel customerLabel = new JLabel("Customer Page", JLabel.CENTER);
        customerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        customerPage.add(customerLabel, BorderLayout.CENTER);

        JButton homeFromCustomer = new JButton("Home");
        JPanel customerHomePanel = new JPanel();
        customerHomePanel.add(homeFromCustomer);
        customerPage.add(customerHomePanel, BorderLayout.SOUTH);

        // Staff Page
        JPanel staffPage = new JPanel(new BorderLayout());
        JLabel staffLabel = new JLabel("Staff Page", JLabel.CENTER);
        staffLabel.setFont(new Font("Arial", Font.BOLD, 20));
        staffPage.add(staffLabel, BorderLayout.CENTER);

        JButton homeFromStaff = new JButton("Home");
        JPanel staffHomePanel = new JPanel();
        staffHomePanel.add(homeFromStaff);
        staffPage.add(staffHomePanel, BorderLayout.SOUTH);

        // Add pages to the card panel
        cardPanel.add(welcomePage, "Welcome");
        cardPanel.add(customerPage, "Customer");
        cardPanel.add(staffPage, "Staff");

        // CardLayout logic for navigation
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();

        // Button actions
        toCustomerPage.addActionListener(e -> cardLayout.show(cardPanel, "Customer"));
        toStaffPage.addActionListener(e -> cardLayout.show(cardPanel, "Staff"));
        homeFromCustomer.addActionListener(e -> cardLayout.show(cardPanel, "Welcome"));
        homeFromStaff.addActionListener(e -> cardLayout.show(cardPanel, "Welcome"));

        // Add the card panel to the frame
        frame.add(cardPanel, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}
