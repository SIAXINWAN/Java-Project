package JavaProject.FramePage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerPage extends JPanel {
    JPanel panel = new JPanel(new BorderLayout());
    JPanel panel1 = new JPanel();
    JPanel panelSingle = new JPanel();
    JPanel panelFamily = new JPanel(new GridLayout(4, 3, 10, 10));

    JRadioButton rbSingle = new JRadioButton("Single");
    JRadioButton rbFamily = new JRadioButton("Family");

    ButtonGroup buttonGroup1 = new ButtonGroup(); 

    String singleBedType[] = {"Single bed", "Queen bed", "King bed"}; 
    JComboBox<String> comboboxSingle = new JComboBox<String>(singleBedType);

    JRadioButton rbfamily1 = new JRadioButton("Option 1 : ");
    JRadioButton rbfamily2 = new JRadioButton("Option 2 : ");
    JRadioButton rbfamily3 = new JRadioButton("Option 3 : ");

    ButtonGroup buttonGroup2 = new ButtonGroup();    

    public CustomerPage(ActionListener homeAction) {
        setLayout(new BorderLayout());

        // JLabel customerLabel = new JLabel("Customer Page", JLabel.CENTER);
        // customerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        // add(customerLabel, BorderLayout.CENTER);

        JButton homeButton = new JButton("Home");
        homeButton.setFont(new Font("Arial", Font.BOLD, 18));
        homeButton.setPreferredSize(new Dimension(100, 40));
        homeButton.addActionListener(homeAction);

        JPanel homePanel = new JPanel();
        homePanel.add(homeButton);
        add(homePanel, BorderLayout.SOUTH);

        buttonGroup1.add(rbSingle); buttonGroup1.add(rbFamily);
        panel1.add(rbSingle); panel1.add(rbFamily); 

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
