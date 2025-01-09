package JavaProject.FramePage.Customer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import JavaProject.model.Booking;
import JavaProject.model.Customer;

public class CustomerConfirm extends JPanel {
    // Create the main content panel that will be scrollable
    JPanel mainContentPanel = new JPanel();
    JPanel bookingPanel = new JPanel();

    private JLabel nameValueLabel = new JLabel();
    private JLabel phoneValueLabel = new JLabel();
    private JLabel emailValueLabel = new JLabel();

    private JTextField creditCardNumberField;
    private JComboBox<String> paymentMethodCombo;

    public Vector<Booking> bookingDetails;
    int currentIndex;

    Booking thisBookingDetails;

    public Vector<Customer> customerDetails;
    Customer thisCustomerDetails;
    
    public CustomerConfirm(ActionListener homeAction, Vector<Booking> bookingDetails, int bookingDetailsCurrentIndex, Vector<Customer> customerDetails) {
        setLayout(new BorderLayout());

        this.bookingDetails = bookingDetails;
        this.currentIndex = bookingDetailsCurrentIndex;
        thisBookingDetails = bookingDetails.get(bookingDetailsCurrentIndex);

        this.customerDetails = customerDetails;

        String customerID = thisBookingDetails.getCustomerID();

        for (int i = 0; i < customerDetails.size(); i++)
        {
            Customer customer = customerDetails.get(i);

            if (customer.getCustomerID().equals(customerID))
            {
                thisCustomerDetails = customer;
                break;
            }
        }
        

        setPreferredSize(new Dimension(600,400));
        
        
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


        JPanel bookingPaneltitle = new JPanel(new BorderLayout());

        JLabel labeltitle = new JLabel("Booking details: ");

        JPanel checkDatePanel = new JPanel(new GridLayout(1, 2));

        JLabel checkDateLabel1 = new JLabel("Check in date: " + thisBookingDetails.getCheckInDate());
        JLabel checkDateLabel2 = new JLabel("Check out date: " + thisBookingDetails.getCheckOutDate());

        checkDatePanel.add(checkDateLabel1);
        checkDatePanel.add(checkDateLabel2);

        JPanel roomBilPanel = new JPanel(new GridLayout(1, 3));

        int singleRoom = thisBookingDetails.getsingleRoom();
        int familyRoom = thisBookingDetails.getfamilyRoom();

        JLabel roomBilLabel1 = new JLabel("Booking rooms: " + thisBookingDetails.getroomBil());
        JLabel roomBilLabel2 = new JLabel("Single rooms - " + singleRoom);
        JLabel roomBilLabel3 = new JLabel("Family rooms - " + familyRoom);

        roomBilPanel.add(roomBilLabel1);
        roomBilPanel.add(roomBilLabel2);
        roomBilPanel.add(roomBilLabel3);

        bookingPaneltitle.add(labeltitle, BorderLayout.NORTH);
        bookingPaneltitle.add(checkDatePanel, BorderLayout.CENTER);
        bookingPaneltitle.add(roomBilPanel, BorderLayout.SOUTH);

        JPanel roomDetailPanel = new JPanel();
        roomDetailPanel.setLayout(new BoxLayout(roomDetailPanel, BoxLayout.Y_AXIS));
        int totalPrice = 0;

        if (singleRoom != 0)
        {
            for (int i = 0; i < singleRoom; i++)
            {
                JLabel roomLabel = new JLabel("Single room " + (i + 1), JLabel.CENTER);
                roomLabel.setFont(new Font("Arial", Font.BOLD, 14));

                // Create the table for the room
                JPanel roomDetailsPanel1 = new JPanel(new GridLayout(6, 4));
                JLabel label1 = new JLabel("Item");
                JLabel label2 = new JLabel("Quantity");
                JLabel label3 = new JLabel("Add on");
                JLabel label4 = new JLabel("Price");

                JLabel label5 = new JLabel("Item"); 
                JLabel label6 = new JLabel("1");
                JLabel label7 = new JLabel("-");
                JLabel labelPrice = new JLabel();

                JLabel label9 = new JLabel("Pillow");
                JLabel labelQuantity1 = new JLabel();
                JLabel label11 = new JLabel(thisBookingDetails.getAddonChoiceS()[i][0] + "");
                JLabel label12 = new JLabel("-");

                JLabel label13 = new JLabel("Slipper");
                JLabel labelQuantity2 = new JLabel("1");
                JLabel label15 = new JLabel("-");
                JLabel label16 = new JLabel("-");

                JLabel label17 = new JLabel("Towel");
                JLabel labelQuantity3 = new JLabel("1");
                JLabel label19 = new JLabel(thisBookingDetails.getAddonChoiceS()[i][1] + "");
                JLabel label20 = new JLabel("-");

                JLabel label21 = new JLabel("Breakfast");
                JLabel labelQuantity4 = new JLabel("1");
                JLabel label23 = new JLabel("-");
                JLabel label24 = new JLabel("-");

                roomDetailsPanel1.add(label1); roomDetailsPanel1.add(label2); roomDetailsPanel1.add(label3); roomDetailsPanel1.add(label4); 
                roomDetailsPanel1.add(label5); roomDetailsPanel1.add(label6); roomDetailsPanel1.add(label7); roomDetailsPanel1.add(labelPrice); 
                roomDetailsPanel1.add(label9); roomDetailsPanel1.add(labelQuantity1); roomDetailsPanel1.add(label11); roomDetailsPanel1.add(label12);  
                roomDetailsPanel1.add(label13); roomDetailsPanel1.add(labelQuantity2); roomDetailsPanel1.add(label15); roomDetailsPanel1.add(label16);  
                roomDetailsPanel1.add(label17); roomDetailsPanel1.add(labelQuantity3); roomDetailsPanel1.add(label19); roomDetailsPanel1.add(label20);  
                roomDetailsPanel1.add(label21); roomDetailsPanel1.add(labelQuantity4); roomDetailsPanel1.add(label23); roomDetailsPanel1.add(label24);  

                int singleOption = thisBookingDetails.getSingleRChoice()[i];

                if (singleOption == 0) 
                {
                    label5.setText("Single bed");
                    labelPrice.setText("RM 80.00");
                    labelQuantity1.setText("1");
                    labelQuantity2.setText("1");
                    labelQuantity3.setText("1");
                    labelQuantity4.setText("1");
                    totalPrice += 80;
                }
                else
                {
                    if (singleOption == 1)
                    {
                        label5.setText("Queen bed");
                    }
                    else
                    {
                        label5.setText("King bed");
                    }
                    labelPrice.setText("RM 120.00");
                    labelQuantity1.setText("2");
                    labelQuantity2.setText("2");
                    labelQuantity3.setText("2");
                    labelQuantity4.setText("2");
                    totalPrice += 120;
                }
                //Add the label and table to the panel
                roomDetailPanel.add(roomLabel);
                roomDetailPanel.add(roomDetailsPanel1);
            }            
        }

        if (familyRoom != 0)
        {
            for (int i = 0; i < familyRoom; i++)
            {
                JLabel roomLabel = new JLabel("Family room " + (i + 1), JLabel.CENTER);
                roomLabel.setFont(new Font("Arial", Font.BOLD, 14));

                // Create the table for the room
                JPanel roomDetailsPanel1 = new JPanel(new GridLayout(7, 4));
                JLabel label1 = new JLabel("Item");
                JLabel label2 = new JLabel("Quantity");
                JLabel label3 = new JLabel("Add on");
                JLabel label4 = new JLabel("Price");

                JLabel label5 = new JLabel("Item"); 
                JLabel label6 = new JLabel("1");
                JLabel label7 = new JLabel("-");
                JLabel labelPrice = new JLabel();

                int matteresBil = thisBookingDetails.getAddonChoiceF()[i][0];

                JLabel label25 = new JLabel("Mattress");
                JLabel labelQuantity5 = new JLabel();
                JLabel label26 = new JLabel(matteresBil + "");
                JLabel label27 = new JLabel("RM 30");

                JLabel label9 = new JLabel("Pillow");
                JLabel labelQuantity1 = new JLabel();
                JLabel label11 = new JLabel(thisBookingDetails.getAddonChoiceF()[i][1] + "");
                JLabel label12 = new JLabel("-");             

                JLabel label13 = new JLabel("Slipper");
                JLabel labelQuantity2 = new JLabel();
                JLabel label15 = new JLabel(thisBookingDetails.getAddonChoiceF()[i][2] + "");
                JLabel label16 = new JLabel("-");

                JLabel label17 = new JLabel("Towel");
                JLabel labelQuantity3 = new JLabel();
                JLabel label19 = new JLabel(thisBookingDetails.getAddonChoiceF()[i][3] + "");
                JLabel label20 = new JLabel("-");

                JLabel label21 = new JLabel("Breakfast");
                JLabel labelQuantity4 = new JLabel();
                JLabel label23 = new JLabel(thisBookingDetails.getAddonChoiceF()[i][4] + "");
                JLabel label24 = new JLabel("-");

                roomDetailsPanel1.add(label1); roomDetailsPanel1.add(label2); roomDetailsPanel1.add(label3); roomDetailsPanel1.add(label4); 
                roomDetailsPanel1.add(label5); roomDetailsPanel1.add(label6); roomDetailsPanel1.add(label7); roomDetailsPanel1.add(labelPrice); 
                roomDetailsPanel1.add(label25); roomDetailsPanel1.add(labelQuantity5); roomDetailsPanel1.add(label26); roomDetailsPanel1.add(label27);  
                roomDetailsPanel1.add(label9); roomDetailsPanel1.add(labelQuantity1); roomDetailsPanel1.add(label11); roomDetailsPanel1.add(label12);  
                roomDetailsPanel1.add(label13); roomDetailsPanel1.add(labelQuantity2); roomDetailsPanel1.add(label15); roomDetailsPanel1.add(label16);  
                roomDetailsPanel1.add(label17); roomDetailsPanel1.add(labelQuantity3); roomDetailsPanel1.add(label19); roomDetailsPanel1.add(label20);  
                roomDetailsPanel1.add(label21); roomDetailsPanel1.add(labelQuantity4); roomDetailsPanel1.add(label23); roomDetailsPanel1.add(label24);  

                int familyOption = thisBookingDetails.getFamilyRChoice()[i];

                if (familyOption == 0) 
                {
                    label5.setText("Single bed + Single bed");
                    
                }
                else if (familyOption == 1) 
                {
                    label5.setText("Single bed + King bed");
                }
                else
                {
                    label5.setText("Queen bed + King bed");
                }

                labelPrice.setText("RM 200.00");
                labelQuantity1.setText("4");
                labelQuantity2.setText("4");
                labelQuantity3.setText("4");
                labelQuantity4.setText("4");
                labelQuantity5.setText("4");
                totalPrice += 200;

                if (matteresBil != 0)
                {
                    totalPrice += 30 * matteresBil;
                }
                //Add the label and table to the panel
                roomDetailPanel.add(roomLabel);
                roomDetailPanel.add(roomDetailsPanel1);
            }            
        }

        bookingPanel.add(bookingPaneltitle, BorderLayout.NORTH);
        bookingPanel.add(roomDetailPanel, BorderLayout.CENTER);

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
        mainContentPanel.add(bookingPanel, BorderLayout.CENTER);
        mainContentPanel.add(PaymentPanel, BorderLayout.SOUTH);
        
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
        nameValueLabel.setText(thisCustomerDetails.getCustomerName());
        phoneValueLabel.setText(thisCustomerDetails.getCustomerPhoneNO());
        emailValueLabel.setText(thisCustomerDetails.getCustomerEmail());
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