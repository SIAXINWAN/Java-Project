package JavaProject.FramePage.Staff;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import JavaProject.FramePage.MainFrame;
import JavaProject.model.Staff;

public class StaffDetail extends JPanel {
    private JPanel detailsPanel;
    private JTable staffTable;
    private DefaultTableModel tableModel;
    private JComboBox<String> filterComboBox;

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

    private void updateDetailsPanel() {
        detailsPanel.removeAll();

        Staff currentStaff = MainFrame.getCurrentStaff();
        if (currentStaff != null) {
            detailsPanel.setLayout(new GridLayout(2, 2, 20, 20));
            addDetailField(detailsPanel, "Staff ID:", currentStaff.getStaffID());
            addDetailField(detailsPanel, "Name:", currentStaff.getName());
            addDetailField(detailsPanel, "Gender:", (currentStaff.getGender() ? "Male" : "Female"));
            addDetailField(detailsPanel, "Birthday:", currentStaff.getDateOfBirth());
        } else {
            addDetailField(detailsPanel, "No staff data available", " ");
        }

        detailsPanel.revalidate();
        detailsPanel.repaint();
    }

    private void initializeTable() {
        // Create table model with 8 columns
        String[] columnNames = {"StaffID", "Check In Date", "Check Out Date", "Single Room", 
                              "Family Room", "Customer Name"};
        tableModel = new DefaultTableModel(columnNames, 0);
        staffTable = new JTable(tableModel);

        // Add some dummy data (6 rows)
        for (int i = 0; i < 8; i++) {
            Object[] row = new Object[8];
            for (int j = 0; j < 8; j++) {
                row[j] = "Row " + (i + 1) + ", Col " + (j + 1);
            }
            tableModel.addRow(row);
        }


        // Set table properties
        staffTable.setFillsViewportHeight(true);
        staffTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
   
        staffTable.setRowHeight(40);  // Increase row height to 40 pixels
    
    // Set column widths
    staffTable.getColumnModel().getColumn(0).setPreferredWidth(100);  // StaffID
    staffTable.getColumnModel().getColumn(1).setPreferredWidth(100);  // Check In Date
    staffTable.getColumnModel().getColumn(2).setPreferredWidth(100);  // Check Out Date
    staffTable.getColumnModel().getColumn(3).setPreferredWidth(100);  // Single Room
    staffTable.getColumnModel().getColumn(4).setPreferredWidth(100);  // Family Room
    staffTable.getColumnModel().getColumn(5).setPreferredWidth(100);  
    }

    public StaffDetail(ActionListener homeAction) {
        setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("Staff Details", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Main content panel
        JPanel mainContent = new JPanel(new BorderLayout(0, 10));
        mainContent.setBorder(BorderFactory.createEmptyBorder(0, 80, 20, 80));

        // Details panel
        detailsPanel = new JPanel();
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Combo box panel
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filterComboBox = new JComboBox<>(new String[]{"All", "Me"});
        filterComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Add your filter logic here
                    String selectedFilter = (String) filterComboBox.getSelectedItem();
                    System.out.println("Selected filter: " + selectedFilter);
                }
            }
        });
        filterPanel.add(new JLabel("Filter: "));
        filterPanel.add(filterComboBox);

        // Initialize and set up table
        initializeTable();
        JScrollPane tableScrollPane = new JScrollPane(staffTable);
        tableScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScrollPane.setPreferredSize(new Dimension(300, 150)); // Adjust size as needed

        // Add components to main content
        JPanel filterTable = new JPanel(new BorderLayout());
        filterTable.add(filterPanel,BorderLayout.NORTH);
        filterTable.add(tableScrollPane,BorderLayout.CENTER);
        mainContent.add(detailsPanel, BorderLayout.NORTH);
        mainContent.add(filterTable, BorderLayout.CENTER);
        // mainContent.add(tableScrollPane, BorderLayout.SOUTH);

        // Logout button
        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logoutButton.setPreferredSize(new Dimension(100, 40));
        logoutButton.setBackground(new Color(220, 53, 69));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);

        logoutButton.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(
                    StaffDetail.this,
                    "Are you sure you want to logout?",
                    "Logout Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (choice == JOptionPane.YES_OPTION) {
                MainFrame.setCurrentStaff(null);
                homeAction.actionPerformed(e);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(logoutButton);

        // Add all components to main panel
        add(titleLabel, BorderLayout.NORTH);
        add(mainContent, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent evt) {
                updateDetailsPanel();
            }
        });
    }
}