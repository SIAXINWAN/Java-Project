package JavaProject.FramePage.Customer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.EmptyBorder;
import JavaProject.model.Booking;
import JavaProject.FramePage.MainFrame;

public class CustomerPage extends JPanel {
    int SingleMax = Booking.SingleMax;
    int FamilyMax = Booking.FamilyMax;

    int roomBil;
    int SingleRoom;
    int FamilyRoom;

    int SingleRChoice[] = new int[SingleMax];
    int FamilyRChoice[] = new int[FamilyMax];
    int AddonChoiceS[][] = new int[SingleMax][2];
    int AddonChoiceF[][] = new int[FamilyMax][5];

    int tempS;
    int tempF;
    int counterLoop = -1;

    char BedType;

    JPanel panel = new JPanel(new BorderLayout());
    JPanel panelHeader = new JPanel(new BorderLayout());
    JPanel mainContent = new JPanel(new BorderLayout());

    JPanel panelChooseLoop = new JPanel(new BorderLayout());

    JPanel panelSingle = new JPanel(new BorderLayout());
    JPanel panelFamily = new JPanel(new BorderLayout());
    JPanel panelFamilyOption = new JPanel(new GridLayout(4, 3, 10, 10));
    JPanel panelAddonOption = new JPanel(new BorderLayout());
    JPanel panelAddon = new JPanel(new BorderLayout());
    JPanel panelAddonSingle = new JPanel(new GridLayout(2, 2, 10, 10));
    JPanel panelAddonFamily = new JPanel(new GridLayout(5, 2, 10, 10));
    JPanel buttonPanel2 = new JPanel();

    JLabel chooseRoomLabel = new JLabel();

    JButton buttonDone = new JButton("Done");

    String singleBedType[] = { "Single bed (RM 80.00 ++)", "Queen bed (RM 120.00 ++)", "King bed (RM 120.00 ++)" };
    JComboBox<String> comboboxSingle = new JComboBox<>(singleBedType);

    JRadioButton rbfamily1 = new JRadioButton("Option 1 : ");
    JRadioButton rbfamily2 = new JRadioButton("Option 2 : ");
    JRadioButton rbfamily3 = new JRadioButton("Option 3 : ");

    ButtonGroup buttonGroup2 = new ButtonGroup();

    JLabel AddonLabel1 = new JLabel("HI");
    JLabel AddonLabel2 = new JLabel("Do you want add-ons : ");

    JRadioButton rbAddon1 = new JRadioButton("Yes");
    JRadioButton rbAddon2 = new JRadioButton("No");

    ButtonGroup buttonGroupAddon = new ButtonGroup();

    JRadioButton rbAddonSingle1 = new JRadioButton("1");
    JRadioButton rbAddonSingle2 = new JRadioButton("2");
    JRadioButton rbAddonSingle3 = new JRadioButton("1");
    JRadioButton rbAddonSingle4 = new JRadioButton("2");

    ButtonGroup buttonGroupAddonSingle1 = new ButtonGroup();
    ButtonGroup buttonGroupAddonSingle2 = new ButtonGroup();

    JRadioButton rbAddonFamily1 = new JRadioButton("1");
    JRadioButton rbAddonFamily2 = new JRadioButton("2");
    JRadioButton rbAddonFamily3 = new JRadioButton("1");
    JRadioButton rbAddonFamily4 = new JRadioButton("2");
    JRadioButton rbAddonFamily5 = new JRadioButton("1");
    JRadioButton rbAddonFamily6 = new JRadioButton("2");
    JRadioButton rbAddonFamily7 = new JRadioButton("1");
    JRadioButton rbAddonFamily8 = new JRadioButton("2");

    ButtonGroup buttonGroupAddonFamily1 = new ButtonGroup();
    ButtonGroup buttonGroupAddonFamily2 = new ButtonGroup();
    ButtonGroup buttonGroupAddonFamily3 = new ButtonGroup();
    ButtonGroup buttonGroupAddonFamily4 = new ButtonGroup();

    JTextField addonBreakfastTextField = new JTextField();

    public Vector<Booking> bookingDetails;
    int currentIndex;

    Booking thisBookingDetails;

