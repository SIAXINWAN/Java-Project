package JavaProject.FramePage.Staff;

import javax.swing.*;

import JavaProject.model.Staff;

import java.awt.*;
import java.awt.event.ActionListener;

public class StaffDetail extends JPanel {

    public StaffDetail(ActionListener homeAction) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Staff Details", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));



        JButton homeButton = new JButton("Home");
        homeButton.setFont(new Font("Arial", Font.BOLD, 18));
        homeButton.setPreferredSize(new Dimension(100, 40));
        homeButton.addActionListener(homeAction);

        JPanel homePanel = new JPanel();
        homePanel.add(homeButton);
        add(homePanel, BorderLayout.SOUTH);

        add(label, BorderLayout.NORTH);
    }
}
