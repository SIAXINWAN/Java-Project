package JavaProject.FramePage.Customer;

import java.awt.event.ActionListener;

import javax.swing.*;


import java.awt.*;

public class CustomerConfirm extends JPanel{
    public CustomerConfirm(ActionListener homeAction)
    {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Customer Confirm", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        add(titleLabel,BorderLayout.NORTH);

        JButton homeButton = new JButton("Cancel");
        homeButton.setFont(new Font("Arial", Font.BOLD, 16));
        homeButton.setPreferredSize(new Dimension(100, 40));
        homeButton.addActionListener(homeAction);

        JPanel homePanel = new JPanel();
        homePanel.add(homeButton);
        add(homePanel, BorderLayout.SOUTH);

        homeButton.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(
                homePanel, "Are you sure you want to cancel the booking?",
                "Cancel Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            
            if (choice == JOptionPane.YES_OPTION) {
                homeAction.actionPerformed(e); 
            }
        });
    }
}
