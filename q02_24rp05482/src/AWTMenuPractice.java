import java.awt.*;
import java.awt.event.*;

public class AWTMenuPractice extends Frame implements ActionListener {

    // Declare AWT components
    CardLayout card;
    Panel mainPanel, loginPanel, studentPanel;
    MenuBar menuBar;
    Menu pagesMenu, editMenu, helpMenu;
    MenuItem loginItem, studentItem;

    public AWTMenuPractice() {
        // Frame setup
        setTitle("AWT MENU Practice");
        setSize(500, 400);
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);

        // --- Menu Bar Setup ---
        menuBar = new MenuBar();

        // Create Menus
        pagesMenu = new Menu("Pages");
        editMenu = new Menu("Edit");
        helpMenu = new Menu("Help");

        // Menu Items for "Pages"
        loginItem = new MenuItem("Login");
        studentItem = new MenuItem("Student");

        // Add menu items to "Pages"
        pagesMenu.add(loginItem);
        pagesMenu.add(studentItem);

        // Add all menus to menu bar
        menuBar.add(pagesMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // Add menu bar to frame
        setMenuBar(menuBar);

        // Add Action Listeners
        loginItem.addActionListener(this);
        studentItem.addActionListener(this);

        // --- Card Layout Setup ---
        card = new CardLayout();
        mainPanel = new Panel(card);

        // -------------------- LOGIN PAGE --------------------
        loginPanel = new Panel();
        loginPanel.setLayout(null); // Use absolute positioning
        loginPanel.setBackground(new Color(173, 216, 230)); // Light blue background

        Label loginTitle = new Label("LOGIN PAGE", Label.CENTER);
        loginTitle.setFont(new Font("Arial", Font.BOLD, 18));
        loginTitle.setBounds(150, 40, 200, 30);
        loginPanel.add(loginTitle);

        Label userLabel = new Label("Username:");
        userLabel.setBounds(120, 100, 100, 25);
        loginPanel.add(userLabel);

        TextField userField = new TextField();
        userField.setBounds(220, 100, 150, 25);
        loginPanel.add(userField);

        Label passLabel = new Label("Password:");
        passLabel.setBounds(120, 140, 100, 25);
        loginPanel.add(passLabel);

        TextField passField = new TextField();
        passField.setEchoChar('*');
        passField.setBounds(220, 140, 150, 25);
        loginPanel.add(passField);

        Button loginBtn = new Button("LOGIN");
        loginBtn.setBackground(Color.DARK_GRAY);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setBounds(220, 190, 80, 30);
        loginPanel.add(loginBtn);

        // -------------------- STUDENT PAGE --------------------
        studentPanel = new Panel();
        studentPanel.setLayout(new BorderLayout());
        studentPanel.setBackground(new Color(224, 255, 255)); // Pale cyan

        // Student information
        Label stuTitle = new Label("STUDENT INFORMATION", Label.CENTER);
        stuTitle.setFont(new Font("Arial", Font.BOLD, 20));
        stuTitle.setForeground(Color.BLUE);

        // Create a panel for centered content
        Panel centerPanel = new Panel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(new Color(224, 255, 255));

        // Student details label with your actual information
        Label studentDetails = new Label("UMUKUNDWA DORIANE", Label.CENTER);
        studentDetails.setFont(new Font("Arial", Font.BOLD, 16));
        studentDetails.setForeground(Color.DARK_GRAY);

        Label regNumber = new Label("Registration: 24RP05482", Label.CENTER);
        regNumber.setFont(new Font("Arial", Font.PLAIN, 14));
        regNumber.setForeground(Color.BLACK);

        // Add some decorative elements
        Panel infoPanel = new Panel();
        infoPanel.setLayout(new GridLayout(2, 1, 0, 10));
        infoPanel.setBackground(new Color(200, 230, 255));
        infoPanel.setPreferredSize(new Dimension(300, 100));

        infoPanel.add(studentDetails);
        infoPanel.add(regNumber);

        // Add components to center panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20);
        centerPanel.add(infoPanel, gbc);

        // Add all panels to student panel
        studentPanel.add(stuTitle, BorderLayout.NORTH);
        studentPanel.add(centerPanel, BorderLayout.CENTER);

        // Add both pages to CardLayout panel
        mainPanel.add("Login", loginPanel);
        mainPanel.add("Student", studentPanel);

        // Add main panel to frame
        add(mainPanel, BorderLayout.CENTER);

        // Close window event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    // Switch between pages when menu item is clicked
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Login")) {
            card.show(mainPanel, "Login");
        } else if (cmd.equals("Student")) {
            card.show(mainPanel, "Student");
        }
    }

    public static void main(String[] args) {
        new AWTMenuPractice();
    }
}