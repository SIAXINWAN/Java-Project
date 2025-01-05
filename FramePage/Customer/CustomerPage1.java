package JavaProject.FramePage.Customer;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CustomerPage1 extends JPanel{
    JPanel panel1 = new JPanel();

    public CustomerPage1(ActionListener homeAction)
    {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Customer Booking", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        add(titleLabel,BorderLayout.NORTH);

        JButton homeButton = new JButton("Home");
        homeButton.setFont(new Font("Arial", Font.BOLD, 16));
        homeButton.setPreferredSize(new Dimension(100, 40));
        homeButton.addActionListener(homeAction);

        JPanel homePanel = new JPanel();
        homePanel.add(homeButton);
        add(homePanel, BorderLayout.SOUTH);

        JLabel label1 = new JLabel("This is your choosen room option : ");
    }
}
