# LoginApp - Design Documentation

## Project Overview
This is a Login Page application designed using Java Swing components. The application follows NetBeans IDE standards for JFrame-based GUI applications.

## Design Steps Completed

### 1. Project Structure
```
LoginApp/
└── src/
    ├── Main.java (Entry point)
    └── LoginForm.java (JFrame form)
```

### 2. Components Implemented

#### Title Label
- **Text**: "Login Page"
- **Font**: Arial, Bold, 24px
- **Alignment**: Center
- **Purpose**: Main heading for the login form

#### Username Components
- **Label**: "Username:"
- **Field**: JTextField named `usernameField`
- **Tooltip**: "Enter your username"
- **Width**: 200px
- **Height**: 30px

#### Password Components
- **Label**: "Password:"
- **Field**: JPasswordField named `passwordField`
- **Tooltip**: "Enter your password"
- **Width**: 200px
- **Height**: 30px

#### Login Button
- **Text**: "Login"
- **Name**: `loginButton`
- **Width**: 200px
- **Height**: 35px
- **Font**: Arial, Plain, 12px

### 3. Layout Configuration
- **Layout Manager**: GroupLayout (preferred by NetBeans)
- **Window Size**: 400x300 pixels
- **Window Position**: Centered on screen (`setLocationRelativeTo(null)`)
- **Resizable**: False (for consistent appearance)

### 4. Spacing & Alignment
- **Top padding**: 30px
- **Title to form gap**: 30px
- **Between fields**: 15px
- **Label to field gap**: 20px
- **Bottom padding**: 30px
- **Horizontal padding**: 50px on each side

### 5. Visual Features
- Professional Arial font family
- Tooltips for user guidance
- Center-aligned main components
- Consistent padding throughout
- Clean, minimal design

## How to Use in NetBeans

### Option 1: Import into Existing NetBeans Project
1. Open NetBeans IDE
2. Create a new Java Application project (File > New Project > Java > Java Application)
3. Name it "LoginApp" and click Finish
4. Copy the Java files from `src/` folder into the project's Source Packages
5. Run the project (Shift + F6)

### Option 2: Create Project from Scratch
1. Open NetBeans IDE
2. File > New Project > Java > Java Application
3. Project Name: "LoginApp"
4. Click Finish
5. Right-click Source Packages > New > JFrame Form
6. Name it "LoginForm"
7. Use the Design View to add components as specified in the components list above
8. Create Main.java with the code provided

## Running the Application
1. Press **Shift + F6** (or click Run button)
2. The application will display a centered 400x300 window
3. All components should be properly aligned and spaced
4. Form is ready for functionality to be added

## Verification Checklist
- [ ] Window is centered on screen
- [ ] Title "Login Page" appears at top in large font
- [ ] Username label and text field are aligned
- [ ] Password label and password field are aligned
- [ ] Login button appears at bottom
- [ ] All components have proper spacing
- [ ] Tooltips appear on hover
- [ ] Window size is 400x300
- [ ] All fonts are readable

## Next Steps (Optional - Add Functionality)

### To Add Login Button Functionality:
1. Double-click `loginButton` in Design View
2. Add event handler code (example below):

```java
private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
    String username = usernameField.getText();
    String password = new String(passwordField.getPassword());
    
    // Example: Simple validation
    if (username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (username.equals("admin") && password.equals("password")) {
        JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        clearFields();
    } else {
        JOptionPane.showMessageDialog(this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
        clearFields();
    }
}
```

### To Add Database Validation:
- Store user credentials in a database (MySQL, SQLite, etc.)
- Query the database in the loginButtonActionPerformed method
- Implement proper password hashing (never store plain text passwords)

### To Add More Features:
- Register button for new users
- Password reset functionality
- Remember me checkbox
- Social media login options
- Loading animations

## Code Structure

### LoginForm.java
- **initComponents()**: Creates and configures all GUI components
- **setupLayout()**: Configures GroupLayout for component placement
- **setupFrame()**: Sets JFrame properties (title, size, location, etc.)
- **Getter methods**: Allow access to components for adding listeners
- **clearFields()**: Clears input fields after login attempt

### Main.java
- **main()**: Entry point that instantiates LoginForm

## Customization Options

### Change Font
```java
titleLabel.setFont(new Font("Verdana", Font.BOLD, 28));
```

### Change Colors
```java
usernameField.setBackground(new Color(240, 240, 240));
mainPanel.setBackground(new Color(255, 255, 255));
```

### Add a Logo/Icon
```java
titleLabel.setIcon(new ImageIcon("path/to/logo.png"));
```

### Change Window Title
```java
setTitle("Your Custom Title");
```

## System Requirements
- Java Development Kit (JDK) 8 or higher
- NetBeans IDE 8.0 or higher
- Swing Library (included with JDK)

## File Descriptions

| File | Purpose |
|------|---------|
| LoginForm.java | JFrame-based login form with all GUI components |
| Main.java | Entry point that launches the LoginForm |
| DESIGN_DOCUMENTATION.md | This file - comprehensive design documentation |
| SETUP_INSTRUCTIONS.md | Step-by-step setup guide for NetBeans |

## Design Decision Rationale

1. **GroupLayout Choice**: NetBeans default, provides precise component positioning
2. **Fixed Window Size**: Ensures consistent UI across different systems
3. **Centered Window**: Better user experience, professional appearance
4. **Tooltips**: Improves usability without cluttering the interface
5. **Arial Font**: Widely available, professional appearance
6. **Padding Values**: Balanced whitespace for visual clarity

## Troubleshooting

### Components not visible?
- Check that setVisible(true) is called in setupFrame()
- Verify contentPane is set correctly (setContentPane(mainPanel))
- Check component sizes in layout

### Window not centered?
- Ensure setLocationRelativeTo(null) is called before setVisible(true)

### Tooltips not showing?
- Verify ToolTipManager is enabled in your JVM
- Tooltips appear after hovering for ~750ms by default

---

**Created**: 2026
**Version**: 1.0
**Language**: Java (Swing GUI Framework)
