
package stitchitapp;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StichitApp {

   
    public static void main(String[] args) {

        // Create the main frame
        JFrame frame = new JFrame("Stichit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(430, 932); // Mobile screen size
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(240, 240, 240)); // Set iPhone-like background color

        // Create and add the top notch (iPhone-like notch)
        JPanel topNotch = new JPanel();
        topNotch.setBackground(Color.BLACK);
        topNotch.setBounds(0, 0, 430, 50);
        frame.add(topNotch);

        // Create and add the logo
        JLabel logo = new JLabel();
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\duaeh\\OneDrive\\Pictures\\Documents\\NetBeansProjects\\stitchitapp\\src\\img\\logo.jpg"); // Path to your logo image
        Image scaledImage = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Adjust size
        logo.setIcon(new ImageIcon(scaledImage));
        logo.setBounds(140, 100, 150, 150); // Center the logo
        frame.add(logo);

        // Create and add the title label
        JLabel titleLabel = new JLabel("Explore Stichit", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(50, 270, 330, 30); // Adjust position
        frame.add(titleLabel);

        // Create and add the subtitle label
        JLabel subtitleLabel = new JLabel("<html><div style='text-align: center;'>Explore the Tailors and Customers online all in one place now</div></html>", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setBounds(50, 310, 330, 30); // Adjust position
        frame.add(subtitleLabel);

        // Create and add the Sign In button
        JButton signInButton = new JButton("Sign In");
        signInButton.setBounds(115, 370, 200, 40); // Adjust position
        signInButton.setBackground(Color.BLACK);
        signInButton.setForeground(Color.WHITE);
        signInButton.setFont(new Font("Arial", Font.BOLD, 14));
        signInButton.setFocusPainted(false);
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add Sign In button action
                showSignInDialog(frame);
            }
        });
        frame.add(signInButton);

        // Create and add the Create Account button
        JButton createAccountButton = new JButton("Create account");
        createAccountButton.setBounds(115, 430, 200, 40); // Adjust position
        createAccountButton.setBackground(Color.WHITE);
        createAccountButton.setForeground(Color.BLACK);
        createAccountButton.setFont(new Font("Arial", Font.BOLD, 14));
        createAccountButton.setFocusPainted(false);
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add Create Account button action
                showRegisterScreen(frame);
            }
        });
        frame.add(createAccountButton);

        // Set frame visibility
        frame.setVisible(true);
    }

    private static void showSignInDialog(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();

        // Create and add the logo
        JLabel logo = new JLabel();
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\duaeh\\OneDrive\\Pictures\\Documents\\NetBeansProjects\\stitchitapp\\src\\img\\logo.jpg"); // Path to your logo image
        Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Adjust size
        logo.setIcon(new ImageIcon(scaledImage));
        logo.setBounds(165, 50, 100, 100); // Center the logo
        frame.add(logo);

        // Create and add the title label
        JLabel titleLabel = new JLabel("Log In", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(50, 160, 330, 30); // Adjust position
        frame.add(titleLabel);

        // Create and add the form fields
        int yPosition = 200;
        frame.add(createLabel("Email address:", 50, yPosition));
        JTextField emailField = createTextField(50, yPosition + 30);
        frame.add(emailField);

        yPosition += 70;
        frame.add(createLabel("Password:", 50, yPosition));
        JPasswordField passwordField = createPasswordField(50, yPosition + 30);
        frame.add(passwordField);

        // Create and add the Sign In button
        JButton signInButton = new JButton("Log in");
        signInButton.setBounds(50, yPosition + 80, 330, 40);
        signInButton.setBackground(Color.BLACK);
        signInButton.setForeground(Color.WHITE);
        signInButton.setFont(new Font("Arial", Font.BOLD, 14));
        signInButton.setFocusPainted(false);
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sign In action with validation
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if (email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!isValidPassword(password)) {
                    JOptionPane.showMessageDialog(frame, "Password must be at least 8 characters long and include at least one special character.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Logged in as: " + email);
                    showRegisterScreen(frame);
                }
            }
        });
        frame.add(signInButton);

        // Create and add the Sign Up link
        JLabel signUpLink = new JLabel("Don't have an account? Sign up", SwingConstants.CENTER);
        signUpLink.setFont(new Font("Arial", Font.PLAIN, 12));
        signUpLink.setBounds(50, yPosition + 140, 330, 30);
        signUpLink.setForeground(Color.BLUE);
        signUpLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signUpLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showRegisterScreen(frame);
            }
        });
        frame.add(signUpLink);

        frame.revalidate();
        frame.repaint();
    }

    private static void showRegisterScreen(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();

        // Create and add the logo
        JLabel logo = new JLabel();
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\duaeh\\OneDrive\\Pictures\\Documents\\NetBeansProjects\\stitchitapp\\src\\img\\logo.jpg"); // Path to your logo image
        Image scaledImage = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Adjust size
        logo.setIcon(new ImageIcon(scaledImage));
        logo.setBounds(140, 100, 150, 150); // Center the logo
        frame.add(logo);

        // Create and add the title label
        JLabel titleLabel = new JLabel("Explore Stichit", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(50, 270, 330, 30); // Adjust position
        frame.add(titleLabel);

        // Create and add the subtitle label
        JLabel subtitleLabel = new JLabel("<html><div style='text-align: center;'>Explore the Tailors and Customers online all in one place now</div></html>", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setBounds(50, 310, 330, 30); // Adjust position
        frame.add(subtitleLabel);

        // Create and add the Register as Tailor button
        JButton registerTailorButton = new JButton("REGISTER AS TAILOR");
        registerTailorButton.setBounds(115, 370, 200, 40); // Adjust position
        registerTailorButton.setBackground(Color.WHITE);
        registerTailorButton.setForeground(Color.BLACK);
        registerTailorButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerTailorButton.setFocusPainted(false);
        registerTailorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add Register as Tailor button action
                showRegisterForm(frame, "Tailor");
            }
        });
        frame.add(registerTailorButton);

        // Create and add the Register as Customer button
        JButton registerCustomerButton = new JButton("REGISTER AS CUSTOMER");
        registerCustomerButton.setBounds(115, 430, 200, 40); // Adjust position
        registerCustomerButton.setBackground(Color.BLACK);
        registerCustomerButton.setForeground(Color.WHITE);
        registerCustomerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerCustomerButton.setFocusPainted(false);
        registerCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add Register as Customer button action
                showRegisterForm(frame, "Customer");
            }
        });
        frame.add(registerCustomerButton);

        // Create and add the Log In link
        JLabel logInLink = new JLabel("Already have an account? Log in", SwingConstants.CENTER);
        logInLink.setFont(new Font("Arial", Font.PLAIN, 12));
        logInLink.setBounds(50, 490, 330, 30);
        logInLink.setForeground(Color.BLUE);
        logInLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logInLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showSignInDialog(frame);
            }
        });
        frame.add(logInLink);

        frame.revalidate();
        frame.repaint();
    }

    private static void showRegisterForm(JFrame frame, String userType) {
        frame.getContentPane().removeAll();
        frame.repaint();

        // Create and add the title label
        JLabel titleLabel = new JLabel("Register as " + userType, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(50, 50, 330, 30); // Adjust position
        frame.add(titleLabel);

        // Create and add the form fields
        int yPosition = 100;
        frame.add(createLabel("Full Name:", 50, yPosition));
        JTextField nameField = createTextField(50, yPosition + 30);
        frame.add(nameField);

        yPosition += 70;
        frame.add(createLabel("Username:", 50, yPosition));
        JTextField usernameField = createTextField(50, yPosition + 30);
        frame.add(usernameField);

        JTextField tailorIDField = null;
        if (userType.equals("Tailor")) {
            yPosition += 70;
            frame.add(createLabel("Tailor ID:", 50, yPosition));
            tailorIDField = createTextField(50, yPosition + 30);
            frame.add(tailorIDField);
        }

        yPosition += 70;
        frame.add(createLabel("Email address:", 50, yPosition));
        JTextField emailField = createTextField(50, yPosition + 30);
        frame.add(emailField);

        yPosition += 70;
        frame.add(createLabel("Password:", 50, yPosition));
        JPasswordField passwordField = createPasswordField(50, yPosition + 30);
        frame.add(passwordField);

        yPosition += 70;
        frame.add(createLabel("Confirm Password:", 50, yPosition));
        JPasswordField confirmPasswordField = createPasswordField(50, yPosition + 30);
        frame.add(confirmPasswordField);

        // Create and add the Register button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(50, yPosition + 80, 330, 40);
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.setFocusPainted(false);
        JTextField finalTailorIDField = tailorIDField;
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Registration action with validation
                String fullName = nameField.getText();
                String username = usernameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                String tailorID = userType.equals("Tailor") ? finalTailorIDField.getText() : "";

                if (fullName.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || (userType.equals("Tailor") && tailorID.isEmpty())) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(frame, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!isValidPassword(password)) {
                    JOptionPane.showMessageDialog(frame, "Password must be at least 8 characters long and include at least one special character.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Registered as: " + fullName);
                    showSignInDialog(frame);
                }
            }
        });
        frame.add(registerButton);

        // Create and add the Log In link
        JLabel logInLink = new JLabel("Already have an account? Log in", SwingConstants.CENTER);
        logInLink.setFont(new Font("Arial", Font.PLAIN, 12));
        logInLink.setBounds(50, yPosition + 140, 330, 30);
        logInLink.setForeground(Color.BLUE);
        logInLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logInLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showSignInDialog(frame);
            }
        });
        frame.add(logInLink);

        frame.revalidate();
        frame.repaint();
    }

    private static boolean isValidPassword(String password) {
        return password.length() >= 8 && password.matches(".*\\W.*");
    }


    private static JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBounds(x, y, 330, 30);
        return label;
    }

    private static JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 330, 30);
        return textField;
    }

    private static JPasswordField createPasswordField(int x, int y) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(x, y, 330, 30);
        return passwordField;
    }
}

    

      /*  // Create the main frame
        JFrame frame = new JFrame("Stichit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(430, 932); // Mobile screen size
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(240, 240, 240)); // Set iPhone-like background color

        // Create and add the top notch (iPhone-like notch)
        JPanel topNotch = new JPanel();
        topNotch.setBackground(Color.BLACK);
        topNotch.setBounds(0, 0, 430, 50);
        frame.add(topNotch);

        // Create and add the logo
        JLabel logo = new JLabel();
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\duaeh\\OneDrive\\Pictures\\Documents\\NetBeansProjects\\stitchitapp\\src\\img\\logo.jpg"); // Path to your logo image
        Image scaledImage = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Adjust size
        logo.setIcon(new ImageIcon(scaledImage));
        logo.setBounds(140, 100, 150, 150); // Center the logo
        frame.add(logo);

        // Create and add the title label
        JLabel titleLabel = new JLabel("Explore Stichit", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(50, 270, 330, 30); // Adjust position
        frame.add(titleLabel);

        // Create and add the subtitle label
        JLabel subtitleLabel = new JLabel("<html><div style='text-align: center;'>Explore the Tailors and Customers online all in one place now</div></html>", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setBounds(50, 310, 330, 30); // Adjust position
        frame.add(subtitleLabel);

        // Create and add the Sign In button
        JButton signInButton = new JButton("Sign In");
        signInButton.setBounds(115, 370, 200, 40); // Adjust position
        signInButton.setBackground(Color.BLACK);
        signInButton.setForeground(Color.WHITE);
        signInButton.setFont(new Font("Arial", Font.BOLD, 14));
        signInButton.setFocusPainted(false);
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add Sign In button action
                showSignInDialog(frame);
            }
        });
        frame.add(signInButton);

        // Create and add the Create Account button
        JButton createAccountButton = new JButton("Create account");
        createAccountButton.setBounds(115, 430, 200, 40); // Adjust position
        createAccountButton.setBackground(Color.WHITE);
        createAccountButton.setForeground(Color.BLACK);
        createAccountButton.setFont(new Font("Arial", Font.BOLD, 14));
        createAccountButton.setFocusPainted(false);
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add Create Account button action
                showRegisterScreen(frame);
            }
        });
        frame.add(createAccountButton);

        // Set frame visibility
        frame.setVisible(true);
    }

    private static void showSignInDialog(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();

        // Create and add the logo
        JLabel logo = new JLabel();
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\duaeh\\OneDrive\\Pictures\\Documents\\NetBeansProjects\\stitchitapp\\src\\img\\logo.jpg"); // Path to your logo image
        Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Adjust size
        logo.setIcon(new ImageIcon(scaledImage));
        logo.setBounds(165, 50, 100, 100); // Center the logo
        frame.add(logo);

        // Create and add the title label
        JLabel titleLabel = new JLabel("Log In", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(50, 160, 330, 30); // Adjust position
        frame.add(titleLabel);

        // Create and add the form fields
        int yPosition = 200;
        frame.add(createLabel("Email address:", 50, yPosition));
        JTextField emailField = createTextField(50, yPosition + 30);
        frame.add(emailField);

        yPosition += 70;
        frame.add(createLabel("Password:", 50, yPosition));
        JPasswordField passwordField = createPasswordField(50, yPosition + 30);
        frame.add(passwordField);

        // Create and add the Sign In button
        JButton signInButton = new JButton("Log in");
        signInButton.setBounds(50, yPosition + 80, 330, 40);
        signInButton.setBackground(Color.BLACK);
        signInButton.setForeground(Color.WHITE);
        signInButton.setFont(new Font("Arial", Font.BOLD, 14));
        signInButton.setFocusPainted(false);
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sign In action with validation
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if (email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!isValidPassword(password)) {
                    JOptionPane.showMessageDialog(frame, "Password must be at least 8 characters long and include at least one special character.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Logged in as: " + email);
                    showRegisterScreen(frame);
                }
            }
        });
        frame.add(signInButton);

        // Create and add the Sign Up link
        JLabel signUpLink = new JLabel("Don't have an account? Sign up", SwingConstants.CENTER);
        signUpLink.setFont(new Font("Arial", Font.PLAIN, 12));
        signUpLink.setBounds(50, yPosition + 140, 330, 30);
        signUpLink.setForeground(Color.BLUE);
        signUpLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signUpLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showRegisterScreen(frame);
            }
        });
        frame.add(signUpLink);

        frame.revalidate();
        frame.repaint();
    }

    private static void showRegisterScreen(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();

        // Create and add the logo
        JLabel logo = new JLabel();
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\duaeh\\OneDrive\\Pictures\\Documents\\NetBeansProjects\\stitchitapp\\src\\img\\logo.jpg"); // Path to your logo image
        Image scaledImage = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Adjust size
        logo.setIcon(new ImageIcon(scaledImage));
        logo.setBounds(140, 100, 150, 150); // Center the logo
        frame.add(logo);

        // Create and add the title label
        JLabel titleLabel = new JLabel("Explore Stichit", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(50, 270, 330, 30); // Adjust position
        frame.add(titleLabel);

        // Create and add the subtitle label
        JLabel subtitleLabel = new JLabel("<html><div style='text-align: center;'>Explore the Tailors and Customers online all in one place now</div></html>", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setBounds(50, 310, 330, 30); // Adjust position
        frame.add(subtitleLabel);

        // Create and add the Register as Tailor button
        JButton registerTailorButton = new JButton("REGISTER AS TAILOR");
        registerTailorButton.setBounds(115, 370, 200, 40); // Adjust position
        registerTailorButton.setBackground(Color.WHITE);
        registerTailorButton.setForeground(Color.BLACK);
        registerTailorButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerTailorButton.setFocusPainted(false);
        registerTailorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add Register as Tailor button action
                showRegisterForm(frame, "Tailor");
            }
        });
        frame.add(registerTailorButton);

        // Create and add the Register as Customer button
        JButton registerCustomerButton = new JButton("REGISTER AS CUSTOMER");
        registerCustomerButton.setBounds(115, 430, 200, 40); // Adjust position
        registerCustomerButton.setBackground(Color.BLACK);
        registerCustomerButton.setForeground(Color.WHITE);
        registerCustomerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerCustomerButton.setFocusPainted(false);
        registerCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add Register as Customer button action
                showRegisterForm(frame, "Customer");
            }
        });
        frame.add(registerCustomerButton);

        // Set frame visibility
        frame.setVisible(true);
    }

    private static void showRegisterForm(JFrame frame, String userType) {
        frame.getContentPane().removeAll();
        frame.repaint();

        // Create and add the title label
        JLabel titleLabel = new JLabel("Register as " + userType, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(50, 50, 330, 30); // Adjust position
        frame.add(titleLabel);

        // Create and add the form fields
        int yPosition = 100;
        frame.add(createLabel("Full Name:", 50, yPosition));
        JTextField nameField = createTextField(50, yPosition + 30);
        frame.add(nameField);

        yPosition += 70;
        frame.add(createLabel("Email address:", 50, yPosition));
        JTextField emailField = createTextField(50, yPosition + 30);
        frame.add(emailField);

        yPosition += 70;
        frame.add(createLabel("Password:", 50, yPosition));
        JPasswordField passwordField = createPasswordField(50, yPosition + 30);
        frame.add(passwordField);

        // Create and add the Register button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(50, yPosition + 80, 330, 40);
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.setFocusPainted(false);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Registration action with validation
                String fullName = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!isValidPassword(password)) {
                    JOptionPane.showMessageDialog(frame, "Password must be at least 8 characters long and include at least one special character.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Registered as: " + fullName);
                    showSignInDialog(frame);
                }
            }
        });
        frame.add(registerButton);

        frame.revalidate();
        frame.repaint();
    }

    private static boolean isValidPassword(String password) {
        return password.length() >= 8 && password.matches(".*\\W.*");
    }

    private static JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBounds(x, y, 330, 30);
        return label;
    }

    private static JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 330, 30);
        return textField;
    }

    private static JPasswordField createPasswordField(int x, int y) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(x, y, 330, 30);
        return passwordField;
    }
}*/
      
