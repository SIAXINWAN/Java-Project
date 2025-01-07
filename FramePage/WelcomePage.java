package JavaProject.FramePage;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WelcomePage extends JPanel {
    public WelcomePage(ActionListener toCustomerAction, ActionListener toStaffAction) {
        setLayout(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon("JavaProject\\assets\\CAtS.png"); // Replace with the actual image path
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel, BorderLayout.NORTH);

        //System.out.println(new File("JavaProject\\assets\\Screenshot1.png").getAbsolutePath());

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
