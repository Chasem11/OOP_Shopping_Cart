/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snackies;
import javax.swing.*;
import java.io.*;

/**
 *
 * @author chase
 */

public class UserController {
    
    private User user;
    private UserLoginView view;
    public boolean isLoggedIn = false;
    
    /**
     * Links a new UserController instance to a User instance
     * 
     * @param user The User instance
     */
    
    public UserController(User user) {
        this.user = user;
    }
    
    /**
     * Links a UserLoginView to this controller instance
     * 
     * @param view The UserLoginView instance
     */

    public void setView(UserLoginView view) {
        this.view = view;
        this.view.setController(this);
    }
    
    /**
    * Attempts to log in a user with the provided username and password
    *
    * @param username The username of the user attempting to log in
    * @param password The password of the user attempting to log in
    * @throws FileNotFoundException If the user file does not exist
    * @throws IOException If there is an error reading the user file
    */
    
    public void login(String username, String password) {
        DataManager dataManager = DataManager.getInstance();
        
        try {
            
            User user = (User) dataManager.deserializeObject("users/" + username + ".ser");
            
            if (user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(view, "Login Successful");
                view.dispose();
                isLoggedIn = true;
                new Dashboard().setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(view, "Login Failed: Incorrect Login!");
                isLoggedIn = false;
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(view, "Login Failed: User not found");
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(view, "Login Failed!");
        }
    }
    
    /**
    * Registers a new user with the given username and password, serializes it to a file
    *
    * @param username The username of the new user
    * @param password The password of the new user
    * @throws IOException If there is an error during the file writing process
    */

    public void registerUser(String username, String password) {
        
        User newUser = new User(username, password);
        DataManager dataManager = DataManager.getInstance();
        
        try {
            dataManager.serializeObject(newUser, "users/" + username + ".ser");
            JOptionPane.showMessageDialog(view, "Registration Successful");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(view, "Registration Failed");
            e.printStackTrace();
        }
    }
    
    
    /**
     * Exits the application
     */
    
    public void exit() {
        System.exit(0);
    }
    
    /**
     * Checks if a User is logged in
     * 
     * @return true if a user is logged in, false otherwise
     */
    
    //getter for testing
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}
