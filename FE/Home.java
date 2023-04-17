package Hotel_Manager_App.FE;
import java.awt.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.*;

public class Home {
    private JFrame frame;
    //private JTable table;
    //private DefaultTableModel model;

    public Home() {
        createHomeUI();
    }
    private void createHomeUI() {
        frame = new JFrame("Hotel Manager - Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel NORTHpanel = new JPanel(new BorderLayout());
        NORTHpanel.setPreferredSize(new Dimension(1024, 100));
        NORTHpanel.setBackground(Color.LIGHT_GRAY);
        frame.add(NORTHpanel, BorderLayout.NORTH);

        JPanel top_NORTHpanel = new JPanel(new GridLayout(1, 2));
        top_NORTHpanel.setPreferredSize(new Dimension(1024, 30));
        top_NORTHpanel.setBackground(Color.LIGHT_GRAY);
        
        top_NORTHpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JLabel dateLabel = new JLabel();
        dateLabel.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        dateLabel.setHorizontalAlignment(JLabel.LEFT);

        JPanel top_NORTHpanel_Right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        top_NORTHpanel_Right.setBackground(Color.LIGHT_GRAY);

        JLabel userNameLabel = new JLabel("Hi, Admin");
        userNameLabel.setHorizontalAlignment(JLabel.RIGHT);
        userNameLabel.setVerticalAlignment(JLabel.CENTER);
        top_NORTHpanel_Right.add(userNameLabel);

        ImageIcon logOutButton_icon = new ImageIcon("D:/VS Code/.vscode/Hotel_Manager_App/FE/Image/logOutButton/logOut_icon.png");
        JButton logOutButton = new JButton("LogOut", logOutButton_icon);
        logOutButton.setPreferredSize(new Dimension(102, 20));
        logOutButton.setContentAreaFilled(false);
        logOutButton.setFocusPainted(false);
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đăng xuất?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    // Đăng xuất tại đây
                    LoginUI loginUI = new LoginUI();
                    frame.setVisible(false);
                    loginUI.refresh();
                }
            }
        });

        top_NORTHpanel_Right.add(logOutButton);


        top_NORTHpanel.add(dateLabel);
        top_NORTHpanel.add(top_NORTHpanel_Right);
        NORTHpanel.add(top_NORTHpanel, BorderLayout.NORTH);

        JPanel bot_NORTHpanel = new JPanel();
        bot_NORTHpanel.setPreferredSize(new Dimension(1024, 70));
        bot_NORTHpanel.setBackground(Color.LIGHT_GRAY);
        bot_NORTHpanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK),
            new EmptyBorder(10, 10, 10, 10)
        ));
        bot_NORTHpanel.setLayout(new GridLayout(0, 7));
        ImageIcon bookButton_icon = new ImageIcon("D:/VS Code/.vscode/Hotel_Manager_App/FE/Image/bookButton/book_icon.png");
        JButton bookButton = new JButton("Book",bookButton_icon);
        //bookButton.setBorderPainted(false);
        bookButton.setContentAreaFilled(false);
        bookButton.setFocusPainted(false);

        ImageIcon editButton_icon = new ImageIcon("D:/VS Code/.vscode/Hotel_Manager_App/FE/Image/editButton/edit_icon.png");
        JButton ediButton = new JButton("Edit",editButton_icon);
        ediButton.setContentAreaFilled(false);
        ediButton.setFocusPainted(false);

        ImageIcon checkoutButton_icon = new ImageIcon("D:/VS Code/.vscode/Hotel_Manager_App/FE/Image/checkoutButton/checkout_icon.png");
        JButton checkoutButton = new JButton("Checkout",checkoutButton_icon);
        checkoutButton.setContentAreaFilled(false);
        checkoutButton.setFocusPainted(false);

        ImageIcon searchButton_icon = new ImageIcon("D:/VS Code/.vscode/Hotel_Manager_App/FE/Image/searchButton/search_icon.png");
        JButton searchButton = new JButton("Search",searchButton_icon);
        searchButton.setContentAreaFilled(false);
        searchButton.setFocusPainted(false);

        ImageIcon propertyButton_icon = new ImageIcon("D:/VS Code/.vscode/Hotel_Manager_App/FE/Image/propertyButton/property_icon.png");
        JButton propertybButton = new JButton("Property",propertyButton_icon);
        propertybButton.setContentAreaFilled(false);
        propertybButton.setFocusPainted(false);

        ImageIcon logButton_icon = new ImageIcon("D:/VS Code/.vscode/Hotel_Manager_App/FE/Image/logButton/log_icon.png");
        JButton logButton = new JButton("Log",logButton_icon);
        logButton.setContentAreaFilled(false);
        logButton.setFocusPainted(false);
        
        bot_NORTHpanel.add(bookButton);
        bot_NORTHpanel.add(ediButton);
        bot_NORTHpanel.add(checkoutButton);
        bot_NORTHpanel.add(searchButton);
        bot_NORTHpanel.add(new JLabel());
        bot_NORTHpanel.add(propertybButton);
        bot_NORTHpanel.add(logButton);

        NORTHpanel.add(bot_NORTHpanel, BorderLayout.SOUTH);

        frame.setSize(new Dimension(1024, 768));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    public void refresh() {
        //model.setRowCount(0);
        //HotelManagementSystem.getRooms().forEach(room -> {
        //    model.addRow(new Object[]{room.getRoomNumber(), room.getRoomType(), room.getPrice()});
        //});
    }
}
