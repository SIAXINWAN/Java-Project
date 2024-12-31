package JavaProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutExample {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("CardLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the CardLayout panel
        JPanel cardPanel = new JPanel(new CardLayout());

        // Create the "pages"
        JPanel page1 = new JPanel();
        page1.setBackground(Color.LIGHT_GRAY);
        JButton toPage2 = new JButton("Go to Page 2");
        page1.add(new JLabel("This is Page 1"));
        page1.add(toPage2);

        JPanel page2 = new JPanel();
        page2.setBackground(Color.PINK);
        JButton toPage1 = new JButton("Go to Page 1");
        page2.add(new JLabel("This is Page 2"));
        page2.add(toPage1);

        // Add the pages to the CardLayout panel
        cardPanel.add(page1, "Page1");
        cardPanel.add(page2, "Page2");

        // Add action listeners to the buttons to switch pages
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();

        toPage2.addActionListener(e -> cardLayout.show(cardPanel, "Page2"));
        toPage1.addActionListener(e -> cardLayout.show(cardPanel, "Page1"));

        // Add the CardLayout panel to the frame
        frame.add(cardPanel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
