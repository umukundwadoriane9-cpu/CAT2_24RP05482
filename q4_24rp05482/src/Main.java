import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Create an instance of MultiplicationTable
        MultiplicationTable tableApp = new MultiplicationTable();

        // Make the frame visible
        tableApp.setVisible(true);

        // Center the window on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = tableApp.getSize();
        int x = (screenSize.width - frameSize.width) / 2;
        int y = (screenSize.height - frameSize.height) / 2;
        tableApp.setLocation(x, y);
    }
}