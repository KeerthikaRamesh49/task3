# LoginApp - Optional: Adding Login Functionality

This document provides example code for adding functionality to the login button.

## Basic Login Validation (In-Memory)

### Step 1: Add Event Handler to LoginButton

In NetBeans Design View:
1. Double-click the Login button
2. This auto-generates an event handler method
3. Add the following code:

```java
private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
    String username = usernameField.getText().trim();
    String password = new String(passwordField.getPassword());
    
    // Simple validation
    if (username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "Please fill in all fields", 
            "Validation Error", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Simple authentication (hardcoded for demo)
    if (username.equals("admin") && password.equals("password")) {
        JOptionPane.showMessageDialog(this, 
            "Login Successful! Welcome " + username, 
            "Success", 
            JOptionPane.INFORMATION_MESSAGE);
        clearFields();
        
        // Optional: Close login window and open main application
        // new MainWindow().setVisible(true);
        // this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, 
            "Invalid username or password", 
            "Authentication Failed", 
            JOptionPane.ERROR_MESSAGE);
        clearFields();
        usernameField.requestFocus(); // Focus back to username field
    }
}
```

## Validation with Multiple Users

### Step 2: Create a User Array

Add this to the LoginForm class (before initComponents()):

```java
// Simple user database (replace with real database later)
private static final String[][] USERS = {
    {"admin", "password"},
    {"user1", "user123"},
    {"user2", "pass456"}
};

// Validate user credentials
private boolean validateUser(String username, String password) {
    for (String[] user : USERS) {
        if (user[0].equals(username) && user[1].equals(password)) {
            return true;
        }
    }
    return false;
}
```

### Step 3: Update Event Handler to Use Validation

```java
private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
    String username = usernameField.getText().trim();
    String password = new String(passwordField.getPassword());
    
    // Validation
    if (username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Username cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
        usernameField.requestFocus();
        return;
    }
    
    if (password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Password cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
        passwordField.requestFocus();
        return;
    }
    
    // Check credentials
    if (validateUser(username, password)) {
        JOptionPane.showMessageDialog(this, 
            "Welcome " + username + "!", 
            "Login Successful", 
            JOptionPane.INFORMATION_MESSAGE);
        clearFields();
    } else {
        JOptionPane.showMessageDialog(this, 
            "Invalid credentials. Please try again.", 
            "Login Failed", 
            JOptionPane.ERROR_MESSAGE);
        clearFields();
    }
}
```

## Enhanced Password Requirements

Add validation for strong passwords:

```java
private boolean isValidPassword(String password) {
    if (password.length() < 8) {
        JOptionPane.showMessageDialog(this, 
            "Password must be at least 8 characters long", 
            "Weak Password", 
            JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    if (!password.matches(".*[A-Z].*")) {
        JOptionPane.showMessageDialog(this, 
            "Password must contain at least one uppercase letter", 
            "Weak Password", 
            JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    if (!password.matches(".*[0-9].*")) {
        JOptionPane.showMessageDialog(this, 
            "Password must contain at least one number", 
            "Weak Password", 
            JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    return true;
}
```

## Adding a "Forgot Password" Button

### Step 1: Add Button to LoginForm

In initComponents():
```java
JButton forgotPasswordButton = new JButton("Forgot Password?");
forgotPasswordButton.setFont(new Font("Arial", Font.PLAIN, 10));
forgotPasswordButton.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        handleForgotPassword();
    }
});
```

### Step 2: Implement Handler Method

```java
private void handleForgotPassword() {
    String email = JOptionPane.showInputDialog(this, 
        "Enter your registered email address:", 
        "Forgot Password", 
        JOptionPane.QUESTION_MESSAGE);
    
    if (email != null && !email.trim().isEmpty()) {
        // In a real application, send recovery email
        JOptionPane.showMessageDialog(this, 
            "Password reset link sent to " + email, 
            "Email Sent", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}
```

## Database Integration (MySQL Example)

### Prerequisites
```
- MySQL Server installed
- MySQL Connector/J (JDBC driver) added to project libraries
```

### Step 1: Add Database Connection

