import java.awt.*;
import java.awt.event.*;

public class MultiplicationTable extends Frame implements ActionListener {
    private TextField inputField;
    private TextArea tableArea;
    private Button displayButton;

    public MultiplicationTable() {
        // Set frame properties
        setTitle("AWT Practice");
        setSize(400, 300);
        setLayout(null); // Use absolute positioning to mimic the layout

        // Create components
        Label inputLabel = new Label("5"); // Example input, but we'll use a text field for user input
        inputField = new TextField(10);
        displayButton = new Button("DISPLAY");
        tableArea = new TextArea("", 10, 30, TextArea.SCROLLBARS_NONE);
        tableArea.setEditable(false);
        tableArea.setBackground(new Color(255, 165, 0)); // Orange background for the table area

        // Set bounds to approximate the image layout
        inputLabel.setBounds(50, 50, 20, 30);
        inputField.setBounds(80, 50, 100, 30);
        displayButton.setBounds(190, 50, 80, 30);
        tableArea.setBounds(50, 100, 300, 180);

        // Add action listener to the button
        displayButton.addActionListener(this);

        // Add components to the frame
        add(inputLabel);
        add(inputField);
        add(displayButton);
        add(tableArea);

        // Add window close listener
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Initially display table for 5 as in the image
        displayTable(5);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == displayButton) {
            try {
                int number = Integer.parseInt(inputField.getText());
                displayTable(number);
            } catch (NumberFormatException ex) {
                tableArea.setText("Please enter a valid integer!");
            }
        }
    }

    private void displayTable(int number) {
        StringBuilder table = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            table.append(number).append(" * ").append(i).append(" = ").append(number * i).append("\n");
        }
        tableArea.setText(table.toString());
    }

    public static void main(String[] args) {
        MultiplicationTable app = new MultiplicationTable();
        app.setVisible(true);
    }
}