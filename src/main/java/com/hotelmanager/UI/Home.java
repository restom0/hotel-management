package com.hotelmanager.UI;

import java.awt.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import com.hotelmanager.data.*;

public class Home {
    private JFrame frame;
    //private JTable table;
    //private DefaultTableModel model;
    private Database Tuan;
    public Home() {
        Tuan = new Database(null, null, null, null);
        createHomeUI();
    }
    private void createHomeUI() {
        frame = new JFrame("Hotel Manager - Home");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel contentPanel = new JPanel(new BorderLayout());
        
        JPanel NORTHpanel = new JPanel(new BorderLayout());
        NORTHpanel.setPreferredSize(new Dimension(1024, 100));
        NORTHpanel.setBackground(Color.LIGHT_GRAY);
        contentPanel.add(NORTHpanel, BorderLayout.NORTH);

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

        ImageIcon logOutButton_icon = new ImageIcon("Hotel_Manager_App/FE/Image/logOutButton/logOut_icon.png");
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
        ImageIcon bookButton_icon = new ImageIcon("Hotel_Manager_App/FE/Image/bookButton/book_icon.png");
        JButton bookButton = new JButton("Book",bookButton_icon);

        bookButton.setContentAreaFilled(false);
        bookButton.setFocusPainted(false);

        ImageIcon editButton_icon = new ImageIcon("Hotel_Manager_App/FE/Image/editButton/edit_icon.png");
        JButton ediButton = new JButton("Edit",editButton_icon);
        ediButton.setContentAreaFilled(false);
        ediButton.setFocusPainted(false);

        ImageIcon checkoutButton_icon = new ImageIcon("Hotel_Manager_App/FE/Image/checkoutButton/checkout_icon.png");
        JButton checkoutButton = new JButton("Checkout",checkoutButton_icon);
        checkoutButton.setContentAreaFilled(false);
        checkoutButton.setFocusPainted(false);

        ImageIcon searchButton_icon = new ImageIcon("Hotel_Manager_App/FE/Image/searchButton/search_icon.png");
        JButton searchButton = new JButton("Search",searchButton_icon);
        searchButton.setContentAreaFilled(false);
        searchButton.setFocusPainted(false);

        ImageIcon propertyButton_icon = new ImageIcon("Hotel_Manager_App/FE/Image/propertyButton/property_icon.png");
        JButton propertybButton = new JButton("Property",propertyButton_icon);
        propertybButton.setContentAreaFilled(false);
        propertybButton.setFocusPainted(false);

        ImageIcon logButton_icon = new ImageIcon("Hotel_Manager_App/FE/Image/logButton/log_icon.png");
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

        final JPanel SOUTHpanel = new JPanel(new BorderLayout());
        contentPanel.add(SOUTHpanel, BorderLayout.CENTER);
        
        frame.add(contentPanel, BorderLayout.CENTER);

        ActionListener bookButtonActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                contentPanel.remove(SOUTHpanel);
                SOUTHpanel.removeAll();

                JPanel bookJPanel_Footer = new JPanel(new GridLayout(1, 2));

                JPanel bookJPanel_Footer_Left = new JPanel (new FlowLayout(FlowLayout.LEFT));
                JButton cancelBookPanelButton = new JButton("Cancel");

                bookJPanel_Footer_Left.add(cancelBookPanelButton);
                bookJPanel_Footer.add(bookJPanel_Footer_Left);

                JButton finishBookPanelButton = new JButton("Finish");
                JPanel bookJPanel_Footer_Right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                bookJPanel_Footer_Right.add(finishBookPanelButton);
                bookJPanel_Footer.add(bookJPanel_Footer_Right);


                JPanel bookPanel_left = new JPanel(new BorderLayout());

                JPanel bookPanel_left_top = new JPanel(new GridBagLayout());
                GridBagConstraints constraints = new GridBagConstraints();

                constraints.gridx = 0;
                constraints.gridy = 0;
                bookPanel_left_top.add(new Label(), constraints);

                constraints.gridx = 0;
                constraints.gridy = 1;
                constraints.fill = GridBagConstraints.HORIZONTAL;
                JLabel customerInfoLabel = new JLabel("Customer Information");
                customerInfoLabel.setFont(new Font("Arial", Font.BOLD, 16));
                bookPanel_left_top.add(customerInfoLabel, constraints);

                constraints.gridx = 0;
                constraints.gridy = 2;
                constraints.insets = new Insets(15, 0, 0, 0);
                bookPanel_left_top.add(new JLabel("Name"), constraints);

                JTextField customerNameField = new JTextField(20);
                constraints.gridx = 1;
                constraints.gridy = 2;
                bookPanel_left_top.add(customerNameField, constraints);

                constraints.gridx = 0;
                constraints.gridy = 3;
                bookPanel_left_top.add(new JLabel("Phone Number"), constraints);

                JTextField phoneNumberField = new JTextField(20);
                constraints.gridx = 1;
                constraints.gridy = 3;
                bookPanel_left_top.add(phoneNumberField, constraints);

                constraints.gridx = 0;
                constraints.gridy = 4;
                bookPanel_left_top.add(new JLabel("ID"), constraints);

                JTextField IDField = new JTextField(20);
                constraints.gridx = 1;
                constraints.gridy = 4;
                bookPanel_left_top.add(IDField, constraints);

                constraints.gridx = 0;
                constraints.gridy = 5;
                bookPanel_left_top.add(new JLabel("Room"), constraints);

                JTextField roomField = new JTextField(20);
                constraints.gridx = 1;
                constraints.gridy = 5;
                bookPanel_left_top.add(roomField, constraints);

                constraints.gridx = 0;
                constraints.gridy = 6;
                bookPanel_left_top.add(new JLabel("Extras"), constraints);

                JButton addMoreButton = new JButton("Add..");
                addMoreButton.setBorderPainted(false);
                addMoreButton.setContentAreaFilled(false);
                addMoreButton.setFocusPainted(false);
                addMoreButton.setOpaque(false);
                addMoreButton.setFont(addMoreButton.getFont().deriveFont(Font.PLAIN));
                addMoreButton.setForeground(Color.BLUE);
                addMoreButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                addMoreButton.setHorizontalTextPosition(SwingConstants.CENTER);
                addMoreButton.setVerticalTextPosition(SwingConstants.BOTTOM);
                
                addMoreButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JDialog subFrame_addMore = new JDialog(frame, "Add", true);
                        subFrame_addMore.setSize(300, 300);
                        subFrame_addMore.setLocationRelativeTo(null);

                        JPanel contentPanel_addMore = new JPanel(new BorderLayout());
                        
                        JPanel contentPanel_addMore_Main = new JPanel(new GridLayout(0,2));
                        GridBagConstraints constraints = new GridBagConstraints();

                        constraints.gridx = 0;
                        constraints.gridy = 0;
                        constraints.fill = GridBagConstraints.HORIZONTAL;
                        JLabel Type_addMore = new JLabel("Type:");
                        contentPanel_addMore_Main.add(Type_addMore, constraints);

                        constraints.gridx = 0;
                        constraints.gridy = 1;
                        String[] options_Type_addMore = {"Option 1", "Option 2", "Option 3"};
                        JComboBox<String> dropdown_Type_addMore = new JComboBox<>(options_Type_addMore);

                        contentPanel_addMore_Main.add(dropdown_Type_addMore, constraints);

                        constraints.gridx = 0;
                        constraints.gridy = 2;
                        contentPanel_addMore_Main.add(new Label(), constraints);
                        constraints.gridx = 0;
                        constraints.gridy = 3;
                        contentPanel_addMore_Main.add(new Label(), constraints);

                        constraints.gridx = 0;
                        constraints.gridy = 4;
                        JLabel quantity_addMore = new JLabel("Quantity:");
                        contentPanel_addMore_Main.add(quantity_addMore, constraints);

                        constraints.gridx = 1;
                        constraints.gridy = 4;
                        JTextField quantity_addMoreField = new JTextField(10);
                        contentPanel_addMore_Main.add(quantity_addMoreField, constraints);

                        JPanel contentPanel_addMore_Footer = new JPanel(new GridLayout(1, 2));
                        contentPanel_addMore_Footer.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));


                        JPanel contentPanel_addMore_Footer_Left = new JPanel (new FlowLayout(FlowLayout.LEFT));
                        
                        JButton cancel_contentPanel_addMoreButton = new JButton("Cancel");
                        contentPanel_addMore_Footer_Left.add(cancel_contentPanel_addMoreButton);
                        contentPanel_addMore_Footer.add(contentPanel_addMore_Footer_Left);

                        cancel_contentPanel_addMoreButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                subFrame_addMore.setVisible(false);
                            }
                        });

                        JButton finish_contentPanel_addMoreButton = new JButton("Finish");
                        finish_contentPanel_addMoreButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //Cập nhật dữ liệu tại đây
                                JOptionPane.showMessageDialog(frame, "??? added successfully!");
                                subFrame_addMore.setVisible(false);
                            }
                        });

                        JPanel contentPanel_addMore_Footer_Right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                        contentPanel_addMore_Footer_Right.add(finish_contentPanel_addMoreButton);
                        contentPanel_addMore_Footer.add(contentPanel_addMore_Footer_Right);

                        contentPanel_addMore.add(contentPanel_addMore_Main,BorderLayout.NORTH);
                        contentPanel_addMore.add(contentPanel_addMore_Footer, BorderLayout.SOUTH);

                        subFrame_addMore.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        subFrame_addMore.getContentPane().add(contentPanel_addMore);
                        subFrame_addMore.setVisible(true);
                    }
                }
                );
                
                JPanel addMorePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                constraints.gridx = 1;
                constraints.gridy = 6;
                addMorePanel.add(addMoreButton);
                bookPanel_left_top.add(addMorePanel, constraints);

                Object[] columnNames_dataExtras = {"Type", "Name", "Price"};
                Object[][] dataExtras = {
                        {"Single", "101", "200 000"},
                        {"Double", "221", "300 000"},
                        {"Single", "217", "150 000"},
                        {"Single", "602", "180 000"},
                        {"Double", "779", "350 000"}
                };

                DefaultTableModel model_dataExtras = new DefaultTableModel(dataExtras, columnNames_dataExtras);
                JTable table_dataExtras = new JTable(model_dataExtras);
                table_dataExtras.setEnabled(false);

                JScrollPane bookPanel_left_bot = new JScrollPane(table_dataExtras);
                bookPanel_left_bot.setBackground(Color.LIGHT_GRAY);
                table_dataExtras.setFillsViewportHeight(false);
                
                bookPanel_left.add(bookPanel_left_top,BorderLayout.NORTH);
                bookPanel_left.add(bookPanel_left_bot,BorderLayout.CENTER);
                //Create bookPanel_right
                Object[] columnNames_dataRoomAlb = {"Type", "Name", "Price"};
                Object[][] dataRoomAlb = {
                        {"Single", "101", "200 000"},
                        {"Double", "221", "300 000"},
                        {"Single", "217", "150 000"},
                        {"Single", "602", "180 000"},
                        {"Double", "779", "350 000"}
                };

                DefaultTableModel model_dataRoomAlb = new DefaultTableModel(dataRoomAlb, columnNames_dataRoomAlb);
                JTable table_dataRoomAlb = new JTable(model_dataRoomAlb);
                table_dataRoomAlb.setEnabled(false);

                JScrollPane bookPanel_right = new JScrollPane(table_dataRoomAlb);
                table_dataRoomAlb.setFillsViewportHeight(true);
                
                JSplitPane bookPanel_Main = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, bookPanel_left, bookPanel_right);
                bookPanel_Main.setOneTouchExpandable(true);
                bookPanel_Main.setDividerLocation(frame.getWidth() / 2);

                JPanel bookPanel = new JPanel(new BorderLayout());
                bookPanel.add(bookJPanel_Footer,BorderLayout.SOUTH);
                bookPanel.add(bookPanel_Main,BorderLayout.CENTER);

                SOUTHpanel.add(bookPanel,BorderLayout.CENTER);
                contentPanel.add(SOUTHpanel, BorderLayout.CENTER);

                cancelBookPanelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        contentPanel.remove(SOUTHpanel);
                        SOUTHpanel.removeAll();
                        contentPanel.add(SOUTHpanel,BorderLayout.CENTER);
                        
                        contentPanel.revalidate();
                        contentPanel.repaint();
                    }
                });
                finishBookPanelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Lấy dữ liệu ở đây 

                        contentPanel.remove(SOUTHpanel);
                        SOUTHpanel.removeAll();
                        contentPanel.add(SOUTHpanel,BorderLayout.CENTER);
                        
                        JOptionPane.showMessageDialog(frame, "Customer added successfully!");
                        contentPanel.revalidate();
                        contentPanel.repaint();
                    }
                });

                frame.add(contentPanel,BorderLayout.CENTER);
                frame.revalidate(); // Cập nhật lại giao diện
                frame.repaint();
            }
        };
        bookButton.addActionListener(bookButtonActionListener);
        ediButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                contentPanel.remove(SOUTHpanel);
                SOUTHpanel.removeAll();

                JPanel editPanel = new JPanel(new BorderLayout());
                JPanel NORTHdeitPanel = new JPanel(new BorderLayout());
                JPanel SOUTHeditPanel = new JPanel(new GridLayout(1,2));
                SOUTHeditPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                JPanel SOUTH_left_editPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JPanel SOUTH_right_editPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

                String[] columnsEdit = {"ID", "Customer Name", "Room", "Checkin Date"};
                Object[][] dataEdit = {
                    {1, "John", 25, "11"},
                    {2, "Sarah", 30,"12"},
                    {3, "Tom", 20,"13"}
                };
                DefaultTableModel modelEdit =  new DefaultTableModel(dataEdit, columnsEdit);
                
                JTable tableEdit = new JTable(modelEdit);
                tableEdit.setDefaultEditor(Object.class, null);
                tableEdit.getTableHeader().setReorderingAllowed(false);
                tableEdit.setRowSelectionAllowed(true);
                tableEdit.setColumnSelectionAllowed(false);

                JScrollPane scrollPaneEdit = new JScrollPane(tableEdit);
                scrollPaneEdit.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));


                JButton editEditButton = new JButton("Edit");
                JButton cancelEditButton = new JButton("Cancel");

                NORTHdeitPanel.add(scrollPaneEdit,BorderLayout.NORTH);
                SOUTH_right_editPanel.add(editEditButton);
                SOUTH_left_editPanel.add(cancelEditButton);
                SOUTHeditPanel.add(SOUTH_left_editPanel);
                SOUTHeditPanel.add(SOUTH_right_editPanel);
                editPanel.add(NORTHdeitPanel,BorderLayout.CENTER);
                editPanel.add(SOUTHeditPanel,BorderLayout.SOUTH);
                SOUTHpanel.add(editPanel, BorderLayout.CENTER);
                contentPanel.add(SOUTHpanel,BorderLayout.CENTER);

                cancelEditButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        contentPanel.remove(SOUTHpanel);
                        SOUTHpanel.removeAll();

                        contentPanel.add(SOUTHpanel);
                        contentPanel.revalidate();
                        contentPanel.repaint();

                    }
                });

                editEditButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int rowtableEdit = tableEdit.getSelectedRow();
                        if (rowtableEdit == -1) {
                            JOptionPane.showMessageDialog(null, "Please select 1 item");
                            return;
                        }

                        frame.getContentPane().removeAll();
                        contentPanel.remove(SOUTHpanel);
                        SOUTHpanel.removeAll();

                        JPanel bookJPanel_Footer = new JPanel(new GridLayout(1, 2));
        
                        JPanel bookJPanel_Footer_Left = new JPanel (new FlowLayout(FlowLayout.LEFT));
                        JButton cancelBookPanelButton = new JButton("Back");
        
                        bookJPanel_Footer_Left.add(cancelBookPanelButton);
                        bookJPanel_Footer.add(bookJPanel_Footer_Left);
        
                        JButton finishBookPanelButton = new JButton("Finish");
                        JPanel bookJPanel_Footer_Right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                        bookJPanel_Footer_Right.add(finishBookPanelButton);
                        bookJPanel_Footer.add(bookJPanel_Footer_Right);
        
        
                        JPanel bookPanel_left = new JPanel(new BorderLayout());
        
                        JPanel bookPanel_left_top = new JPanel(new GridBagLayout());
                        GridBagConstraints constraints = new GridBagConstraints();
        
                        constraints.gridx = 0;
                        constraints.gridy = 0;
                        bookPanel_left_top.add(new Label(), constraints);
        
                        constraints.gridx = 0;
                        constraints.gridy = 1;
                        constraints.fill = GridBagConstraints.HORIZONTAL;
                        JLabel customerInfoLabel = new JLabel("Customer Information");
                        customerInfoLabel.setFont(new Font("Arial", Font.BOLD, 16));
                        bookPanel_left_top.add(customerInfoLabel, constraints);
        
                        constraints.gridx = 0;
                        constraints.gridy = 2;
                        constraints.insets = new Insets(15, 0, 0, 0);
                        bookPanel_left_top.add(new JLabel("Name"), constraints);
        
                        JTextField customerNameField = new JTextField(20);
                        customerNameField.setText(modelEdit.getValueAt(rowtableEdit, 1).toString());
                        constraints.gridx = 1;
                        constraints.gridy = 2;
                        bookPanel_left_top.add(customerNameField, constraints);
        
                        constraints.gridx = 0;
                        constraints.gridy = 3;
                        bookPanel_left_top.add(new JLabel("Phone Number"), constraints);

        
                        JTextField phoneNumberField = new JTextField(20);
                        //Phần lấy số đth từ BE
                        phoneNumberField.setText("Số điện thoại");
                        constraints.gridx = 1;
                        constraints.gridy = 3;
                        bookPanel_left_top.add(phoneNumberField, constraints);
        
                        constraints.gridx = 0;
                        constraints.gridy = 4;
                        bookPanel_left_top.add(new JLabel("ID"), constraints);
        
                        JTextField IDField = new JTextField(20);
                        IDField.setText(modelEdit.getValueAt(rowtableEdit, 0).toString());
                        constraints.gridx = 1;
                        constraints.gridy = 4;
                        bookPanel_left_top.add(IDField, constraints);
        
                        constraints.gridx = 0;
                        constraints.gridy = 5;
                        bookPanel_left_top.add(new JLabel("Room"), constraints);
        
                        JTextField roomField = new JTextField(20);
                        roomField.setText(modelEdit.getValueAt(rowtableEdit, 2).toString());
                        constraints.gridx = 1;
                        constraints.gridy = 5;
                        bookPanel_left_top.add(roomField, constraints);
        
                        constraints.gridx = 0;
                        constraints.gridy = 6;
                        bookPanel_left_top.add(new JLabel("Extras"), constraints);
        
                        JButton addMoreButton = new JButton("Add..");
                        addMoreButton.setBorderPainted(false);
                        addMoreButton.setContentAreaFilled(false);
                        addMoreButton.setFocusPainted(false);
                        addMoreButton.setOpaque(false);
                        addMoreButton.setFont(addMoreButton.getFont().deriveFont(Font.PLAIN));
                        addMoreButton.setForeground(Color.BLUE);
                        addMoreButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        addMoreButton.setHorizontalTextPosition(SwingConstants.CENTER);
                        addMoreButton.setVerticalTextPosition(SwingConstants.BOTTOM);
                        
                        addMoreButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JDialog subFrame_addMore = new JDialog(frame, "Add", true);
                                subFrame_addMore.setSize(300, 300);
                                subFrame_addMore.setLocationRelativeTo(null);
        
                                JPanel contentPanel_addMore = new JPanel(new BorderLayout());
                                
                                JPanel contentPanel_addMore_Main = new JPanel(new GridLayout(0,2));
                                GridBagConstraints constraints = new GridBagConstraints();
        
                                constraints.gridx = 0;
                                constraints.gridy = 0;
                                constraints.fill = GridBagConstraints.HORIZONTAL;
                                JLabel Type_addMore = new JLabel("Type:");
                                contentPanel_addMore_Main.add(Type_addMore, constraints);
        
                                constraints.gridx = 0;
                                constraints.gridy = 1;
                                String[] options_Type_addMore = {"Option 1", "Option 2", "Option 3"};
                                JComboBox<String> dropdown_Type_addMore = new JComboBox<>(options_Type_addMore);
        
                                contentPanel_addMore_Main.add(dropdown_Type_addMore, constraints);
        
                                constraints.gridx = 0;
                                constraints.gridy = 2;
                                contentPanel_addMore_Main.add(new Label(), constraints);
                                constraints.gridx = 0;
                                constraints.gridy = 3;
                                contentPanel_addMore_Main.add(new Label(), constraints);
        
                                constraints.gridx = 0;
                                constraints.gridy = 4;
                                JLabel quantity_addMore = new JLabel("Quantity:");
                                contentPanel_addMore_Main.add(quantity_addMore, constraints);
        
                                constraints.gridx = 1;
                                constraints.gridy = 4;
                                JTextField quantity_addMoreField = new JTextField(10);
                                contentPanel_addMore_Main.add(quantity_addMoreField, constraints);
        
                                JPanel contentPanel_addMore_Footer = new JPanel(new GridLayout(1, 2));
                                contentPanel_addMore_Footer.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
        
        
                                JPanel contentPanel_addMore_Footer_Left = new JPanel (new FlowLayout(FlowLayout.LEFT));
                                
                                JButton cancel_contentPanel_addMoreButton = new JButton("Cancel");
                                contentPanel_addMore_Footer_Left.add(cancel_contentPanel_addMoreButton);
                                contentPanel_addMore_Footer.add(contentPanel_addMore_Footer_Left);
        
                                cancel_contentPanel_addMoreButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        subFrame_addMore.setVisible(false);
                                    }
                                });
        
                                JButton finish_contentPanel_addMoreButton = new JButton("Finish");
                                finish_contentPanel_addMoreButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        //Cập nhật dữ liệu tại đây
                                        JOptionPane.showMessageDialog(frame, "??? added successfully!");
                                        subFrame_addMore.setVisible(false);
                                    }
                                });
        
                                JPanel contentPanel_addMore_Footer_Right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                                contentPanel_addMore_Footer_Right.add(finish_contentPanel_addMoreButton);
                                contentPanel_addMore_Footer.add(contentPanel_addMore_Footer_Right);
        
                                contentPanel_addMore.add(contentPanel_addMore_Main,BorderLayout.NORTH);
                                contentPanel_addMore.add(contentPanel_addMore_Footer, BorderLayout.SOUTH);
        
                                subFrame_addMore.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                subFrame_addMore.getContentPane().add(contentPanel_addMore);
                                subFrame_addMore.setVisible(true);
                            }
                        }
                        );
                        
                        JPanel addMorePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                        constraints.gridx = 1;
                        constraints.gridy = 6;
                        addMorePanel.add(addMoreButton);
                        bookPanel_left_top.add(addMorePanel, constraints);
        
                        Object[] columnNames_dataExtras = {"Type", "Name", "Price"};
                        Object[][] dataExtras = {
                                {"Single", "101", "200 000"},
                                {"Double", "221", "300 000"},
                                {"Single", "217", "150 000"},
                                {"Single", "602", "180 000"},
                                {"Double", "779", "350 000"}
                        };
        
                        DefaultTableModel model_dataExtras = new DefaultTableModel(dataExtras, columnNames_dataExtras);
                        JTable table_dataExtras = new JTable(model_dataExtras);
                        table_dataExtras.setEnabled(false);
        
                        JScrollPane bookPanel_left_bot = new JScrollPane(table_dataExtras);
                        bookPanel_left_bot.setBackground(Color.LIGHT_GRAY);
                        table_dataExtras.setFillsViewportHeight(false);
                        
                        bookPanel_left.add(bookPanel_left_top,BorderLayout.NORTH);
                        bookPanel_left.add(bookPanel_left_bot,BorderLayout.CENTER);
                        //Create bookPanel_right
                        Object[] columnNames_dataRoomAlb = {"Type", "Name", "Price"};
                        Object[][] dataRoomAlb = {
                                {"Single", "101", "200 000"},
                                {"Double", "221", "300 000"},
                                {"Single", "217", "150 000"},
                                {"Single", "602", "180 000"},
                                {"Double", "779", "350 000"}
                        };
        
                        DefaultTableModel model_dataRoomAlb = new DefaultTableModel(dataRoomAlb, columnNames_dataRoomAlb);
                        JTable table_dataRoomAlb = new JTable(model_dataRoomAlb);
                        table_dataRoomAlb.setEnabled(false);
        
                        JScrollPane bookPanel_right = new JScrollPane(table_dataRoomAlb);
                        table_dataRoomAlb.setFillsViewportHeight(true);
                        
                        JSplitPane bookPanel_Main = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, bookPanel_left, bookPanel_right);
                        bookPanel_Main.setOneTouchExpandable(true);
                        bookPanel_Main.setDividerLocation(frame.getWidth() / 2);
        
                        JPanel bookPanel = new JPanel(new BorderLayout());
                        bookPanel.add(bookJPanel_Footer,BorderLayout.SOUTH);
                        bookPanel.add(bookPanel_Main,BorderLayout.CENTER);
        
                        SOUTHpanel.add(bookPanel,BorderLayout.CENTER);
                        contentPanel.add(SOUTHpanel, BorderLayout.CENTER);
        
                        //final JPanel SOUTHpanelCopy = SOUTHpanel;
        
                        cancelBookPanelButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                contentPanel.remove(SOUTHpanel);
                                SOUTHpanel.removeAll();
                                SOUTHpanel.add(editPanel);

                                contentPanel.add(SOUTHpanel,BorderLayout.CENTER);
                                
                                contentPanel.revalidate();
                                contentPanel.repaint();
                            }
                        });
                        finishBookPanelButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Lấy dữ liệu ở đây 
                                JOptionPane.showMessageDialog(frame, "Customer edit successfully!");
                                contentPanel.remove(SOUTHpanel);
                                SOUTHpanel.removeAll();
                                SOUTHpanel.add(editPanel);
                                contentPanel.add(SOUTHpanel,BorderLayout.CENTER);
                                
                                contentPanel.revalidate();
                                contentPanel.repaint();
                            }
                        });
        
                        frame.add(contentPanel,BorderLayout.CENTER);
                        frame.revalidate(); // Cập nhật lại giao diện
                        frame.repaint();
                    }
                });

                frame.add(contentPanel,BorderLayout.CENTER);
                frame.revalidate(); // Cập nhật lại giao diện
                frame.repaint();
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                contentPanel.remove(SOUTHpanel);
                SOUTHpanel.removeAll();

                JPanel searchPanel = new JPanel(new BorderLayout());
                JPanel searchJPanel_Footer = new JPanel(new FlowLayout(FlowLayout.LEFT));
                searchJPanel_Footer.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));

                JPanel searchPanel_Top = new JPanel(new FlowLayout());
                JPanel searchPanel_Main = new JPanel(new BorderLayout());
                
                JButton cancelSearchButton = new JButton("Cancel");
                searchJPanel_Footer.add(cancelSearchButton);
                

                JLabel searchJLabel = new JLabel("Search:");
                JTextField searchField = new JTextField(20);
                String[] options_Type_search = {"Option 1", "Option 2", "Option 3"};
                JComboBox<String> dropdown_Type_search = new JComboBox<>(options_Type_search);
                searchField.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String query = searchField.getText();
                        
                    }
                });
            
                searchPanel_Top.add(searchJLabel);
                searchPanel_Top.add(searchField);
                searchPanel_Top.add(dropdown_Type_search);

                searchPanel.add(searchJPanel_Footer, BorderLayout.SOUTH);
                searchPanel.add(searchPanel_Main, BorderLayout.CENTER);
                searchPanel.add(searchPanel_Top, BorderLayout.NORTH);

                SOUTHpanel.add(searchPanel,BorderLayout.CENTER);
                contentPanel.add(SOUTHpanel,BorderLayout.CENTER);
                //JScrollPane scrollPaneSearch = new JScrollPane();
                //scrollPaneEdit.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

                contentPanel.revalidate();
                contentPanel.repaint();
                frame.add(contentPanel,BorderLayout.CENTER);
                frame.revalidate(); // Cập nhật lại giao diện
                frame.repaint();
            }
        });
        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                contentPanel.remove(SOUTHpanel);
                SOUTHpanel.removeAll();

                JPanel logPanel = new JPanel(new BorderLayout());
                JPanel NORTHlogPanel = new JPanel(new BorderLayout());
                JPanel SOUTHlogPanel = new JPanel(new GridLayout(1,2));
                SOUTHlogPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                JPanel SOUTH_left_logPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JPanel SOUTH_right_logPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

                String[] columnslog = {"ID", "Customer Name", "Room", "Checkin Date"};
                Object[][] datalog = {
                    {1, "John", 25, "11"},
                    {2, "Sarah", 30,"12"},
                    {3, "Tom", 20,"13"}
                };
                DefaultTableModel modellog =  new DefaultTableModel(datalog, columnslog);
                
                JTable tablelog = new JTable(modellog);
                tablelog.setDefaultEditor(Object.class, null);
                tablelog.getTableHeader().setReorderingAllowed(false);
                tablelog.setRowSelectionAllowed(true);
                tablelog.setColumnSelectionAllowed(false);

                JScrollPane scrollPanelog = new JScrollPane(tablelog);
                scrollPanelog.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));


                JButton cancellogButton = new JButton("Cancel");

                NORTHlogPanel.add(scrollPanelog,BorderLayout.NORTH);
                SOUTH_left_logPanel.add(cancellogButton);
                SOUTHlogPanel.add(SOUTH_left_logPanel);
                SOUTHlogPanel.add(SOUTH_right_logPanel);
                logPanel.add(NORTHlogPanel,BorderLayout.CENTER);
                logPanel.add(SOUTHlogPanel,BorderLayout.SOUTH);
                SOUTHpanel.add(logPanel, BorderLayout.CENTER);
                contentPanel.add(SOUTHpanel,BorderLayout.CENTER);

                cancellogButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        contentPanel.remove(SOUTHpanel);
                        SOUTHpanel.removeAll();

                        contentPanel.add(SOUTHpanel);
                        contentPanel.revalidate();
                        contentPanel.repaint();

                    }
                });

                frame.add(contentPanel,BorderLayout.CENTER);
                frame.revalidate(); // Cập nhật lại giao diện
                frame.repaint();
            }
        });
        showFrame();
    }

    public void setHome (JFrame temp) {
        frame = temp;
    }

    public JFrame getHome() {
        return frame;
    }

    public void showFrame() {
        if (frame != null) {
            frame.setSize(new Dimension(1024, 768));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setResizable(false);
        }
    }

    public void refresh() {
        //model.setRowCount(0);
        //HotelManagementSystem.getRooms().forEach(room -> {
        //    model.addRow(new Object[]{room.getRoomNumber(), room.getRoomType(), room.getPrice()});
        //});
    }
}
