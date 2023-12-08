/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snackies;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author chase
 */

public class UserLoginView extends JFrame {
    
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton exitButton;
    private JButton registerButton;
    private UserController controller;
    
    /**
     * Constructs a new UserLoginView instance
     */
    
    public UserLoginView() {
        initComponents();
    }
    
    /**
     * Sets the components for UserLoginView
     */

    private void initComponents() {
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        exitButton = new JButton("Exit");
        registerButton = new JButton("Register");
        usernameField.setPreferredSize(new Dimension(50, 20));
        passwordField.setPreferredSize(new Dimension(50, 20));
        loginButton.setPreferredSize(new Dimension(100, 50));
        exitButton.setPreferredSize(new Dimension(100, 50));
        registerButton.setPreferredSize(new Dimension(100, 50));
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(usernameField);
        centerPanel.add(passwordField);
        centerPanel.add(loginButton);
        centerPanel.add(exitButton);
        centerPanel.add(registerButton);
         
        add(centerPanel, BorderLayout.CENTER);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        loginButton.addActionListener(e -> controller.login(usernameField.getText(), new String(passwordField.getPassword())));
        registerButton.addActionListener(e -> registerUser());
        exitButton.addActionListener(e -> controller.exit());
    }
    
    /**
     * Sets the UserController to link for this UserLoginView instance
     * 
     * @param controller The UserController instance
     */
    
    public void setController(UserController controller) {
        this.controller = controller;
    }
    
    /**
     * Takes the username and password input and registers a new user
     */
    
    private void registerUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        controller.registerUser(username, password);
    }

    /**
     * Clears the username and password text fields
     */

    public void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
    }
    
    /**
     * Gets the text from the username text field
     * 
     * @return The text from username text field
     */
    
    //Getters for testing
    public String getUsernameField() {
        return usernameField.getText();
    }
    
    /**
     * Gets the text from the password text field
     * 
     * @return The text from password text field
     */
    
    //Getters for testing
    public String getPasswordField() {
        return new String(passwordField.getPassword());
    }
}
