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

    public CustomerConfirm(ActionListener homeAction, Vector<Booking> bookingDetails, int bookingDetailsCurrentIndex,
            Vector<Customer> customerDetails) {
        setLayout(new BorderLayout());

        this.bookingDetails = bookingDetails;
        this.currentIndex = bookingDetailsCurrentIndex;
        thisBookingDetails = bookingDetails.get(bookingDetailsCurrentIndex);

        this.customerDetails = customerDetails;

        String customerID = thisBookingDetails.getCustomerID();

        for (int i = 0; i < customerDetails.size(); i++) {
            Customer customer = customerDetails.get(i);

            if (customer.getCustomerID().equals(customerID)) {
                thisCustomerDetails = customer;
                break;
            }
        }

        setPreferredSize(new Dimension(600, 400));

        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(new BoxLayout(mainContentPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Booking Confirm", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Customer Info Panel setup
        JPanel customerInfoPanel = new JPanel();
        customerInfoPanel.setLayout(new GridLayout(3, 1, 5, 0)); // Use GridLayout with minimal vertical gap
        customerInfoPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

        // Labels setup
        JLabel nameLabel = new JLabel("Name: ", JLabel.RIGHT);
        JLabel phoneLabel = new JLabel("Phone: ", JLabel.RIGHT);
        JLabel emailLabel = new JLabel("Email: ", JLabel.RIGHT);

        // Create panels for each row with FlowLayout
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JPanel phonePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));

        // Set fixed width for labels
        int labelWidth = 100;
        Dimension labelDimension = new Dimension(labelWidth, 20);
        nameLabel.setPreferredSize(labelDimension);
        phoneLabel.setPreferredSize(labelDimension);
        emailLabel.setPreferredSize(labelDimension);

        Dimension valueDimension = new Dimension(200, 20);
        nameValueLabel.setPreferredSize(valueDimension);
        phoneValueLabel.setPreferredSize(valueDimension);
        emailValueLabel.setPreferredSize(valueDimension);

        namePanel.add(nameLabel);
        namePanel.add(nameValueLabel);

        phonePanel.add(phoneLabel);
        phonePanel.add(phoneValueLabel);

        emailPanel.add(emailLabel);
        emailPanel.add(emailValueLabel);

        customerInfoPanel.add(namePanel);
        customerInfoPanel.add(phonePanel);
        customerInfoPanel.add(emailPanel);

        // Remove the vertical struts and set a smaller preferred size
        Dimension panelSize = new Dimension(400, 80);
        customerInfoPanel.setPreferredSize(panelSize);
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
        roomDetailPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        int subTotalPrice = 0;
        int TotalPrice = 0;

        if (singleRoom != 0) {
            for (int i = 0; i < singleRoom; i++) {
                JLabel roomLabel = new JLabel("Single room " + (i + 1), JLabel.CENTER);
                roomLabel.setFont(new Font("Arial", Font.BOLD, 14));

                int pillowAddOn = thisBookingDetails.getAddonChoiceS()[i][0];
                int towelAddOn = thisBookingDetails.getAddonChoiceS()[i][1];

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
                JLabel label11 = new JLabel();
                label11.setText(pillowAddOn == 0 ? "-" : pillowAddOn == 1 ? "1" : "2");
                JLabel label12 = new JLabel("-");

                JLabel label13 = new JLabel("Slipper");
                JLabel labelQuantity2 = new JLabel("1");
                JLabel label15 = new JLabel("-");
                JLabel label16 = new JLabel("-");

                JLabel label17 = new JLabel("Towel");
                JLabel labelQuantity3 = new JLabel("1");
                JLabel label19 = new JLabel();
                label19.setText(towelAddOn == 0 ? "-" : towelAddOn == 1 ? "1" : "2");
                JLabel label20 = new JLabel("-");

                JLabel label21 = new JLabel("Breakfast");
                JLabel labelQuantity4 = new JLabel("1");
                JLabel label23 = new JLabel("-");
                JLabel label24 = new JLabel("-");

                roomDetailsPanel1.add(label1);
                roomDetailsPanel1.add(label2);
                roomDetailsPanel1.add(label3);
                roomDetailsPanel1.add(label4);
                roomDetailsPanel1.add(label5);
                roomDetailsPanel1.add(label6);
                roomDetailsPanel1.add(label7);
                roomDetailsPanel1.add(labelPrice);
                roomDetailsPanel1.add(label9);
                roomDetailsPanel1.add(labelQuantity1);
                roomDetailsPanel1.add(label11);
                roomDetailsPanel1.add(label12);
                roomDetailsPanel1.add(label13);
                roomDetailsPanel1.add(labelQuantity2);
                roomDetailsPanel1.add(label15);
                roomDetailsPanel1.add(label16);
                roomDetailsPanel1.add(label17);
                roomDetailsPanel1.add(labelQuantity3);
                roomDetailsPanel1.add(label19);
                roomDetailsPanel1.add(label20);
                roomDetailsPanel1.add(label21);
                roomDetailsPanel1.add(labelQuantity4);
                roomDetailsPanel1.add(label23);
                roomDetailsPanel1.add(label24);

                int singleOption = thisBookingDetails.getSingleRChoice()[i];

                if (singleOption == 0) {
                    label5.setText("Single bed");
                    labelPrice.setText("RM 80.00");
                    labelQuantity1.setText("1");
                    labelQuantity2.setText("1");
                    labelQuantity3.setText("1");
                    labelQuantity4.setText("1");
                    subTotalPrice += 80;
                } else {
                    if (singleOption == 1) {
                        label5.setText("Queen bed");
                    } else {
                        label5.setText("King bed");
                    }
                    labelPrice.setText("RM 120.00");
                    labelQuantity1.setText("2");
                    labelQuantity2.setText("2");
                    labelQuantity3.setText("2");
                    labelQuantity4.setText("2");
                    subTotalPrice += 120;
                }
                roomDetailPanel.add(roomLabel);
                roomDetailPanel.add(roomDetailsPanel1);
            }
        }

        if (familyRoom != 0) {
            for (int i = 0; i < familyRoom; i++) {
                JLabel roomLabel = new JLabel("Family room " + (i + 1), JLabel.CENTER);
                roomLabel.setFont(new Font("Arial", Font.BOLD, 14));

                int mattressCount = thisBookingDetails.getAddonChoiceF()[i][0];
                int pillowAddOn = thisBookingDetails.getAddonChoiceF()[i][1];
                int slipperAddOn = thisBookingDetails.getAddonChoiceF()[i][2];
                int towelAddOn = thisBookingDetails.getAddonChoiceF()[i][3];
                int breakfastCount = thisBookingDetails.getAddonChoiceF()[i][4];

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
                JLabel label26 = new JLabel();
                label26.setText(mattressCount == 0 ? "0" : String.valueOf(mattressCount));
                JLabel label27 = new JLabel();
                label27.setText(mattressCount == 0 ? "-"
                        : String.format("RM 30 * %d = RM %d.00", mattressCount, (mattressCount * 30)));

                JLabel label9 = new JLabel("Pillow");
                JLabel labelQuantity1 = new JLabel();
                JLabel label11 = new JLabel();
                label11.setText(pillowAddOn == 0 ? "0" : pillowAddOn == 1 ? "1" : "2");
                JLabel label12 = new JLabel("-");

                JLabel label13 = new JLabel("Slipper");
                JLabel labelQuantity2 = new JLabel();
                JLabel label15 = new JLabel();
                label15.setText(slipperAddOn == 0 ? "0" : slipperAddOn == 1 ? "1" : "2");
                JLabel label16 = new JLabel("-");

                JLabel label17 = new JLabel("Towel");
                JLabel labelQuantity3 = new JLabel();
                JLabel label19 = new JLabel();
                label19.setText(towelAddOn == 0 ? "0" : towelAddOn == 1 ? "1" : "2");
                JLabel label20 = new JLabel("-");

                JLabel label21 = new JLabel("Breakfast");
                JLabel labelQuantity4 = new JLabel();
                JLabel label23 = new JLabel();
                label23.setText(breakfastCount == 0 ? "0" : String.valueOf(breakfastCount));
                JLabel label24 = new JLabel();
                label24.setText(breakfastCount == 0 ? "-"
                        : String.format("RM 20 * %d = RM %d.00", breakfastCount, (breakfastCount * 20)));

                roomDetailsPanel1.add(label1);
                roomDetailsPanel1.add(label2);
                roomDetailsPanel1.add(label3);
                roomDetailsPanel1.add(label4);
                roomDetailsPanel1.add(label5);
                roomDetailsPanel1.add(label6);
                roomDetailsPanel1.add(label7);
                roomDetailsPanel1.add(labelPrice);
                roomDetailsPanel1.add(label25);
                roomDetailsPanel1.add(labelQuantity5);
                roomDetailsPanel1.add(label26);
                roomDetailsPanel1.add(label27);
                roomDetailsPanel1.add(label9);
                roomDetailsPanel1.add(labelQuantity1);
                roomDetailsPanel1.add(label11);
                roomDetailsPanel1.add(label12);
                roomDetailsPanel1.add(label13);
                roomDetailsPanel1.add(labelQuantity2);
                roomDetailsPanel1.add(label15);
                roomDetailsPanel1.add(label16);
                roomDetailsPanel1.add(label17);
                roomDetailsPanel1.add(labelQuantity3);
                roomDetailsPanel1.add(label19);
                roomDetailsPanel1.add(label20);
                roomDetailsPanel1.add(label21);
                roomDetailsPanel1.add(labelQuantity4);
                roomDetailsPanel1.add(label23);
                roomDetailsPanel1.add(label24);

                int familyOption = thisBookingDetails.getFamilyRChoice()[i];

                if (familyOption == 0) {
                    label5.setText("Single bed + Single bed");

                } else if (familyOption == 1) {
                    label5.setText("Single bed + King bed");
                } else {
                    label5.setText("Queen bed + King bed");
                }

                labelPrice.setText("RM 200.00");
                labelQuantity1.setText("4");
                labelQuantity2.setText("4");
                labelQuantity3.setText("4");
                labelQuantity4.setText("4");
                labelQuantity5.setText("4");
                subTotalPrice += 200;

                if (matteresBil != 0) {
                    int matteresPrice = 30 * matteresBil;
                    subTotalPrice += matteresPrice;

                }
                if (breakfastCount != 0) {
                    int breakfastPrice = 20 * breakfastCount;
                    subTotalPrice += breakfastPrice;
                }
                roomDetailPanel.add(roomLabel);
                roomDetailPanel.add(roomDetailsPanel1);
            }
        }

        TotalPrice = subTotalPrice * thisBookingDetails.getbookingNight();

        JPanel pricePanel = new JPanel(new BorderLayout());
        JLabel priceLabel1 = new JLabel("Subtotal (total price per night) = RM " + subTotalPrice + ".00",
                JLabel.CENTER);
        JLabel priceLabel2 = new JLabel(
                "Total price (" + thisBookingDetails.getbookingNight() + " night) = RM " + TotalPrice + ".00",
                JLabel.CENTER);

        pricePanel.add(priceLabel1, BorderLayout.NORTH);
        pricePanel.add(priceLabel2, BorderLayout.CENTER);

        bookingPanel.add(bookingPaneltitle, BorderLayout.NORTH);
        bookingPanel.add(roomDetailPanel, BorderLayout.CENTER);
        bookingPanel.add(pricePanel, BorderLayout.SOUTH);

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

        JPanel North2Panel = new JPanel();
        North2Panel.setLayout(new BoxLayout(North2Panel, BoxLayout.Y_AXIS));
        North2Panel.add(titleLabel);
        North2Panel.add(customerInfoPanel);
        North2Panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        bookingPanel.setLayout(new BoxLayout(bookingPanel, BoxLayout.Y_AXIS));
        bookingPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        PaymentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        mainContentPanel.add(North2Panel);
        mainContentPanel.add(Box.createVerticalStrut(10));
        mainContentPanel.add(bookingPanel);
        mainContentPanel.add(Box.createVerticalStrut(10));
        mainContentPanel.add(PaymentPanel);

        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.add(mainContentPanel, BorderLayout.NORTH);
        wrapperPanel.add(new JPanel(), BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(wrapperPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        scrollPane.setPreferredSize(new Dimension(550, 350));

        add(scrollPane, BorderLayout.CENTER);

        JPanel cancelPanel = new JPanel();
        cancelPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.BOLD, 16));
        cancelButton.setPreferredSize(new Dimension(100, 40));
        cancelButton.addActionListener(homeAction);
        cancelPanel.add(cancelButton);

        add(cancelPanel, BorderLayout.SOUTH);

        addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                updateCustomerInfo();
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
            }
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
            if (creditCardNumberField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Credit card number field is empty", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else if (creditCardNumberField.getText().length() < 16) {
                JOptionPane.showMessageDialog(null, "Credit card number should at least 16 number", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else if (creditCardNumberField.getText().length() > 19) {
                JOptionPane.showMessageDialog(null, "Credit card number should less than 19 number", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    String numTemp = creditCardNumberField.getText().trim();
                    long number = Long.parseLong(numTemp);

                    CustomerPage1.clearForm();
                    CustomerDetail.clearForm();

                    // if creditCardNumberField is contain only numbers will proceed
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
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Credit card number should be numbers only", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        }
    };
}