package JavaProject.FramePage.Staff;

import JavaProject.FramePage.MainFrame;
import JavaProject.model.Staff;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StaffPage extends JPanel {

    private final Staff[] staffList;

    JLabel labelWelcome = new JLabel("");
    JTextField usernamTextField = new JTextField();
    JTextField passwordTextField = new JTextField();

    public StaffPage(ActionListener homeAction, CardLayout cardLayout, JPanel cardPanel,
            Staff[] staffList) {
        this.staffList = staffList;

        setLayout(new BorderLayout());

        JButton homeButton = new JButton("Back");
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
        buttonLogin.setPreferredSize(new Dimension(100, 40));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buttonLogin);

        panel1.add(buttonPanel, BorderLayout.SOUTH);

        add(panel1, BorderLayout.NORTH);

        add(labelWelcome, BorderLayout.CENTER);
    }

    public void resetFields() {
        usernamTextField.setText("");
        passwordTextField.setText("");
    }

    ActionListener loginaActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            boolean loginSuccess = false;
            Staff loggedInStaff = null;

            if (usernamTextField.getText().trim().isEmpty() || passwordTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        StaffPage.this,
                        "Please enter both Staff ID and Password",
                        "Login Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (Staff staff : staffList) {
                if (staff.getStaffID().equals(usernamTextField.getText())) {
                    if (staff.getPassword().equals(passwordTextField.getText())) {
                        loginSuccess = true;
                        loggedInStaff = staff;
                        break;
                    } else {
                        JOptionPane.showMessageDialog(
                                StaffPage.this,
                                "Incorrect password",
                                "Login Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            if (loginSuccess) {
                resetFields();
                StaffDetail.refreshData();
                MainFrame.setCurrentStaff(loggedInStaff);
                JPanel parent = (JPanel) StaffPage.this.getParent();
                CardLayout layout = (CardLayout) parent.getLayout();
                layout.show(parent, "StaffDetail");
            } else {
                JOptionPane.showMessageDialog(
                        StaffPage.this,
                        "Staff ID not found",
                        "Login Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    };
}
