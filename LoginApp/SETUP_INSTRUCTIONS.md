# LoginApp Setup Instructions for NetBeans

## Quick Start Guide

### Step 1: Prepare Files
1. Locate your LoginApp folder at: `c:\Users\keert\OneDrive\Desktop\internship\task3\LoginApp\`
2. Inside, you'll find a `src/` folder containing:
   - `Main.java`
   - `LoginForm.java`

### Step 2: Create Project in NetBeans

#### Method A: Create New Project from Scratch

1. **Open NetBeans IDE**
   - Launch NetBeans (usually from Start Menu or desktop shortcut)

2. **Create New Project**
   - Go to `File` → `New Project`
   - Select `Java` category
   - Choose `Java Application`
   - Click `Next`

3. **Configure Project**
   - **Project Name**: LoginApp
   - **Project Location**: `c:\Users\keert\OneDrive\Desktop\internship\task3`
   - **Create Main Class**: Check if you want Main.java auto-created
   - Click `Finish`

4. **Add Files to Project**
   - Right-click on `Source Packages` in left panel
   - Select `New` → `Java Class`
   - Name it `LoginForm`, click `Finish`
   - Copy the entire content from `LoginForm.java` file
   - Paste it into the new LoginForm.java file in NetBeans
   - Repeat for `Main.java` if not auto-created

#### Method B: Open Existing Project

1. Go to `File` → `Open Project`
2. Navigate to `c:\Users\keert\OneDrive\Desktop\internship\task3\LoginApp`
3. Click `Open Project`
4. NetBeans will detect and load the project structure

### Step 3: Verify Project Structure

In NetBeans Project Panel (left side), you should see:
```
LoginApp
├── Source Packages
│   ├── LoginForm.java
│   └── Main.java
└── Libraries
    ├── JDK [version]
    └── ...
```

### Step 4: Build and Run

1. **Compile the Project**
   - Press `Ctrl + Shift + B` (or go to `Run` → `Build Project`)
   - Wait for "BUILD SUCCESSFUL" message at bottom

2. **Run the Application**
   - Press `Shift + F6` (or go to `Run` → `Run Project`)
   - The LoginForm window should appear, centered on your screen

### Step 5: Verify the Design

When the application runs, check that:

- [ ] **Window Appearance**
  - Window is centered on the screen
  - Window size is approximately 400x300 pixels
  - Window cannot be resized
  - Title bar shows "Login Application"

- [ ] **Components Visible**
  - "Login Page" title appears at the top in large bold font (Arial, 24)
  - Username label and text field are visible
  - Password label and password field are visible
  - Login button appears at the bottom
  - All components are properly aligned

- [ ] **Component Functionality**
  - Hover over Username field → tooltip shows "Enter your username"
  - Hover over Password field → tooltip shows "Enter your password"
  - Can type in both fields
  - Button is clickable (doesn't do anything yet, which is normal)

- [ ] **Visual Quality**
  - Adequate spacing between components
  - No overlapping elements
  - Professional appearance with clean layout
  - Consistent font sizing

## Customizing in NetBeans Design View (Optional)

If you want to modify the design using NetBeans visual designer:

### Note: The provided LoginForm.java uses programmatic layout (GroupLayout)
This means components are defined in code, not using the NetBeans drag-and-drop designer. To use the drag-and-drop designer:

1. **Option 1: Use Provided Code as-is**
   - The code is already properly designed
   - No need for visual designer modifications

2. **Option 2: Convert to Visual Design**
   - Right-click LoginForm.java → Delete
   - Right-click Source Packages → New → JFrame Form
   - Name it LoginForm
   - Use the Design tab at the bottom to drag-and-drop components
   - Refer to the "Add Components to the Form" section in DESIGN_DOCUMENTATION.md

## Running from Command Line (Alternative)

If you prefer to run without NetBeans:

1. **Open Command Prompt**
   - Press `Windows Key + R`
   - Type `cmd` and press Enter
   - Navigate to: `cd c:\Users\keert\OneDrive\Desktop\internship\task3\LoginApp`

2. **Compile**
   ```
   javac -d bin src/*.java
   ```

3. **Run**
   ```
   java -cp bin Main
   ```

## Troubleshooting

### Issue: "Cannot find symbol" errors

**Solution:**
- Make sure both Main.java and LoginForm.java are in the same `src/` folder
- Both files have no package declaration (should just start with `import`)
- Clean and rebuild: `Run` → `Clean and Build Project`

### Issue: Window doesn't appear

**Solution:**
- Check if it's behind another window
- Verify Swing library is properly installed with JDK
- Check for error messages in Output window (View → Output)
- Try running again with `Shift + F6`

### Issue: Components look misaligned or too small

**Solution:**
- This could be a display scaling issue
- Try changing font size in LoginForm.java:
  ```java
  titleLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Increase from 24
  ```

### Issue: Tooltips don't appear

**Solution:**
- Tooltips require hovering for ~750ms
- Check that you're hovering over the text field itself, not the label
- This is normal Java Swing behavior

### Issue: Project won't run

**Solution:**
1. Check if JDK is installed: `File` → `Project Properties` → `Libraries`
2. Should see JDK listed (e.g., "JDK 11", "JDK 17", etc.)
3. If not, install JDK or configure NetBeans to find it

## Next Steps After Verification

1. **Keep the basic form as-is** if you just need the UI design (currently complete)

2. **Add Login Functionality** (Optional)
   - Double-click the Login button in NetBeans
   - Add validation code in the event handler
   - Example code provided in DESIGN_DOCUMENTATION.md

3. **Save Your Work**
   - Press `Ctrl + S` to save
   - NetBeans auto-saves periodically

4. **Export/Package**
   - To create an executable JAR:
   - Right-click project → `Properties`
   - Set Main Class to "Main"
   - Go to `Build` → `Build with Dependencies`
   - JAR will be in `dist/` folder

## Important Notes

- **Java Version**: Recommend Java 11 or higher (LTS versions preferred)
- **IDE Version**: Works with NetBeans 12+, better with NetBeans 17+
- **Operating System**: Works on Windows, macOS, and Linux
- **Display Scaling**: If on high-DPI display, components might appear differently sized

## File Locations Reference

| Item | Location |
|------|----------|
| Project Root | `c:\Users\keert\OneDrive\Desktop\internship\task3\LoginApp` |
| Source Files | `c:\Users\keert\OneDrive\Desktop\internship\task3\LoginApp\src` |
| Compiled Classes | `c:\Users\keert\OneDrive\Desktop\internship\task3\LoginApp\build\classes` (auto-created) |
| JAR Output | `c:\Users\keert\OneDrive\Desktop\internship\task3\LoginApp\dist` (after build) |
| This Guide | `c:\Users\keert\OneDrive\Desktop\internship\task3\LoginApp\SETUP_INSTRUCTIONS.md` |

## Quick Command Reference

| Action | Keyboard Shortcut | Menu Path |
|--------|-------------------|-----------|
| Run Project | Shift + F6 | Run → Run Project |
| Build Project | Ctrl + Shift + B | Run → Build Project |
| Clean & Build | - | Run → Clean and Build Project |
| Save File | Ctrl + S | File → Save |
| New Java Class | - | Right-click Source Package → New → Java Class |

---

**Need Help?**
- NetBeans Help: File → Help Contents (F1)
- Official Docs: https://netbeans.apache.org/
- Community: https://netbeans.apache.org/community/

