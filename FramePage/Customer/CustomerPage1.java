package JavaProject.FramePage.Customer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import JavaProject.FramePage.Staff.StaffPage;


public class CustomerPage1 extends JPanel{
    int roomMax = 10;
    int SingleMax = 3;
    int FamilyMax = 7; 
    int HolidayAdd = 20; 

    int roomBil;
    int SingleRoom;
    int FamilyRoom;

    JPanel panel1 = new JPanel(new BorderLayout());
    JPanel panelChooseDate = new JPanel(new BorderLayout());
    JPanel panelChooseFromNToDate = new JPanel(new BorderLayout());
    JPanel panelChooseFromDate = new JPanel();
    JPanel panelChooseToDate = new JPanel();
    JPanel panelRBTLabel = new JPanel(new BorderLayout());
    JPanel panelRoomBilTotal = new JPanel(new BorderLayout());
    JPanel panelRoom = new JPanel(new BorderLayout());
    JPanel buttonPanel1 = new JPanel();


    Integer[] days = new Integer[31];
    Integer[] months = new Integer[12];
    Integer[] years = {2024, 2025};
    String[] monthsName = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    JComboBox<Integer> dayFComboBox;
    JComboBox<Integer> monthFComboBox;
    JComboBox<Integer> yearFComboBox;

    JComboBox<Integer> dayTComboBox;
    JComboBox<Integer> monthTComboBox;
    JComboBox<Integer> yearTComboBox;

    JButton buttonConfirm = new JButton("Confirm");
    JButton buttonCancel = new JButton("Cancel");

    int totalBookingNight;
    String CheckInDate;
    String CheckOutDate;

    JTextField roomBilTextField = new JTextField();

    JTextField SingleRTextField = new JTextField();
    JTextField FamilyRTextField = new JTextField();

    JButton buttonConfirmRoom = new JButton("Confirm");
    JButton buttonCancelRoom = new JButton("Cancel");



    public CustomerPage1(ActionListener homeAction, ActionListener navigateToCustomerPage)
    {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Customer Booking", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        add(titleLabel,BorderLayout.NORTH);

        JButton homeButton = new JButton("Back");
        homeButton.setFont(new Font("Arial", Font.BOLD, 16));
        homeButton.setPreferredSize(new Dimension(100, 40));
        homeButton.addActionListener(homeAction);        

        JButton navigateButton = new JButton("Go to Customer Page");
        navigateButton.setFont(new Font("Arial", Font.BOLD, 16));
        navigateButton.setPreferredSize(new Dimension(200, 40));
        navigateButton.addActionListener(navigateToCustomerPage);

        JPanel navigationPanel = new JPanel();
        navigationPanel.add(homeButton);
        //navigationPanel.add(navigateButton);
        add(navigationPanel, BorderLayout.SOUTH);

        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < 31; i++)
        {
            days[i] = i + 1;
        }

        for (int i = 0; i < 12; i++)
        {
            months[i] = i + 1;
        }

        dayFComboBox = new JComboBox<>(days);
        monthFComboBox = new JComboBox<>(months);
        yearFComboBox = new JComboBox<>(years);

        dayTComboBox = new JComboBox<>(days);
        monthTComboBox = new JComboBox<>(months);
        yearTComboBox = new JComboBox<>(years);

        yearTComboBox.setSelectedIndex(yearFComboBox.getSelectedIndex());
        yearFComboBox.addItemListener(comboboxYearItemListener);
        yearTComboBox.addItemListener(comboboxYearItemListener);

        JLabel DateFLabel = new JLabel("Check in date: ");
        JLabel DateTLabel = new JLabel("Check out date: ");

        panelChooseFromDate.add(DateFLabel);
        panelChooseFromDate.add(dayFComboBox);
        panelChooseFromDate.add(monthFComboBox);
        panelChooseFromDate.add(yearFComboBox);

        panelChooseToDate.add(DateTLabel);
        panelChooseToDate.add(dayTComboBox);
        panelChooseToDate.add(monthTComboBox);
        panelChooseToDate.add(yearTComboBox);

