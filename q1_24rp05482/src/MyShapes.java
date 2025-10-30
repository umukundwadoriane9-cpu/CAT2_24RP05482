import java.awt.*;
import java.awt.event.*;

public class MyShapes extends Frame {

    // Constructor — set up window
    public MyShapes() {
        setTitle("My shapes");
        setSize(300, 300);
        setVisible(true);

        // Close the window when user clicks the X
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // Paint method to draw the shapes
    public void paint(Graphics g) {
        // Face
        g.setColor(Color.ORANGE);
        g.drawOval(70, 70, 150, 150);  // outer circle for the face

        // Eyes
        g.setColor(Color.BLACK);
        g.fillOval(110, 120, 15, 15);  // left eye
        g.fillOval(170, 120, 15, 15);  // right eye

        // Smile
        g.setColor(Color.BLACK);
        g.drawArc(110, 130, 80, 80, 180, 180);  // smile arc
    }

    public static void main(String[] args) {
        new MyShapes();
    }
}