    public CustomerPage(ActionListener homeAction, Vector<Booking> bookingDetails, int bookingDetailsCurrentIndex) {
        setLayout(new BorderLayout());

        addonBreakfastTextField.setText("0");

        this.bookingDetails = MainFrame.bookingDetails;
        currentIndex = bookingDetailsCurrentIndex;

        thisBookingDetails = bookingDetails.get(currentIndex);

        roomBil = thisBookingDetails.getroomBil();
        SingleRoom = thisBookingDetails.getsingleRoom();
        FamilyRoom = thisBookingDetails.getfamilyRoom();

        JLabel customerLabel = new JLabel("Customer Booking", JLabel.CENTER);
        customerLabel.setFont(new Font("Arial", Font.BOLD, 26));
        panelHeader.add(customerLabel, BorderLayout.NORTH);

        panelHeader.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelBookingDetail = new JPanel(new BorderLayout());
        JLabel labelCID = new JLabel();
        labelCID.setFont((new Font("Arial", Font.BOLD, 20)));
        JLabel labelCOD = new JLabel();
        labelCOD.setFont((new Font("Arial", Font.BOLD, 20)));

        JPanel detailDate = new JPanel();
        detailDate.setLayout(new BoxLayout(detailDate, BoxLayout.X_AXIS));
        detailDate.add(labelCID);
        detailDate.add(Box.createRigidArea(new Dimension(150, 0)));
        detailDate.add(labelCOD);
        panelBookingDetail.setLayout(new BoxLayout(panelBookingDetail, BoxLayout.Y_AXIS));
        panelBookingDetail.add(detailDate, BorderLayout.NORTH);

        JLabel labelT = new JLabel();
        labelT.setFont((new Font("Arial", Font.BOLD, 20)));
        JLabel labelS = new JLabel();
        labelS.setFont((new Font("Arial", Font.BOLD, 20)));
        JLabel labelF = new JLabel();
        labelF.setFont((new Font("Arial", Font.BOLD, 20)));
        JPanel detailRoom = new JPanel();
        labelCID.setText("Check In Date: " + thisBookingDetails.getCheckInDate());
        labelCOD.setText("Check Out Date: " + thisBookingDetails.getCheckOutDate());
        labelT.setText("Total rooms: " + thisBookingDetails.getroomBil());
        labelS.setText("Single rooms: " + thisBookingDetails.getsingleRoom());
        labelF.setText("Family rooms: " + thisBookingDetails.getfamilyRoom());
        detailRoom.setLayout(new BoxLayout(detailRoom, BoxLayout.X_AXIS));
        detailRoom.add(labelT);
        detailRoom.add(Box.createRigidArea(new Dimension(90, 0)));
        detailRoom.add(labelS);
        detailRoom.add(Box.createRigidArea(new Dimension(85, 0)));
        detailRoom.add(labelF);
        JPanel spacer = new JPanel();
        spacer.setPreferredSize(new Dimension(0, 80));
        panelBookingDetail.add(detailRoom, BorderLayout.SOUTH);
        panelBookingDetail.add(spacer, BorderLayout.CENTER);

        panelHeader.add(panelBookingDetail, BorderLayout.CENTER);
        panelHeader.add(panelChooseLoop, BorderLayout.SOUTH);

        mainContent.add(panelHeader, BorderLayout.NORTH);

        JButton DoneButton = createStyledButton("Done", new Dimension(120, 40));
        DoneButton.setFont(new Font("Arial", Font.BOLD, 16));
        DoneButton.setPreferredSize(new Dimension(100, 40));
        DoneButton.addActionListener(navigationToNextPage);

        JPanel DonePanel = new JPanel();
        DonePanel.add(DoneButton);

        JPanel spacer1 = new JPanel();
        spacer1.setPreferredSize(new Dimension(0, 10));

        JButton homeButton = createStyledButton("Cancel", new Dimension(120, 40));

        homeButton.setFont(new Font("Arial", Font.BOLD, 16));
        homeButton.setPreferredSize(new Dimension(100, 40));
        homeButton.addActionListener(homeAction);

        JPanel homePanel = new JPanel();
        homePanel.add(homeButton);
        JPanel SouthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        SouthPanel.setBorder(new EmptyBorder(20, 0, 30, 0));

        SouthPanel.add(homePanel, BorderLayout.NORTH);
        mainContent.add(SouthPanel, BorderLayout.SOUTH);

        panelChooseLoop.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        chooseRoomLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panelChooseLoop.add(chooseRoomLabel, BorderLayout.NORTH);

        counterLoop = 0;
        tempS = SingleRoom;
        tempF = FamilyRoom;

        RoomLoop();

        comboboxSingle.addItemListener(comboboxItemListener);

        panelSingle.add(comboboxSingle, BorderLayout.NORTH);

        buttonGroup2.add(rbfamily1);
        buttonGroup2.add(rbfamily2);
        buttonGroup2.add(rbfamily3);

        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel("Bed 1");
        JLabel label3 = new JLabel("Bed 2");
        JLabel label4 = new JLabel("Single bed");
        JLabel label5 = new JLabel("Single bed");
        JLabel label6 = new JLabel("Single bed");
        JLabel label7 = new JLabel("King bed");
        JLabel label8 = new JLabel("Queen bed");
        JLabel label9 = new JLabel("King bed");

        panelFamilyOption.add(label1);
        panelFamilyOption.add(label2);
        panelFamilyOption.add(label3);
        panelFamilyOption.add(rbfamily1);
        panelFamilyOption.add(label4);
        panelFamilyOption.add(label5);
        panelFamilyOption.add(rbfamily2);
        panelFamilyOption.add(label6);
        panelFamilyOption.add(label7);
        panelFamilyOption.add(rbfamily3);
        panelFamilyOption.add(label8);
        panelFamilyOption.add(label9);

        panelFamily.add(panelFamilyOption, BorderLayout.NORTH);

        JPanel panelAddonLabel = new JPanel(new BorderLayout());
        panelAddonLabel.add(AddonLabel1, BorderLayout.NORTH);
        panelAddonLabel.add(AddonLabel2, BorderLayout.CENTER);
        panelAddonOption.add(panelAddonLabel, BorderLayout.NORTH);

        JPanel panelAddonRadioB = new JPanel();

        buttonGroupAddon.add(rbAddon1);
        buttonGroupAddon.add(rbAddon2);

        rbAddon1.addItemListener(radioButtonItemListener);
        rbAddon2.addItemListener(radioButtonItemListener);

        panelAddonRadioB.add(rbAddon1);
        panelAddonRadioB.add(rbAddon2);

        panelAddonOption.add(panelAddonRadioB, BorderLayout.CENTER);

        panelAddon.add(panelAddonOption, BorderLayout.NORTH);
        panelAddon.add(buttonPanel2, BorderLayout.SOUTH);

        buttonDone.setPreferredSize(new Dimension(100, 40));
        buttonDone.addActionListener(buttonDoneActionListener);

        buttonPanel2.add(buttonDone);

        JLabel AddonOptionLabel1 = new JLabel("Pillow");
        JLabel AddonOptionLabel2 = new JLabel("Towel");
        JLabel AddonOptionLabel3 = new JLabel("Matteres (Single bed) Add on RM 30.00 each");
        JLabel AddonOptionLabel4 = new JLabel("Pillow");
        JLabel AddonOptionLabel5 = new JLabel("Slipper");
        JLabel AddonOptionLabel6 = new JLabel("Towel");
        JLabel AddonOptionLabel7 = new JLabel("Breakfast add-on (per person - RM 20.00)");

        JPanel panelRadioButtonSingle1 = new JPanel();
        JPanel panelRadioButtonSingle2 = new JPanel();

        panelRadioButtonSingle1.add(rbAddonSingle1);
        panelRadioButtonSingle1.add(rbAddonSingle2);

        panelRadioButtonSingle2.add(rbAddonSingle3);
        panelRadioButtonSingle2.add(rbAddonSingle4);

        buttonGroupAddonSingle1.add(rbAddonSingle1);
        buttonGroupAddonSingle1.add(rbAddonSingle2);

        buttonGroupAddonSingle2.add(rbAddonSingle3);
        buttonGroupAddonSingle2.add(rbAddonSingle4);

        panelAddonSingle.add(AddonOptionLabel1);
        panelAddonSingle.add(panelRadioButtonSingle1);
        panelAddonSingle.add(AddonOptionLabel2);
        panelAddonSingle.add(panelRadioButtonSingle2);

        JPanel panelRadioButtonFamily1 = new JPanel();
        JPanel panelRadioButtonFamily2 = new JPanel();
        JPanel panelRadioButtonFamily3 = new JPanel();
        JPanel panelRadioButtonFamily4 = new JPanel();

        panelRadioButtonFamily1.add(rbAddonFamily1);
        panelRadioButtonFamily1.add(rbAddonFamily2);

        panelRadioButtonFamily2.add(rbAddonFamily3);
        panelRadioButtonFamily2.add(rbAddonFamily4);

        panelRadioButtonFamily3.add(rbAddonFamily5);
        panelRadioButtonFamily3.add(rbAddonFamily6);

        panelRadioButtonFamily4.add(rbAddonFamily7);
        panelRadioButtonFamily4.add(rbAddonFamily8);

        buttonGroupAddonFamily1.add(rbAddonFamily1);
        buttonGroupAddonFamily1.add(rbAddonFamily2);

        buttonGroupAddonFamily2.add(rbAddonFamily3);
        buttonGroupAddonFamily2.add(rbAddonFamily4);

        buttonGroupAddonFamily3.add(rbAddonFamily5);
        buttonGroupAddonFamily3.add(rbAddonFamily6);

        buttonGroupAddonFamily4.add(rbAddonFamily7);
        buttonGroupAddonFamily4.add(rbAddonFamily8);

        panelAddonFamily.add(AddonOptionLabel3);
        panelAddonFamily.add(panelRadioButtonFamily1);
        panelAddonFamily.add(AddonOptionLabel4);
        panelAddonFamily.add(panelRadioButtonFamily2);
        panelAddonFamily.add(AddonOptionLabel5);
        panelAddonFamily.add(panelRadioButtonFamily3);
        panelAddonFamily.add(AddonOptionLabel6);
        panelAddonFamily.add(panelRadioButtonFamily4);
        panelAddonFamily.add(AddonOptionLabel7);
        panelAddonFamily.add(addonBreakfastTextField);

        mainContent.add(panel, BorderLayout.CENTER);
        setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(mainContent);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);
    }

    ActionListener navigationToNextPage = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int o = JOptionPane.showOptionDialog(
                    null,
                    "All rooms have been selected.",
                    "Cats Hotel Booking System", JOptionPane.NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, optionButton, "default");
            if (o == 0) {

                JPanel parent = (JPanel) CustomerPage.this.getParent();
                CardLayout layout = (CardLayout) parent.getLayout();
                layout.show(parent, "CustomerDetail");
            }
        }
    };

    String optionButton[] = { "Continue", "Cancel" };
    ActionListener buttonDoneActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            boolean validSelection = true;

            // Store original values in case we need to revert
            int originalCounterLoop = counterLoop;
            int originalTempS = tempS;
            int originalTempF = tempF;

            if (tempS > 0) {
                if (!rbAddon1.isSelected() && !rbAddon2.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Addon field is empty", "Warning", JOptionPane.WARNING_MESSAGE);
                    validSelection = false;
                } else if (rbAddon1.isSelected()) {
                    if (!rbAddonSingle1.isSelected() && !rbAddonSingle2.isSelected() &&
                            !rbAddonSingle3.isSelected() && !rbAddonSingle4.isSelected()) {
                        JOptionPane.showMessageDialog(null,
                                "You must select at least one addon",
                                "Warning",
                                JOptionPane.WARNING_MESSAGE);
                        validSelection = false;
                    }
                }

                if (validSelection) {
                    SingleRChoice[counterLoop] = comboboxSingle.getSelectedIndex();
                    if (rbAddon1.isSelected()) {
                        CheckAddon('S', counterLoop);
                    }
                    tempS--; // Only decrease if valid
                }
            } else if (tempF > 0) {
                if (getFamilyRoomTypeSelected() == 0) {
                    JOptionPane.showMessageDialog(null, "Please select at least one option", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    validSelection = false;
                } else if (!rbAddon1.isSelected() && !rbAddon2.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Addon field is empty", "Warning", JOptionPane.WARNING_MESSAGE);
                    validSelection = false;
                } else if (rbAddon1.isSelected()) {
                    if (!rbAddonFamily1.isSelected() && !rbAddonFamily2.isSelected() &&
                            !rbAddonFamily3.isSelected() && !rbAddonFamily4.isSelected() &&
                            !rbAddonFamily5.isSelected() && !rbAddonFamily6.isSelected() &&
                            !rbAddonFamily7.isSelected() && !rbAddonFamily8.isSelected() &&
                            addonBreakfastTextField.getText().equals("0")) {
                        JOptionPane.showMessageDialog(null,
                                "You must select at least one addon",
                                "Warning",
                                JOptionPane.WARNING_MESSAGE);
                        validSelection = false;
                    }
                }

                if (validSelection) {
                    int currentFamilybil = (SingleRoom == 0) ? counterLoop : counterLoop - SingleRoom;
                    FamilyRChoice[currentFamilybil] = getFamilyRoomTypeSelected();

                    if (rbAddon1.isSelected()) {
                        CheckAddon('F', currentFamilybil);
                    }
                    tempF--; // Only decrease if valid
                }
            }

            if (validSelection) {
                resetFormValues();
                counterLoop++; // Only increment if valid

                if (counterLoop < roomBil) {
                    RoomLoop(); // Update UI for next room
                } else {
                    thisBookingDetails.setRoomChoises(SingleRChoice, FamilyRChoice);
                    thisBookingDetails.setAddonChoises(AddonChoiceS, AddonChoiceF);

                    int o = JOptionPane.showOptionDialog(
                            null,
                            "All rooms have been selected.",
                            "Cats Hotel Booking System", JOptionPane.NO_OPTION,
                            JOptionPane.PLAIN_MESSAGE, null, optionButton, "default");
                    if (o == 0) {
                        JPanel parent = (JPanel) CustomerPage.this.getParent();
                        CardLayout layout = (CardLayout) parent.getLayout();

                        CustomerDetail customerDetail = new CustomerDetail(
                                e2 -> layout.show(parent, "Customer"),
                                bookingDetails,
                                currentIndex);

                        parent.add(customerDetail, "CustomerDetail");
                        layout.show(parent, "CustomerDetail");
                        parent.revalidate();
                        parent.repaint();
                    }
                }
            } else {
                // If validation failed, restore original values instead of decrementing
                counterLoop = originalCounterLoop;
                tempS = originalTempS;
                tempF = originalTempF;
            }
        }
    };

    public void resetFormValues() {
        buttonGroupAddonSingle1.clearSelection();
        buttonGroupAddonSingle2.clearSelection();

        buttonGroupAddonFamily1.clearSelection();
        buttonGroupAddonFamily2.clearSelection();
        buttonGroupAddonFamily3.clearSelection();
        buttonGroupAddonFamily4.clearSelection();

        buttonGroup2.clearSelection();

        buttonGroupAddon.clearSelection();

        comboboxSingle.setSelectedIndex(0);

        addonBreakfastTextField.setText("0");

        panelAddonSingle.setVisible(false);
        panelAddonFamily.setVisible(false);

        panel.revalidate();
        panel.repaint();
    }

    public void CheckAddon(char addon, int bil) {
        if (addon == 'S') {

            if (rbAddon1.isSelected()) {
                AddonChoiceS[bil][0] = rbAddonSingle1.isSelected() ? 1 : rbAddonSingle2.isSelected() ? 2 : 0;
                AddonChoiceS[bil][1] = rbAddonSingle3.isSelected() ? 1 : rbAddonSingle4.isSelected() ? 2 : 0;
            } else if (rbAddon2.isSelected()) {
                AddonChoiceS[bil][0] = 0;
                AddonChoiceS[bil][1] = 0;
            } else {
                AddonChoiceS[bil][0] = 0;
                AddonChoiceS[bil][1] = 0;
            }
        } else {

            if (rbAddon1.isSelected()) {
                try {
                    AddonChoiceF[bil][0] = !addonBreakfastTextField.getText().trim().isEmpty()
                            ? Integer.parseInt(addonBreakfastTextField.getText().trim())
                            : 0;
                } catch (NumberFormatException e) {
                    AddonChoiceF[bil][0] = 0;
                }

                AddonChoiceF[bil][1] = rbAddonFamily3.isSelected() ? 1 : rbAddonFamily4.isSelected() ? 2 : 0;
                AddonChoiceF[bil][2] = rbAddonFamily5.isSelected() ? 1 : rbAddonFamily6.isSelected() ? 2 : 0;
                AddonChoiceF[bil][3] = rbAddonFamily7.isSelected() ? 1 : rbAddonFamily8.isSelected() ? 2 : 0;
                try {
                    AddonChoiceF[bil][4] = !addonBreakfastTextField.getText().trim().isEmpty()
                            ? Integer.parseInt(addonBreakfastTextField.getText().trim())
                            : 0;
                } catch (NumberFormatException e) {
                    AddonChoiceF[bil][4] = 0;
                }
            } else if (rbAddon2.isSelected()) {
                for (int i = 0; i < 5; i++) {
                    AddonChoiceF[bil][i] = 0;
                }
            } else {
                for (int i = 0; i < 5; i++) {
                    AddonChoiceF[bil][i] = 0;
                }
            }
        }
        thisBookingDetails.setAddonChoises(AddonChoiceS, AddonChoiceF);
    }

    public void RoomLoop() {
        // This will ensure the first room is ready to be selected
        if (counterLoop <= roomBil) {
            if (tempS > 0) {
                chooseRoomLabel.setText("Choose SINGLE Room " + (counterLoop + 1) + " : ");

                AddonLabel1.setText(
                        "We will provide a room with 1 slippers, 1 pillows, 1 towel, and 1 person breakfast. ");

                panelChooseLoop.add(panelSingle, BorderLayout.CENTER);
                panelSingle.setVisible(true);
                panelFamily.setVisible(false);
                BedType = 'S';
            } else if (tempF > 0) {
                if (SingleRoom == 0) {
                    chooseRoomLabel.setText("Choose FAMILY Room " + (counterLoop + 1) + " : ");
                } else {
                    chooseRoomLabel.setText("Choose FAMILY Room " + (counterLoop + 1 - SingleRoom) + " : ");
                }

                AddonLabel1.setText(
                        "We will provide your room with 2 double beds, 4 pillows, 4 slippers, 4 towels and 4 person breakfast.");

                panelChooseLoop.add(panelFamily, BorderLayout.CENTER);
                panelFamily.setVisible(true);
                panelSingle.setVisible(false);
                BedType = 'F';
            }

            panelChooseLoop.add(panelAddon, BorderLayout.SOUTH);

            panel.revalidate();
            panel.repaint();
        }
    }

    private JButton createStyledButton(String text, Dimension size) {
        JButton button = new JButton(text);
        button.setPreferredSize(size);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        return button;
    }

    public int getFamilyRoomTypeSelected() {
        if (rbfamily1.isSelected()) {
            return 1;
        } else if (rbfamily2.isSelected()) {
            return 2;
        } else if (rbfamily3.isSelected()) {
            return 3;
        }
        return 0;
    }

    ItemListener comboboxItemListener = new ItemListener() {
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                int selectedIndex = comboboxSingle.getSelectedIndex();

                if (selectedIndex != 0) {
                    AddonLabel1.setText(
                            "We will provide a room with 2 slippers, 2 pillows, 2 towel, and 2 person breakfast. ");
                } else {
                    AddonLabel1.setText(
                            "We will provide a room with 1 slippers, 1 pillows, 1 towel, and 1 person breakfast. ");
                }
            }
        }
    };

    ItemListener radioButtonItemListener = new ItemListener() {
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == rbAddon1 && rbAddon1.isSelected()) {
                if (BedType == 'S') {
                    panelAddon.add(panelAddonSingle, BorderLayout.CENTER);
                    panelAddonSingle.setVisible(true);
                } else {
                    panelAddon.add(panelAddonFamily, BorderLayout.CENTER);
                    panelAddonFamily.setVisible(true);
                }
            } else {
                panelAddonSingle.setVisible(false);
                panelAddonFamily.setVisible(false);
            }
            panel.revalidate();
            panel.repaint();
        }
    };
}
