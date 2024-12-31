package JavaProject.FramePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StaffPage extends JPanel {
    public StaffPage(ActionListener homeAction) {
        setLayout(new BorderLayout());

        JLabel staffLabel = new JLabel("Staff Page", JLabel.CENTER);
        staffLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(staffLabel, BorderLayout.CENTER);

        JButton homeButton = new JButton("Home");
        homeButton.setFont(new Font("Arial", Font.BOLD, 18));
        homeButton.setPreferredSize(new Dimension(100, 40));
        homeButton.addActionListener(homeAction);

        JPanel homePanel = new JPanel();
        homePanel.add(homeButton);
        add(homePanel, BorderLayout.SOUTH);
    }
}
