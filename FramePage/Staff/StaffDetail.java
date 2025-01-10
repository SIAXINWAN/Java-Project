package JavaProject.FramePage.Staff;

import JavaProject.FramePage.MainFrame;
import JavaProject.model.Booking;
import JavaProject.model.Customer;
import JavaProject.model.Staff;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StaffDetail extends JPanel {
    private JPanel detailsPanel;
    JPanel mainContent = new JPanel(new BorderLayout(0, 10));
    private static JTable staffTable;
    //private static DefaultTableModel tableModel;
    private JComboBox<String> filterComboBox;

    public static Vector<Booking> bookingDetails;
    public static Vector<Customer> customerDetails;
    public static Staff[] staffList;

    static int bookingNum;
    static Object[][] bookingData;
    static Object[][] filteredData = {};
    
    static String currentStaffId;
    static String[] columnNames = { "StaffID", "Check In Date", "Check Out Date", "Single Room", "Family Room", "Customer Name" };
    boolean haveCurrentStaff = false;

    public StaffDetail(ActionListener homeAction) {
        // this.bookingDetails = MainFrame.bookingDetails;
        // this.customerDetails = MainFrame.customerDetails;
        // this.staffList = MainFrame.staffList;
        refreshData();

        setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("Staff Details", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Main content panel
        
        mainContent.setBorder(BorderFactory.createEmptyBorder(0, 80, 20, 80));

        // Details panel
        detailsPanel = new JPanel();
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Combo box panel
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filterComboBox = new JComboBox<>(new String[] { "All", "Me" });
        filterComboBox.addItemListener(filterItemListener);
        filterPanel.add(new JLabel("Filter: "));
        filterPanel.add(filterComboBox);

        // Initialize and set up table
        initializeTable();
        JScrollPane tableScrollPane = new JScrollPane(staffTable);
        tableScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScrollPane.setPreferredSize(new Dimension(300, 150)); // Adjust size as needed

        // Add components to main content
        JPanel filterTable = new JPanel(new BorderLayout());
        filterTable.add(filterPanel, BorderLayout.NORTH);
        filterTable.add(tableScrollPane, BorderLayout.CENTER);
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

    public static void refreshData()
    {
        StaffDetail.bookingDetails = MainFrame.bookingDetails;
        StaffDetail.customerDetails = MainFrame.customerDetails;
        StaffDetail.staffList = MainFrame.staffList;
        bookingNum = bookingDetails.size();
        bookingData = new Object[bookingNum][6];
        filteredData = new Object[bookingNum][6];
        initializeTable();
    }

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
            currentStaffId = currentStaff.getStaffID();
            addDetailField(detailsPanel, "Staff ID:", currentStaffId);
            addDetailField(detailsPanel, "Name:", currentStaff.getName());
            addDetailField(detailsPanel, "Gender:", (currentStaff.getGender() ? "Male" : "Female"));
            addDetailField(detailsPanel, "Birthday:", currentStaff.getDateOfBirth());
        } else {
            addDetailField(detailsPanel, "No staff data available", " ");
        }

        detailsPanel.revalidate();
        detailsPanel.repaint();
    }

    public static void initializeTable() {
        // Create table model with 8 columns
       
        //tableModel = new DefaultTableModel(columnNames, 0);
        

        //bookingNum = bookingDetails.size();

        //bookingData = new Object[bookingNum][6];  

        

        // Add some dummy data (6 rows)
        for (int i = 0; i < bookingNum; i++) {
            //Object[] row = new Object[6];
            Booking currentBooking = bookingDetails.get(i);
            int num = i % 4;
            String staffId = staffList[num].getStaffID();
            for (int j = 0; j < 6; j++) 
            {                
                switch (j) {
                    case 0:
                        bookingData[i][j] = staffId;
                        //bookingData[i][j] = i;
                        //row[j] = i;
                        break;
                    case 1:
                        bookingData[i][j] = currentBooking.getCheckInDate();
                        //bookingData[i][j] = i;
                        //row[j] = i;
                        break;
                    case 2:
                        bookingData[i][j] = currentBooking.getCheckOutDate();
                        //bookingData[i][j] = i;
                        //row[j] = i;
                        break;
                    case 3:
                        bookingData[i][j] = currentBooking.getsingleRoom();
                        //bookingData[i][j] = i;
                        //row[j] = i;
                        break;
                    case 4:
                        bookingData[i][j] = currentBooking.getfamilyRoom();
                        //bookingData[i][j] = i;
                        //row[j] = i;
                        break;
                    case 5:
                        String cusID = currentBooking.getCustomerID();
                        String cusName = "";
                        for (int k = 0; k < customerDetails.size(); k++)
                        {
                            if (customerDetails.get(k).getCustomerID().equals(cusID))
                            {
                                cusName = customerDetails.get(k).getCustomerName();
                                break;
                            }
                        }
                        
                        bookingData[i][j] = cusName;
                        //bookingData[i][j] = i;
                        //row[j] = i;
                        break;
                    default:
                        throw new AssertionError();
                }
            }         
            //tableModel.addRow(row);
        }

        
        if (staffTable == null) 
        {
            staffTable = new JTable(bookingData, columnNames);
            //staffTable = new JTable(tableModel);
        }
        else
        {
            //staffTable.setModel(tableModel);
            staffTable.setModel(new DefaultTableModel(bookingData, columnNames));
        }
        

        // Set table properties
        staffTable.setFillsViewportHeight(true);
        staffTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        staffTable.setRowHeight(40); // Increase row height to 40 pixels

        // Set column widths
        staffTable.getColumnModel().getColumn(0).setPreferredWidth(100); // StaffID
        staffTable.getColumnModel().getColumn(1).setPreferredWidth(100); // Check In Date
        staffTable.getColumnModel().getColumn(2).setPreferredWidth(100); // Check Out Date
        staffTable.getColumnModel().getColumn(3).setPreferredWidth(100); // Single Room
        staffTable.getColumnModel().getColumn(4).setPreferredWidth(100); // Family Room
        staffTable.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    public void checkCurrentStaff()
    {
        int counterCurrentStaff = 0;
        for (int i = 0; i < bookingNum; i++)
        {
            if (currentStaffId.equals(bookingData[i][0]))
            {
                for (int j = 0; j < 6; j++)
                {
                    filteredData[counterCurrentStaff][j] = bookingData[i][j];
                }
                counterCurrentStaff++;
                //System.out.println("yes");
            } 
        }
        haveCurrentStaff = true;       
    }

    ItemListener filterItemListener = new ItemListener()
    {
        public void itemStateChanged(ItemEvent e)
        {
           if (e.getStateChange() == ItemEvent.SELECTED) {
                if (filterComboBox.getSelectedIndex() == 0)
                {
                    staffTable.setModel(new DefaultTableModel(bookingData, columnNames));
                }
                else
                {
                    if (!haveCurrentStaff)
                    {
                        checkCurrentStaff();
                    }                    
                    staffTable.setModel(new DefaultTableModel(filteredData, columnNames));
                }
                mainContent.revalidate();
                mainContent.repaint();
            }
        }
    };
}