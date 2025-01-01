package JavaProject.FramePage.Staff;

import JavaProject.model.Staff;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StaffPage extends JPanel {
    Staff staff1 = new Staff("P01", "Chiew Chin Kuan", "0129318660", "S01", false, "07/02/2005");
    Staff staff2 = new Staff("P02", "Chiew Chin Kuan", "0129318660", "S02", false, "07/02/2005");
    Staff staff3 = new Staff("P03", "Chiew Chin Kuan", "0129318660", "S03", false, "07/02/2005");
    Staff staff4 = new Staff("P04", "Chiew Chin Kuan", "0129318660", "S04", false, "07/02/2005");

    Staff[] stafflist = {staff1, staff2, staff3, staff4};

    JLabel labelWelcome = new JLabel("");
    JTextField usernamTextField = new JTextField();
    JTextField passwordTextField = new JTextField();   

    public StaffPage(ActionListener homeAction,CardLayout cardLayout,JPanel cardPanel) {
        setLayout(new BorderLayout());

        usernamTextField.setText("S01");
        passwordTextField.setText("P01S01");

        // 
        // staffLabel.setFont(new Font("Arial", Font.BOLD, 20));
        // add(staffLabel, BorderLayout.CENTER);

        JButton homeButton = new JButton("Home");
        homeButton.setFont(new Font("Arial", Font.BOLD, 18));
        homeButton.setPreferredSize(new Dimension(100, 40));
        homeButton.addActionListener(homeAction);

        JPanel homePanel = new JPanel();
        homePanel.add(homeButton);
        add(homePanel, BorderLayout.SOUTH);

        
        
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel loginLabel = new JLabel("Staff Login Page", JLabel.CENTER);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 20));


        panel1.add(loginLabel, BorderLayout.NORTH);

        JPanel panel1_1 = new JPanel(new GridLayout(2, 2, 10, 10));
        panel1_1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel1_1.setPreferredSize(new Dimension(800, 100));

        JLabel usernamLabel = new JLabel("StaffID: ", JLabel.CENTER);
        JLabel passwordLabel = new JLabel("Password: ", JLabel.CENTER);
        
        

        panel1_1.add(usernamLabel); 
        panel1_1.add(usernamTextField);
        panel1_1.add(passwordLabel);
        panel1_1.add(passwordTextField);

        panel1.add(panel1_1, BorderLayout.CENTER);

        JButton buttonLogin = new JButton("Login");
        buttonLogin.addActionListener(loginaActionListener);

        panel1.add(buttonLogin, BorderLayout.SOUTH);

        add(panel1, BorderLayout.NORTH);

        add(labelWelcome, BorderLayout.CENTER);
    }

    ActionListener loginaActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
            boolean loginSuccess = false;
            
                for (Staff staff : stafflist) {
                    if (staff.getStaffID().equals(usernamTextField.getText()) && staff.getPassword().equals(passwordTextField.getText())) {
                        //labelWelcome.setText("Welcome " + staff.getName());
                        loginSuccess = true;
                        break;
                    }
                }
    
                if (loginSuccess) {
                    JPanel parent = (JPanel) StaffPage.this.getParent();
                    CardLayout layout = (CardLayout) parent.getLayout();
                   
                    layout.show(parent, "StaffDetail"); // Navigate to StaffDetail page
                }

            

            if (!loginSuccess)
            {
                labelWelcome.setText("Login Failed");
            }
        }
    };
}
