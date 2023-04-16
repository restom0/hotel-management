package Hotel_Manager_App.FE;
import javax.swing.SwingUtilities;
public class HotelManagementSystemUI {

    private static LoginUI loginUI = new LoginUI();
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //roomUI.refresh();
                //customerUI.refresh();
                loginUI.refresh();
            }
        });
    }
}