        JLabel chooseDateLabel = new JLabel("How many nights you want to book ?  *Maximum booking 31 nights only");

        panelChooseFromNToDate.add(panelChooseFromDate, BorderLayout.NORTH);
        panelChooseFromNToDate.add(panelChooseToDate, BorderLayout.CENTER);

        panelChooseDate.add(chooseDateLabel, BorderLayout.NORTH);
        panelChooseDate.add(panelChooseFromNToDate, BorderLayout.CENTER);                

        JPanel panelButtonConfirm = new JPanel();
        buttonConfirm.setPreferredSize(new Dimension(100, 40));
        buttonConfirm.addActionListener(buttonConfirmActionListener);
        buttonCancel.setPreferredSize(new Dimension(100, 40));
        buttonCancel.setEnabled(false);
        buttonCancel.addActionListener(buttonConfirmActionListener);
        panelButtonConfirm.add(buttonConfirm);
        panelButtonConfirm.add(buttonCancel);

        panelChooseDate.add(panelButtonConfirm, BorderLayout.SOUTH);

        panel1.add(panelChooseDate, BorderLayout.NORTH);

        add(panel1, BorderLayout.CENTER);

        
        panelRoomBilTotal.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        JLabel labelPRBT1 = new JLabel("Single room: RM 80.00 - RM 120.00++ \t\t| Family room : RM 200.00++ ");
        //JLabel labelPRBT2 = new JLabel("* If it's the holiday season, each room will add-on RM " + HolidayAdd + ".00 .");
        JLabel labelPRBT3 = new JLabel("How many rooms IN TOTAL you want (Maximum " + roomMax + " ) (Single Max - " + SingleMax + ") (Family Max - " + FamilyMax + ") :  *Click Enter to continue");

        JPanel panelRBTextField = new JPanel(new BorderLayout());
        panelRBTextField.add(roomBilTextField, BorderLayout.NORTH);

        panelRBTLabel.add(labelPRBT1, BorderLayout.NORTH); //RBT stand for Room Bil Total
        //panelRBTLabel.add(labelPRBT2, BorderLayout.CENTER);
        panelRBTLabel.add(labelPRBT3, BorderLayout.CENTER);
        JPanel RBT = new JPanel(new BorderLayout());
        RBT.add(panelRBTLabel,BorderLayout.NORTH);
        RBT.add(panelRBTextField,BorderLayout.CENTER);
        panelRoomBilTotal.add(RBT, BorderLayout.NORTH);
        panelRoomBilTotal.setVisible(false);
        //panelRoomBilTotal.add(panelRBTextField, BorderLayout.CENTER);
        roomBilTextField.addActionListener(roomBilTotalTextFieldActionListener);
        

        JPanel panelRBGridLayout = new JPanel(new BorderLayout());

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

        buttonCancelRoom.setEnabled(false);
        buttonConfirmRoom.addActionListener(buttonRoomActionListener);
        buttonCancelRoom.addActionListener(buttonRoomActionListener);

        buttonPanel1.add(buttonConfirmRoom);
        buttonPanel1.add(buttonCancelRoom);

        panelRBGridLayout.add(panelRoomBil, BorderLayout.NORTH);
        
        JPanel rrt = new JPanel(new BorderLayout());
        rrt.add(panelRBGridLayout,BorderLayout.NORTH);
        rrt.add(buttonPanel1,BorderLayout.CENTER);

        panelRoom.add(rrt, BorderLayout.NORTH);
        //panelRoom.add(buttonPanel1, BorderLayout.CENTER);

        

