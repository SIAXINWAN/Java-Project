package JavaProject.FramePage.Staff;

import javax.swing.*;

import JavaProject.FramePage.MainFrame;
import JavaProject.model.Staff;

import java.awt.*;
import java.awt.event.ActionListener;

public class StaffDetail extends JPanel {

    private JPanel detailsPanel;

    private void addDetailField(JPanel panel, String label, String value) {
        JPanel fieldPanel = new JPanel(new BorderLayout(10, 0));
        fieldPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        JLabel labelComponent = new JLabel(label, JLabel.RIGHT);
        JLabel valueComponent = new JLabel(value, JLabel.LEFT);
        
        labelComponent.setFont(new Font("Arial", Font.BOLD, 14));
        valueComponent.setFont(new Font("Arial", Font.PLAIN, 14));
        
        fieldPanel.add(labelComponent, BorderLayout.WEST);
        fieldPanel.add(valueComponent, BorderLayout.CENTER);
        panel.add(fieldPanel);
    }

    private void updateDetailsPanel()
    {
        detailsPanel.removeAll();

        Staff currentStaff = MainFrame.getCurrentStaff();
        if (currentStaff != null) {
            detailsPanel.setLayout(new GridLayout(2, 2, 20, 20));
            addDetailField(detailsPanel, "Staff ID:", currentStaff.getStaffID());
            addDetailField(detailsPanel, "Name:", currentStaff.getName());
            addDetailField(detailsPanel, "Gender:", (currentStaff.getGender()?"Male":"Female"));
            addDetailField(detailsPanel, "Birtrhday:", currentStaff.getDateOfBirth());
            
        }
        else{
            addDetailField(detailsPanel, "No staff data available", " ");
        }

        detailsPanel.revalidate();
        detailsPanel.repaint();
    }

    public StaffDetail(ActionListener homeAction) {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Staff Details", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        JPanel mainContent = new JPanel(new BorderLayout());
        
        detailsPanel = new JPanel();
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        
        mainContent.add(detailsPanel, BorderLayout.NORTH);

        JButton logoutButton = new JButton("Logout");
logoutButton.setFont(new Font("Arial", Font.BOLD, 16)); // Match the font size of homeButton
logoutButton.setPreferredSize(new Dimension(100, 40)); // Match the dimensions of homeButton
logoutButton.setBackground(new Color(220, 53, 69)); // Red color for logout
logoutButton.setForeground(Color.WHITE);
logoutButton.setFocusPainted(false); 
        
        logoutButton.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(
                StaffDetail.this,
                "Are you sure you want to logout?",
                "Logout Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            
            if (choice == JOptionPane.YES_OPTION) {
                MainFrame.setCurrentStaff(null); 
                homeAction.actionPerformed(e); 
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(logoutButton);

        add(titleLabel, BorderLayout.NORTH);
        add(mainContent, BorderLayout.CENTER);
        add(logoutButton, BorderLayout.SOUTH);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent evt) {
                updateDetailsPanel();
            }
        });
    }
}
