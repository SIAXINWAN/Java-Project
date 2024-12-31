package JavaProject.FramePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WelcomePage extends JPanel {
    public WelcomePage(ActionListener toCustomerAction, ActionListener toStaffAction) {
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to Cats Hotel Booking System", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(welcomeLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton toCustomerPage = new JButton("Customer");
        JButton toStaffPage = new JButton("Staff");

        // Set button size and font
        toCustomerPage.setPreferredSize(new Dimension(150, 60));
        toStaffPage.setPreferredSize(new Dimension(150, 60));
        toCustomerPage.setFont(new Font("Arial", Font.BOLD, 18));
        toStaffPage.setFont(new Font("Arial", Font.BOLD, 18));

        // Add action listeners
        toCustomerPage.addActionListener(toCustomerAction);
        toStaffPage.addActionListener(toStaffAction);

        buttonPanel.add(toCustomerPage);
        buttonPanel.add(toStaffPage);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}