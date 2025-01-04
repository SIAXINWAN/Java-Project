package JavaProject.FramePage.Customer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerPage extends JPanel {
    int roomMax = 10;
    int SingleMax = 3;
    int FamilyMax = 7; 
    int HolidayAdd = 20; 

    int roomBil;
    int SingleRoom;
    int FamilyRoom;

    int SingleRChoice[] = new int[SingleMax];
    int FamilyRChoice[] = new int[FamilyMax];
    int AddonChoiceS[][] = new int[SingleMax][2];
    int AddonChoiceF[][] = new int[FamilyMax][5];

    int tempS;
    int tempF;
    int counterLoop = 0;

    char BedType;

    JPanel panel = new JPanel(new BorderLayout());    
    JPanel panel1 = new JPanel();
    JPanel panelRoomBilTotal = new JPanel(new BorderLayout());
    JPanel panelRBTLabel = new JPanel(new BorderLayout());
    JPanel panelRoom = new JPanel(new BorderLayout());
    JPanel buttonPanel1 = new JPanel();
    JPanel panelChooseLoop = new JPanel(new BorderLayout());
    JPanel panelSingle = new JPanel(new BorderLayout());
    JPanel panelFamily = new JPanel(new BorderLayout());
    JPanel panelFamilyOption = new JPanel(new GridLayout(4, 3, 10, 10));
    JPanel panelAddonOption = new JPanel(new BorderLayout());
    JPanel panelAddon = new JPanel(new BorderLayout());
    JPanel panelAddonSingle = new JPanel(new GridLayout(2, 2, 10, 10));
    JPanel panelAddonFamily = new JPanel(new GridLayout(5, 2, 10, 10));
    JPanel buttonPanel2 = new JPanel();

    JTextField roomBilTextField = new JTextField();

    JTextField SingleRTextField = new JTextField();
    JTextField FamilyRTextField = new JTextField();

    JButton buttonConfirmRoom = new JButton("Confirm");
    JButton buttonCancelRoom = new JButton("Cancel");

    JLabel chooseRoomLabel = new JLabel();

    JButton buttonDone = new JButton("Done");

    String singleBedType[] = {"Single bed (RM 80.00 ++)", "Queen bed (RM 120.00 ++)", "King bed (RM 120.00 ++)"}; 
    JComboBox<String> comboboxSingle = new JComboBox<String>(singleBedType);

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

    public CustomerPage(ActionListener homeAction) {
        setLayout(new BorderLayout());

        JPanel panelN1 = new JPanel();
        JLabel customerLabel = new JLabel("Customer Booking");
        customerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panelN1.add(customerLabel, BorderLayout.NORTH);

        JButton homeButton = new JButton("Home");
        homeButton.setFont(new Font("Arial", Font.BOLD, 16));
        homeButton.setPreferredSize(new Dimension(100, 40));
        homeButton.addActionListener(homeAction);

        JPanel homePanel = new JPanel();
        homePanel.add(homeButton);
        add(homePanel, BorderLayout.SOUTH);

        
        JLabel labelPRBT1 = new JLabel("Single room: RM 80.00 - RM 120.00++ \t\t| Family room : RM 200.00++ ");
        JLabel labelPRBT2 = new JLabel("* If it's the holiday season, each room will add-on RM " + HolidayAdd + ".00 .");
        JLabel labelPRBT3 = new JLabel("How many rooms IN TOTAL you want (Maximum " + roomMax + " ) (Single Max - " + SingleMax + ") (Family Max - " + FamilyMax + ") :  *Click Enter to continue");
        
        panelRBTLabel.add(labelPRBT1, BorderLayout.NORTH); //RBT stand for Room Bil Total
        panelRBTLabel.add(labelPRBT2, BorderLayout.CENTER);
        panelRBTLabel.add(labelPRBT3, BorderLayout.SOUTH);
        panelRoomBilTotal.add(panelRBTLabel, BorderLayout.NORTH);
        panelRoomBilTotal.add(roomBilTextField, BorderLayout.CENTER);

        roomBilTextField.addActionListener(roomBilTotalTextFieldActionListener);

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel1.add(panelN1); panel1.add(panelRoomBilTotal); 
        


        JPanel panelRoomBil = new JPanel(new GridLayout(2, 2, 10, 10));
        panelRoomBil.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        JLabel labelPRB1 = new JLabel("Single room: ");
        JLabel labelPRB2 = new JLabel("Family room: ");        

        panelRoomBil.add(labelPRB1);        
        panelRoomBil.add(labelPRB2);
        panelRoomBil.add(SingleRTextField);
        panelRoomBil.add(FamilyRTextField);

        SingleRTextField.addActionListener(roomBilTextFieldActionListener);
        FamilyRTextField.addActionListener(roomBilTextFieldActionListener);

        

        buttonConfirmRoom.setPreferredSize(new Dimension(100, 40));
        buttonCancelRoom.setPreferredSize(new Dimension(100, 40));

        buttonConfirmRoom.addActionListener(buttonRoomActionListener);
        buttonCancelRoom.addActionListener(buttonRoomActionListener);

        buttonPanel1.add(buttonConfirmRoom);
        buttonPanel1.add(buttonCancelRoom);
        
        panelRoom.add(panelRoomBil, BorderLayout.NORTH);
        panelRoom.add(buttonPanel1, BorderLayout.CENTER);



        panelChooseLoop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        chooseRoomLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panelChooseLoop.add(chooseRoomLabel, BorderLayout.NORTH);        

        panel.add(panel1, BorderLayout.NORTH);

        
        comboboxSingle.addItemListener(comboboxItemListener);

        panelSingle.add(comboboxSingle, BorderLayout.NORTH);
        //panelSingle.add(panelAddonOption, BorderLayout.CENTER);

        
        
        //panelFamily.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonGroup2.add(rbfamily1); buttonGroup2.add(rbfamily2); buttonGroup2.add(rbfamily3);
        
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
        //panelFamily.add(AddonLabelFamily1, BorderLayout.CENTER);
        //panelFamily.add(AddonLabelFamily2, BorderLayout.SOUTH);      



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

        //panelAddonOption.add(buttonPanel2, BorderLayout.SOUTH);
        


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



        add(panel, BorderLayout.NORTH);
    }

    ActionListener roomBilTotalTextFieldActionListener = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            String roomBilS = roomBilTextField.getText();
            roomBil = Integer.parseInt(roomBilS);

            if (roomBil > roomMax)
            {
                JOptionPane.showMessageDialog(null, "In total only MAXIMUM " + roomMax + " room we have", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                panel1.add(panelRoom);
                if (!FamilyRTextField.getText().isEmpty() || !SingleRTextField.getText().isEmpty())
                {
                    FamilyRoom = roomBil - SingleRoom;
                    if (FamilyRoom > FamilyMax)
                    {
                        FamilyRoom = FamilyMax;
                        SingleRoom = roomBil - FamilyRoom;
                        SingleRTextField.setText(Integer.toString(SingleRoom));
                    }
                    FamilyRTextField.setText(Integer.toString(FamilyRoom));
                }
            }

            
            panel.revalidate();
            panel.repaint();
        }
    };    

    ActionListener roomBilTextFieldActionListener = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == SingleRTextField)
            {
                String temp1 = SingleRTextField.getText();
                SingleRoom = Integer.parseInt(temp1);
                if (SingleRoom > roomBil)
                {
                    JOptionPane.showMessageDialog(null, "You only have choosed " + roomBil + " room", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                else if (SingleRoom > SingleMax)
                {
                    JOptionPane.showMessageDialog(null, "In total only MAXIMUM " + SingleMax + " SINGLE room we have", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    FamilyRoom = roomBil - SingleRoom;
                    FamilyRTextField.setText(Integer.toString(FamilyRoom));
                }
            }
            else
            {
                String temp2 = FamilyRTextField.getText();
                FamilyRoom = Integer.parseInt(temp2);
                if (FamilyRoom > roomBil)
                {
                    JOptionPane.showMessageDialog(null, "You only have choosed " + roomBil + " room", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                else if (FamilyRoom > FamilyMax)
                {
                    JOptionPane.showMessageDialog(null, "In total only MAXIMUM " + FamilyMax + " FAMILY room we have", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    SingleRoom = roomBil - FamilyRoom;
                    SingleRTextField.setText(Integer.toString(SingleRoom));
                }
            }
            panel.revalidate();
            panel.repaint();
        }
    };

    ActionListener buttonRoomActionListener = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            if (SingleRTextField.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Single room text field is empty ", "Warning", JOptionPane.WARNING_MESSAGE);

            }
            else if (FamilyRTextField.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Family room text field is empty ", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else 
            {
                if (e.getSource() == buttonConfirmRoom)
                {
                    roomBilTextField.setEditable(false);
                    SingleRTextField.setEditable(false);
                    FamilyRTextField.setEditable(false);

                    panel.add(panelChooseLoop, BorderLayout.CENTER);
                    panelChooseLoop.setVisible(true);
                    counterLoop = 1;
                    tempS = SingleRoom;
                    tempF = FamilyRoom;

                    RoomLoop();
                }
                else
                {
                    roomBilTextField.setEditable(true);
                    SingleRTextField.setEditable(true);
                    FamilyRTextField.setEditable(true);

                    panelChooseLoop.setVisible(false);
                    counterLoop = 0;
                }
            }            
            panel.revalidate();
            panel.repaint();
        }
    };

    
    String optionButton[] = {"Continue","Cancel"};
    ActionListener buttonDoneActionListener = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            boolean validSelection = true; 
            if (tempS > 0)
            {
                SingleRChoice[counterLoop] = comboboxSingle.getSelectedIndex();

                if (!rbAddon1.isSelected() && !rbAddon2.isSelected())
                {
                    JOptionPane.showMessageDialog(null, "Addon field is empty", "Warning", JOptionPane.WARNING_MESSAGE);
                    validSelection = false;
                    counterLoop--;
                    tempS++;
                }
                tempS--;  // Decrease available Single room after selection
            }
            else if (tempF > 0)
            {
                if (getFamilyRoomTypeSelected() == 0)
                {
                    JOptionPane.showMessageDialog(null, "Please select at least one option", "Warning", JOptionPane.WARNING_MESSAGE);
                    validSelection = false;
                    counterLoop--;
                    tempF++;
                }
                else if (!rbAddon1.isSelected() && !rbAddon2.isSelected())
                {
                    JOptionPane.showMessageDialog(null, "Addon field is empty", "Warning", JOptionPane.WARNING_MESSAGE);
                    validSelection = false;
                    counterLoop--;
                    tempF++;
                }

                if (SingleRoom == 0)
                {
                    FamilyRChoice[counterLoop] = getFamilyRoomTypeSelected();
                }
                else
                {
                    FamilyRChoice[(counterLoop - SingleRoom)] = getFamilyRoomTypeSelected();
                }
                
                tempF--;  // Decrease available Family room after selection
            }

            if (validSelection)
            {
                buttonGroup2.clearSelection();
                buttonGroupAddon.clearSelection();
            }       

            if (counterLoop < roomBil) {
                counterLoop++;  // Move to the next room                
                RoomLoop();  // Call RoomLoop again to update UI for the next room
            } 
            else {
                // Once all rooms are processed, you can hide the loop panel or show a summary
                
                int o =  JOptionPane.showOptionDialog(
                    null, 
                    "All rooms have been selected.",
                    "Cats Hotel Booking System", JOptionPane.NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE,null,optionButton,"default"
                );
                if(o==0)
                {
                    JPanel parent = (JPanel)CustomerPage.this.getParent();
                    CardLayout layout = (CardLayout)parent.getLayout();
                    layout.show(parent, "CustomerConfirm");
                }
            }
        }
    };

   public void RoomLoop() 
   {
        // This will ensure the first room is ready to be selected
        if (counterLoop <= roomBil) 
        {
            if (tempS > 0) 
            {
                chooseRoomLabel.setText("Choose SINGLE Room " + counterLoop + " : ");

                AddonLabel1.setText("We will provide a room with 1 slippers, 1 pillows, 1 towel, and 1 person breakfast. ");
                
                panelChooseLoop.add(panelSingle, BorderLayout.CENTER);
                panelSingle.setVisible(true);
                panelFamily.setVisible(false);
                BedType = 'S';
            }
            else if (tempF > 0) 
            {
                if (SingleRoom == 0)
                {
                    chooseRoomLabel.setText("Choose FAMILY Room " + counterLoop + " : ");
                }
                else
                {
                    chooseRoomLabel.setText("Choose FAMILY Room " + (counterLoop - SingleRoom) + " : ");
                }

                AddonLabel1.setText("We will provide your room with 2 double beds, 4 pillows, 4 slippers, 4 towels and 4 person breakfast.");
            
                panelChooseLoop.add(panelFamily, BorderLayout.CENTER);
                panelFamily.setVisible(true);
                panelSingle.setVisible(false);
                BedType = 'F';
            }

            panelChooseLoop.add(panelAddon, BorderLayout.SOUTH);

            // Update panel after showing the room selection UI
            panel.revalidate();
            panel.repaint();
        }
    }

    public int getFamilyRoomTypeSelected()
    {
        if (rbfamily1.isSelected())
        {
            return 1;
        }
        else if (rbfamily2.isSelected())
        {
            return 2;
        }
        else if (rbfamily3.isSelected())
        {
            return 3;
        }
        return 0;
    }

    ItemListener comboboxItemListener = new ItemListener() 
    {
        public void itemStateChanged(ItemEvent e) 
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
            {
                int selectedIndex = comboboxSingle.getSelectedIndex();

                if (selectedIndex != 0)
                {
                    AddonLabel1.setText("We will provide a room with 2 slippers, 2 pillows, 2 towel, and 2 person breakfast. ");
                }
                else
                {
                    AddonLabel1.setText("We will provide a room with 1 slippers, 1 pillows, 1 towel, and 1 person breakfast. ");
                }
            }
        }
    };

    ItemListener radioButtonItemListener = new ItemListener() 
    {
        public void itemStateChanged(ItemEvent e) 
        {
            if (e.getSource() == rbAddon1 && rbAddon1.isSelected())
            {
                if (BedType == 'S')
                {
                    panelAddon.add(panelAddonSingle, BorderLayout.CENTER);
                    panelAddonSingle.setVisible(true);
                }
                else
                {
                    panelAddon.add(panelAddonFamily, BorderLayout.CENTER);
                    panelAddonFamily.setVisible(true);
                }
            }
            else
            {
                panelAddonSingle.setVisible(false);
                panelAddonFamily.setVisible(false);
            }
            panel.revalidate();
            panel.repaint();
        }
    };
}
