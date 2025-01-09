package JavaProject.FramePage.Customer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import javax.swing.border.EmptyBorder;
import JavaProject.model.Booking;
import JavaProject.model.Customer;

import JavaProject.FramePage.MainFrame;

public class CustomerDetail extends JPanel {
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;
    
    public Vector<Booking> bookingDetails;
    int currentIndex;

    Booking thisBookingDetails;

    public Vector<Customer> customerDetails = MainFrame.customerDetails;

    public CustomerDetail(ActionListener homeAction, Vector<Booking> bookingDetails, int bookingDetailsCurrentIndex) {
        setLayout(new BorderLayout(0, 20)); // Add spacing between border layout components
        this.bookingDetails = bookingDetails;
        this.currentIndex = bookingDetailsCurrentIndex;

        thisBookingDetails = bookingDetails.get(bookingDetailsCurrentIndex);

        // Title Panel with improved styling
        JPanel titlePanel = new JPanel();
        titlePanel.setBorder(new EmptyBorder(30, 0, 20, 0));
        JLabel titleLabel = new JLabel("Customer Details", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Main form panel with improved layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(0, 50, 0, 50)); // Add padding on sides

        // Form panel with grid bag layout for better control
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components

        // Initialize text fields with consistent sizing
        Dimension fieldSize = new Dimension(300, 35);
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 16);

        // Name components
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        nameField = createStyledTextField(fieldSize, fieldFont);

        // Phone components
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(labelFont);
        phoneField = createStyledTextField(fieldSize, fieldFont);

        // Email components
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);
        emailField = createStyledTextField(fieldSize, fieldFont);

        nameField.setText("ABC");
        phoneField.setText("012-345 6789");
        emailField.setText("abc@gmail.com");

        // Add components to form panel with GridBagLayout
        // Name row
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(nameField, gbc);

        // Phone row
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(phoneLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(phoneField, gbc);

        // Email row
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(emailField, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);

        // Button panel with improved styling
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBorder(new EmptyBorder(20, 0, 30, 0));

        // Create styled buttons
        JButton confirmButton = createStyledButton("Confirm", new Dimension(120, 40));
        confirmButton.addActionListener(buttonSubmit);

        JButton cancelButton = createStyledButton("Cancel", new Dimension(120, 40));
        cancelButton.addActionListener(homeAction);

        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JTextField createStyledTextField(Dimension size, Font font) {
        JTextField field = new JTextField();
        field.setPreferredSize(size);
        field.setFont(font);
        field.setBorder(BorderFactory.createCompoundBorder(
            field.getBorder(), 
            BorderFactory.createEmptyBorder(5, 5, 5, 5))); // Add internal padding
        return field;
    }

    private JButton createStyledButton(String text, Dimension size) {
        JButton button = new JButton(text);
        button.setPreferredSize(size);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false); // Remove focus border
        button.setBorder(BorderFactory.createRaisedBevelBorder()); // Add 3D effect
        return button;
    }

    // ActionListener for the Confirm button
    ActionListener buttonSubmit = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name field is empty.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!name.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(null, "Name cannot contain numbers.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (phoneField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Phone field is empty.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!phoneField.getText().matches("[0-9\\- ]+")) {
                JOptionPane.showMessageDialog(null, "Phone number must only contain integers.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (emailField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Email field is empty.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!emailField.getText().contains("@")) {
                JOptionPane.showMessageDialog(null, "Email must contain '@'.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                //Store the detail into bookingDetails
                int vectorSize = customerDetails.size();
                String customerId = customerDetails.elementAt(vectorSize - 1).getCustomerID();

                int idSize = customerId.length();
                    
                String customeridCode = customerId.substring(0, 1);

                String customeridNum1 = customerId.substring(1, idSize);
                    
                int customeridNum2 = Integer.parseInt(customeridNum1);

                int customerIdNumFinal = customeridNum2 + 1;
                String newCustomerid = customeridCode;
                if (customerIdNumFinal >= 1000)
                {
                    newCustomerid += customerIdNumFinal;
                }
                else if (customerIdNumFinal >= 100)
                {
                    newCustomerid += "0" + customerIdNumFinal;
                }
                else if (customerIdNumFinal >= 10)
                {
                    newCustomerid += "00" + customerIdNumFinal;
                }
                else
                {
                    newCustomerid += "000" + customerIdNumFinal;
                }
                Customer customerTemp = new Customer(newCustomerid, nameField.getText(), phoneField.getText(), emailField.getText());

                customerDetails.add(customerTemp); 

                thisBookingDetails.setCustomerID(newCustomerid);


                JPanel parent = (JPanel) CustomerDetail.this.getParent();
                CardLayout layout = (CardLayout) parent.getLayout();

                CustomerConfirm customerConfirm = new CustomerConfirm(
                    e2 -> layout.show(parent, "CustomerDetail"),
                    bookingDetails,
                    currentIndex, 
                    customerDetails
                );
                    
                    // Add the new CustomerConfirm and show it
                parent.add(customerConfirm, "CustomerConfirm");
                layout.show(parent, "CustomerConfirm");
            }
        }
    };
}