        panel1.add(panelRoomBilTotal, BorderLayout.CENTER);
        
    }

    ActionListener buttonConfirmActionListener = new ActionListener() 
    {
        public void actionPerformed(ActionEvent e) 
        {
            boolean isValid = true; 
            if (monthFComboBox.getSelectedIndex() == monthTComboBox.getSelectedIndex())
            {
                if (dayTComboBox.getSelectedIndex() == dayFComboBox.getSelectedIndex())
                {
                    JOptionPane.showMessageDialog(null, "Check in date cannot same with check out date", "Warning", JOptionPane.WARNING_MESSAGE);
                isValid = false;
                }
                else if (dayFComboBox.getSelectedIndex() > dayTComboBox.getSelectedIndex())
                {
                    JOptionPane.showMessageDialog(null, "Check in date cannot bigger than check out date", "Warning", JOptionPane.WARNING_MESSAGE);
                    isValid = false;
                }
                
            }

            if (monthFComboBox.getSelectedIndex() > monthTComboBox.getSelectedIndex())
            {
                JOptionPane.showMessageDialog(null, "Check in date cannot bigger than check out date", "Warning", JOptionPane.WARNING_MESSAGE);
                isValid = false;
            }

            if (monthFComboBox.getSelectedIndex() % 2 == 1)
            {
                if (dayFComboBox.getSelectedIndex() >= 30)
                {
                    JOptionPane.showMessageDialog(null, monthsName[monthFComboBox.getSelectedIndex()] + " only have 30 days", "Warning", JOptionPane.WARNING_MESSAGE);
                    isValid = false;
                }
            }
            else if (monthTComboBox.getSelectedIndex() % 2 == 1)
            {
                if (dayTComboBox.getSelectedIndex() >= 30)
                {
                    JOptionPane.showMessageDialog(null, monthsName[monthFComboBox.getSelectedIndex()] + " only have 30 days", "Warning", JOptionPane.WARNING_MESSAGE);
                    isValid = false;
                }
            }

            if (monthTComboBox.getSelectedIndex() - monthFComboBox.getSelectedIndex() > 1)
            {
                JOptionPane.showMessageDialog(null, "Maximum booking 31 nights only", "Warning", JOptionPane.WARNING_MESSAGE);
                isValid = false;
            }

            int checkInDay = (int) dayFComboBox.getSelectedItem();
            int checkInMonth = (int) monthFComboBox.getSelectedItem();
            int checkOutDay = (int) dayTComboBox.getSelectedItem();
            int checkOutMonth = (int) monthTComboBox.getSelectedItem();

            int bookingDayIn;

            if (yearFComboBox.getSelectedIndex() == 0) // 2024 - leap year 
            {
                if (monthFComboBox.getSelectedIndex() == 1)
                {
                    if (dayFComboBox.getSelectedIndex() >= 29)
                    {
                        JOptionPane.showMessageDialog(null, "2024 February only have 29 days", "Warning", JOptionPane.WARNING_MESSAGE);
                        isValid = false;
                    }
                }
                else if (monthTComboBox.getSelectedIndex() == 1)
                {
                    if (dayTComboBox.getSelectedIndex() >= 29)
                    {
                        JOptionPane.showMessageDialog(null, "2024 February only have 29 days", "Warning", JOptionPane.WARNING_MESSAGE);
                        isValid = false;
                    }
                }

                if (checkInMonth == 2)
                {
                    bookingDayIn = 29 - checkInDay;
                }
            }
            else // 2025 not a leap year
            {
                if (monthFComboBox.getSelectedIndex() == 1)
                {
                    if (dayFComboBox.getSelectedIndex() >= 28)
                    {
                        JOptionPane.showMessageDialog(null, "2025 February only have 28 days", "Warning", JOptionPane.WARNING_MESSAGE);
                        isValid = false;
                    }
                }
                else if (monthTComboBox.getSelectedIndex() == 1)
                {
                    if (dayTComboBox.getSelectedIndex() >= 28)
                    {
                        JOptionPane.showMessageDialog(null, "2025 February only have 28 days", "Warning", JOptionPane.WARNING_MESSAGE);
                        isValid = false;
                    }
                }

                if (checkInMonth == 2)
                {
                    bookingDayIn = 28 - checkInDay;
                }                
            }

            if (checkInMonth % 2 == 0)
            {
                bookingDayIn = 30 - checkInDay;
            }
            else
            {
                bookingDayIn = 31 - checkInDay;
            }

            if (checkInMonth == checkOutMonth)
            {
                totalBookingNight = checkOutDay - checkInDay;
            }
            else
            {
                totalBookingNight = bookingDayIn + checkOutDay - 1;
            }            

            if (totalBookingNight > 31)
            {
                JOptionPane.showMessageDialog(null, "Maximum booking 31 nights only", "Warning", JOptionPane.WARNING_MESSAGE);
                isValid = false;
            }
            else
            {
                CheckInDate = checkInDay + "/" + checkInMonth + "/" + yearFComboBox.getSelectedItem(); 
                CheckOutDate  = checkOutDay + "/" + checkOutMonth + "/" + yearTComboBox.getSelectedItem(); 
            }
            

            if (isValid)
        {
            panelRoomBilTotal.setVisible(true);
            buttonConfirm.setEnabled(false);  // Optional: disable date confirmation after successful validation
            panel1.revalidate();
            panel1.repaint();
            buttonCancel.setEnabled(true);
        }

        
            if (e.getSource() == buttonCancel)
            {
                buttonConfirm.setEnabled(true);
            panelRoomBilTotal.setVisible(false);
            }

        }
    };

    ItemListener comboboxYearItemListener = new ItemListener() 
    {
        public void itemStateChanged(ItemEvent e) 
        {
            if (e.getStateChange() == ItemEvent.SELECTED)
            {
                if (e.getSource() == yearFComboBox)
                {
                    int selectedIndex = yearFComboBox.getSelectedIndex();
                    yearTComboBox.setSelectedIndex(selectedIndex);
                }
                else
                {
                    int selectedIndex = yearTComboBox.getSelectedIndex();
                    yearFComboBox.setSelectedIndex(selectedIndex);
                }
                
            }
        }
    };

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
                panelRoomBilTotal.add(panelRoom, BorderLayout.CENTER);
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
            panelRoom.setLayout(new BoxLayout(panelRoom, BoxLayout.Y_AXIS));            
            panel1.revalidate();
            panel1.repaint();
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
                if(SingleRoom + FamilyRoom > roomBil){
                    JOptionPane.showMessageDialog(null, "The total rooms is more than you have choosed", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    FamilyRTextField.setText(Integer.toString(FamilyRoom));
                }
            }}
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
                if(SingleRoom + FamilyRoom > roomBil){
                    JOptionPane.showMessageDialog(null, "The total rooms is more than you have choosed", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    SingleRTextField.setText(Integer.toString(SingleRoom));
                }}
            }
            panel1.revalidate();
            panel1.repaint();
        }
    };

    ActionListener buttonRoomActionListener = new ActionListener()
    {
        
        public void actionPerformed(ActionEvent e)
        {
            
           
            if(SingleRoom+FamilyRoom > roomBil){
                JOptionPane.showMessageDialog(null, "The room is more than you have choosed", "Warning", JOptionPane.WARNING_MESSAGE);
            
            }
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
                if (e.getSource() == buttonConfirmRoom) {
                    roomBilTextField.setEditable(false);
                    SingleRTextField.setEditable(false);
                    FamilyRTextField.setEditable(false);
                    buttonCancelRoom.setEnabled(true);

                    // Get the parent panel and create new CustomerPage with data
                    JPanel parent = (JPanel) CustomerPage1.this.getParent();
                    CardLayout layout = (CardLayout) parent.getLayout();
                    
                    // Remove existing CustomerPage if it exists
                    for (Component comp : parent.getComponents()) {
                        if (comp instanceof CustomerPage) {
                            parent.remove(comp);
                            break;
                        }
                    }
                    
                    // Create new CustomerPage with the data
                    CustomerPage customerPage = new CustomerPage(
                        e2 -> layout.show(parent, "CustomerPage1"),
                        CheckInDate,
                        CheckOutDate,
                        roomBil,
                        SingleRoom,
                        FamilyRoom
                    );
                    
                    // Add the new CustomerPage and show it
                    parent.add(customerPage, "Customer");
                    layout.show(parent, "Customer");
                    parent.revalidate();
                    parent.repaint();
                }
                else
                {
                    roomBilTextField.setEditable(true);
                    SingleRTextField.setEditable(true);
                    FamilyRTextField.setEditable(true);

                    // panelChooseLoop.setVisible(false);
                    // counterLoop = 0;
                }
            }            
            panel1.revalidate();
            panel1.repaint();
            
        }
    };
}
