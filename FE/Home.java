package Hotel_Manager_App.FE;
import java.awt.*;
//import java.awt.event.*;
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
        
        JPanel panel = new JPanel(new GridBagLayout());
        //GridBagConstraints constraints = new GridBagConstraints();
        
        // JButton addButton_Book_Room = new JButton("Đặt phòng");
        // constraints.gridx = 0;
        // constraints.gridy = 3;
        // addButton_Book_Room.setPreferredSize(new Dimension(200, 30));
        // panel.add(addButton_Book_Room, constraints);



        // JButton addButton_History = new JButton("Lịch sử giao dịch");
        // constraints.gridx = 0;
        // constraints.gridy = 4;
        // addButton_History.setPreferredSize(new Dimension(200, 30));
        // panel.add(addButton_History, constraints);
        
        
        //JScrollPane scrollPane = new JScrollPane(table);

        frame.add(panel, BorderLayout.CENTER);
        //frame.add(scrollPane, BorderLayout.CENTER);

        frame.setMinimumSize(new Dimension(400, 300));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void refresh() {
        //model.setRowCount(0);
        //HotelManagementSystem.getRooms().forEach(room -> {
        //    model.addRow(new Object[]{room.getRoomNumber(), room.getRoomType(), room.getPrice()});
        //});
    }
}