```java
import java.sql.*;

private Connection getDBConnection() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/loginapp";
    String user = "root";
    String password = "your_password";
    return DriverManager.getConnection(url, user, password);
}
```

### Step 2: Database Query Method

```java
private boolean validateUserFromDB(String username, String password) {
    String query = "SELECT password FROM users WHERE username = ?";
    
    try (Connection conn = getDBConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            String storedPassword = rs.getString("password");
            // In production, use password hashing (BCrypt, PBKDF2)
            return hashPassword(password).equals(storedPassword);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return false;
}

// Simple password hashing (use BCrypt in production!)
private String hashPassword(String password) {
    // Implement proper hashing using BCrypt or similar
    return password; // PLACEHOLDER - use real hashing!
}
```

### Step 3: Create Database Table

```sql
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert test users (passwords should be hashed in real application)
INSERT INTO users (username, password, email) VALUES
('admin', 'hashed_password_1', 'admin@example.com'),
('user1', 'hashed_password_2', 'user1@example.com');
```

## Error Handling Best Practices

```java
private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());
        
        // Input validation
        if (username.isEmpty() || password.isEmpty()) {
            showError("All fields are required");
            return;
        }
        
        // Validation logic
        if (validateCredentials(username, password)) {
            showSuccess("Login successful!");
            clearFields();
        } else {
            showError("Invalid username or password");
            clearFields();
        }
        
    } catch (Exception e) {
        showError("An error occurred: " + e.getMessage());
        System.err.println("Login error: " + e);
        e.printStackTrace();
    }
}

private void showError(String message) {
    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
}

private void showSuccess(String message) {
    JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
}

private boolean validateCredentials(String username, String password) {
    // Implement your validation logic here
    return username.equals("admin") && password.equals("password");
}
```

## Testing the Login Functionality

### Test Cases to Verify

1. **Empty Fields**
   - Leave username empty → Error message
   - Leave password empty → Error message

2. **Invalid Credentials**
   - Enter wrong username → Error message
   - Enter wrong password → Error message

3. **Valid Credentials**
   - Enter admin/password → Success message
   - Fields cleared after login

4. **Security**
   - Password field masks input
   - No sensitive data in error messages
   - Password not logged or displayed

## Security Reminders

⚠️ **IMPORTANT SECURITY NOTES:**

1. **Never hardcode credentials** in production
2. **Never store plain text passwords** - use hashing (BCrypt, PBKDF2, Argon2)
3. **Validate on both client AND server** - don't trust client-side validation alone
4. **Use HTTPS** when sending credentials over network
5. **Implement rate limiting** to prevent brute force attacks
6. **Log authentication attempts** for security audits
7. **Use parameterized queries** to prevent SQL injection
8. **Implement lockout** after N failed attempts
9. **Add CAPTCHA** for additional security
10. **Use secure session management** after successful login

---

## Example: Complete Enhanced Login Handler

```java
private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
    String username = usernameField.getText().trim();
    String password = new String(passwordField.getPassword());
    
    // Step 1: Validate input
    if (!validateInput(username, password)) {
        return;
    }
    
    // Step 2: Authenticate user
    try {
        if (authenticate(username, password)) {
            handleSuccessfulLogin(username);
        } else {
            handleFailedLogin();
        }
    } catch (Exception e) {
        handleLoginError(e);
    }
}

private boolean validateInput(String username, String password) {
    if (username.isEmpty()) {
        showError("username is required");
        usernameField.requestFocus();
        return false;
    }
    if (password.isEmpty()) {
        showError("Password is required");
        passwordField.requestFocus();
        return false;
    }
    return true;
}

private boolean authenticate(String username, String password) {
    // Add your authentication logic here
    return username.equals("admin") && password.equals("password");
}

private void handleSuccessfulLogin(String username) {
    showSuccess("Welcome " + username);
    clearFields();
    // Open main application window
    // dispose(); // Close login window
}

private void handleFailedLogin() {
    showError("Invalid credentials");
    clearFields();
    usernameField.requestFocus();
}

private void handleLoginError(Exception e) {
    showError("Login system error: " + e.getMessage());
    System.err.println("Error: " + e);
}
```

---

**Note:** These examples are for learning purposes. Always implement proper security measures in production applications.
