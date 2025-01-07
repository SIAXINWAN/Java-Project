package JavaProject.FramePage.Customer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

import JavaProject.model.Customer;

public class CustomerConfirm extends JPanel {
    private Customer acustomer;
    private JLabel nameValueLabel;
    private JLabel phoneValueLabel;
    private JLabel emailValueLabel;
    private JTextField creditCardNumberField;
    private JComboBox<String> paymentMethodCombo;
    
    public CustomerConfirm(ActionListener homeAction, Customer customer) {
        setLayout(new BorderLayout());
        this.acustomer = customer;

        setPreferredSize(new Dimension(600,400));
        
         // Create the main content panel that will be scrollable
         JPanel mainContentPanel = new JPanel();
         mainContentPanel.setLayout(new BorderLayout());
         // Set a minimum size to ensure content doesn't compress too much
         mainContentPanel.setMinimumSize(new Dimension(500, 600));
         // Set preferred size larger than the container to force scroll bars
         mainContentPanel.setPreferredSize(new Dimension(580, 800));
         
         JLabel titleLabel = new JLabel("Booking Confirm", JLabel.CENTER);
         titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
         titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Customer Info Panel setup (unchanged)
        JPanel customerInfoPanel = new JPanel();
        customerInfoPanel.setLayout(new BoxLayout(customerInfoPanel, BoxLayout.Y_AXIS));
        customerInfoPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        // Labels setup (unchanged)
        JLabel nameLabel = new JLabel("Name: ", JLabel.CENTER);
        JLabel phoneLabel = new JLabel("Phone: ", JLabel.CENTER);
        JLabel emailLabel = new JLabel("Email: ", JLabel.CENTER);
        
        int labelWidth = 300;
        nameLabel.setPreferredSize(new Dimension(labelWidth, 15));
        phoneLabel.setPreferredSize(new Dimension(labelWidth, 15));
        emailLabel.setPreferredSize(new Dimension(labelWidth, 15));
        
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        phoneLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        nameValueLabel = new JLabel();
        phoneValueLabel = new JLabel();
        emailValueLabel = new JLabel();
        
        // Panels setup (unchanged)
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        namePanel.add(nameLabel);
        namePanel.add(nameValueLabel);
        
        JPanel phonePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        phonePanel.add(phoneLabel);
        phonePanel.add(phoneValueLabel);
        
        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        emailPanel.add(emailLabel);
        emailPanel.add(emailValueLabel);
        
        Dimension panelSize = new Dimension(300, 30);
        namePanel.setPreferredSize(panelSize);
        phonePanel.setPreferredSize(panelSize);
        emailPanel.setPreferredSize(panelSize);
        
        customerInfoPanel.add(Box.createVerticalStrut(5));
        customerInfoPanel.add(namePanel);
        customerInfoPanel.add(Box.createVerticalStrut(5));
        customerInfoPanel.add(phonePanel);
        customerInfoPanel.add(Box.createVerticalStrut(5));
        customerInfoPanel.add(emailPanel);
        customerInfoPanel.add(Box.createVerticalStrut(5));
        
        // Payment Panel setup
        JPanel PaymentPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        PaymentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel paymentMethodLabel = new JLabel("Payment Method:");
        paymentMethodCombo = new JComboBox<>(new String[] { "Visa", "Master" });
        JLabel creditCardNumberLabel = new JLabel("Credit Card Number:");
        creditCardNumberField = new JTextField();
        JButton submitButton = new JButton("DONE!");
        submitButton.addActionListener(submitListener);
        
        PaymentPanel.add(paymentMethodLabel);
        PaymentPanel.add(paymentMethodCombo);
        PaymentPanel.add(creditCardNumberLabel);
        PaymentPanel.add(creditCardNumberField);
        PaymentPanel.add(new JLabel());
        PaymentPanel.add(submitButton);
        
        // North Panel setup
        JPanel NorthPanel = new JPanel(new BorderLayout());
        NorthPanel.add(titleLabel, BorderLayout.NORTH);
        NorthPanel.add(customerInfoPanel, BorderLayout.CENTER);
        
        // Add components to main content panel
        mainContentPanel.add(NorthPanel, BorderLayout.NORTH);
        mainContentPanel.add(PaymentPanel, BorderLayout.CENTER);
        
        // Create scroll pane and add main content to it
        JScrollPane scrollPane = new JScrollPane(mainContentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        // Make the scroll pane fill the available space
        scrollPane.setPreferredSize(new Dimension(550, 350));
        
        // Add a border to the scroll pane to make it more visible
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        // Button Panel
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.BOLD, 16));
        cancelButton.setPreferredSize(new Dimension(100, 40));
        cancelButton.addActionListener(homeAction);
        
        JPanel cancelPanel = new JPanel();
        cancelPanel.add(cancelButton);
        
        // Add components to main panel
        add(scrollPane, BorderLayout.CENTER);
        add(cancelPanel, BorderLayout.SOUTH);
        
        addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                updateCustomerInfo();
            }
            
            @Override
            public void ancestorRemoved(AncestorEvent event) {}
            
            @Override
            public void ancestorMoved(AncestorEvent event) {}
        });
    }
    
    // Rest of the methods remain unchanged
    private void updateCustomerInfo() {
        nameValueLabel.setText(acustomer.getName());
        phoneValueLabel.setText(acustomer.getPhoneNumber());
        emailValueLabel.setText(acustomer.getCustomerEmail());
    }
    
    String optionButton[] = { "Done", "Cancel" };
    ActionListener submitListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int o = JOptionPane.showOptionDialog(
                null,
                "Your booking has been successfully made.\nThe receipt will be sent to your email.\nThank you and we wish you a wonderful experience!",
                "Cats Hotel Booking System", JOptionPane.NO_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, optionButton, "default");
            if (o == 0) {
                JPanel parent = (JPanel) CustomerConfirm.this.getParent();
                CardLayout layout = (CardLayout) parent.getLayout();
                layout.show(parent, "Welcome");
            }
        }
    };
}