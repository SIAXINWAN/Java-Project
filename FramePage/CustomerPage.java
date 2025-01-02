package JavaProject.FramePage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerPage extends JPanel {
    int roomMax = 10;
    int SingleMax = 3;
    int FamilyMax = 7;

    int roomBil;

    JPanel panel = new JPanel(new BorderLayout());    
    JPanel panel1 = new JPanel();
    JPanel panelRoomBil = new JPanel(new BorderLayout());
    JPanel panelN2 = new JPanel();
    JPanel panelSingle = new JPanel();
    JPanel panelFamily = new JPanel(new GridLayout(4, 3, 10, 10));
    JPanel panelAddon = new JPanel();

    JTextField roomBilTextFeild = new JTextField();

    JRadioButton rbSingle = new JRadioButton("Single Room");
    JRadioButton rbFamily = new JRadioButton("Family Room");

    ButtonGroup buttonGroup1 = new ButtonGroup(); 

    String singleBedType[] = {"Single bed", "Queen bed", "King bed"}; 
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

        
        JLabel labelPRB1 = new JLabel("Single room: RM 80.00 - RM 120.00++ \t\t| Family room : RM 200.00++ ");
        JLabel labelPRB2 = new JLabel("How many rooms IN TOTAL you want (Maximum " + roomMax + " ) (Single Max - " + SingleMax + ") (Family Max - " + FamilyMax + ") : *Click Enter when you done");
        
        panelRoomBil.add(labelPRB1, BorderLayout.NORTH); 
        panelRoomBil.add(labelPRB2, BorderLayout.CENTER);
        panelRoomBil.add(roomBilTextFeild, BorderLayout.SOUTH);

        roomBilTextFeild.addActionListener(roomBilTextFieldActionListener);        

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel1.add(panelN1); panel1.add(panelRoomBil); 
        
        
        JLabel chooseRoomLabel = new JLabel("Choose Room Type:\n");
        chooseRoomLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panelN2.add(chooseRoomLabel);
        buttonGroup1.add(rbSingle); buttonGroup1.add(rbFamily);
        panelN2.add(rbSingle); panelN2.add(rbFamily); 

        

        rbSingle.addActionListener(rbActionListener);
        rbFamily.addActionListener(rbActionListener);

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

        

        
        

        add(panel, BorderLayout.NORTH);
    }

    ActionListener roomBilTextFieldActionListener = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            String roomBilS = roomBilTextFeild.getText();
            roomBil = Integer.parseInt(roomBilS);

            if (roomBil > roomMax)
            {
                JOptionPane.showMessageDialog(null, "In total only MAXIMUM " + roomMax + " room we have", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                panel1.add(panelN2);
            }
            panel.revalidate();
            panel.repaint();
        }
    };

    ActionListener rbActionListener = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == rbSingle)
            {
                panel.add(panelSingle, BorderLayout.CENTER);
                panelSingle.setVisible(true);
                panelFamily.setVisible(false);
            }
            else 
            {
                panel.add(panelFamily, BorderLayout.CENTER);
                panelFamily.setVisible(true);
                panelSingle.setVisible(false);
            }
            panel.revalidate();
            panel.repaint();
        }
    };

    ItemListener comboboxItemListener = new ItemListener() 
    {
        public void itemStateChanged(ItemEvent e) 
        {
            System.out.println();
        }
    };
}
