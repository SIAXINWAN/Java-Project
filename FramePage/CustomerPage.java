package JavaProject.FramePage;

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

    int tempS;
    int tempF;
    int counterLoop = 0;

    JPanel panel = new JPanel(new BorderLayout());    
    JPanel panel1 = new JPanel();
    JPanel panelRoomBilTotal = new JPanel(new BorderLayout());
    JPanel panelRBTLabel = new JPanel(new BorderLayout());
    JPanel panelRoom = new JPanel(new BorderLayout());
    JPanel buttonPanel1 = new JPanel();
    JPanel panelChooseLoop = new JPanel(new BorderLayout());
    JPanel panelSingle = new JPanel();
    JPanel panelFamily = new JPanel(new GridLayout(4, 3, 10, 10));
    JPanel panelAddon = new JPanel();
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



        
        chooseRoomLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panelChooseLoop.add(chooseRoomLabel, BorderLayout.NORTH);        

        panel.add(panel1, BorderLayout.NORTH);

        comboboxSingle.addItemListener(comboboxItemListener);

        panelSingle.add(comboboxSingle);
        

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

        panelFamily.add(label1);
        panelFamily.add(label2);
        panelFamily.add(label3);
        panelFamily.add(rbfamily1);
        panelFamily.add(label4);
        panelFamily.add(label5);
        panelFamily.add(rbfamily2);
        panelFamily.add(label6);
        panelFamily.add(label7);
        panelFamily.add(rbfamily3);
        panelFamily.add(label8);
        panelFamily.add(label9);



        buttonDone.setPreferredSize(new Dimension(100, 40));
        buttonDone.addActionListener(buttonDoneActionListener);

        buttonPanel2.add(buttonDone);

        panelChooseLoop.add(buttonPanel2, BorderLayout.SOUTH);



        
        

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

    

    ActionListener buttonDoneActionListener = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            if (tempS > 0)
            {
                SingleRChoice[counterLoop] = comboboxSingle.getSelectedIndex();
                tempS--;  // Decrease available Single room after selection
            }
            else if (tempF > 0)
            {
                if (getFamilyRoomTypeSelected() == 0)
                {
                    JOptionPane.showMessageDialog(null, "Please select at least one option", "Warning", JOptionPane.WARNING_MESSAGE);
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

            if (counterLoop < roomBil) {
                counterLoop++;  // Move to the next room
                RoomLoop();  // Call RoomLoop again to update UI for the next room
            } 
            else {
                // Once all rooms are processed, you can hide the loop panel or show a summary
                JOptionPane.showMessageDialog(null, "All rooms have been selected.");
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
                panelChooseLoop.add(panelSingle, BorderLayout.CENTER);
                panelSingle.setVisible(true);
                panelFamily.setVisible(false);
                
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
            
                panelChooseLoop.add(panelFamily, BorderLayout.CENTER);
                panelFamily.setVisible(true);
                panelSingle.setVisible(false);
                
            }

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
            System.out.println();
        }
    };
}
