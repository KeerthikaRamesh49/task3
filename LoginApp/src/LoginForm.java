import javax.swing.*;
import java.awt.*;

/**
 * LoginForm - A JFrame component displaying a login interface
 * 
 * Components:
 * - Title Label: "Login Page"
 * - Username Label and TextField
 * - Password Label and PasswordField
 * - Login Button
 * 
 * Design Features:
 * - Centered window (400x300)
 * - GroupLayout for organized component arrangement
 * - Professional styling with Arial font
 * - Tooltips for user guidance
 */
public class LoginForm extends JFrame {
    
    // Component declarations
    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel mainPanel;
    
    /**
     * Constructor: Initializes and sets up the LoginForm
     */
    public LoginForm() {
        initComponents();
        setupFrame();
    }
    
    /**
     * Initialize all GUI components
     */
    private void initComponents() {
        // Initialize the main panel
        mainPanel = new JPanel();
        
        // Create and configure Title Label
        titleLabel = new JLabel("Login Page");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // Create and configure Username components
        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        
        usernameField = new JTextField(20);
        usernameField.setToolTipText("Enter your username");
        usernameField.setPreferredSize(new Dimension(200, 30));
        
        // Create and configure Password components
        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        
        passwordField = new JPasswordField(20);
        passwordField.setToolTipText("Enter your password");
        passwordField.setPreferredSize(new Dimension(200, 30));
        
        // Create and configure Login Button
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 12));
        loginButton.setPreferredSize(new Dimension(200, 35));
        
        // Set up layout using GroupLayout
        setupLayout();
    }
    
    /**
     * Set up the layout for the form using GroupLayout
     */
    private void setupLayout() {
        mainPanel.setLayout(new javax.swing.GroupLayout(mainPanel));
        javax.swing.GroupLayout layout = (javax.swing.GroupLayout) mainPanel.getLayout();
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(usernameLabel)
                        .addComponent(passwordLabel))
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(50))
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(30)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30)
        );
    }
    
    /**
     * Configure the JFrame properties
     */
    private void setupFrame() {
        setTitle("Login Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window on screen
        setResizable(false);
        setVisible(true);
    }
    
    /**
     * Get methods for accessing components (useful for adding event listeners)
     */
    public JButton getLoginButton() {
        return loginButton;
    }
    
    public JTextField getUsernameField() {
        return usernameField;
    }
    
    public JPasswordField getPasswordField() {
        return passwordField;
    }
    
    /**
     * Clear all input fields
     */
    public void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
    }
}
