package com.mycompany.snackies;
import java.io.Serializable;
import java.io.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chase
 */

public class User implements Serializable{
    
    private String username;
    private String password;
    
    /**
     * Constructor for a new user instance
     * 
     * @param username  The desired username
     * @param password  The desired password
     */
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**
     * Returns the username for a given user instance
     * 
     * @return The users username
     */
    
    public String getUsername() {
        return username;
    }
    
    /**
     * Returns the password for a given user instance
     * 
     * @return The users password
     */
    
    public String getPassword() {
        return password;
    }
    
    /**
     * Sets the username for a given user instance
     * 
     * @param username The username to be set
     */

    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Sets the password for a given user instance
     * 
     * @param password The password to be set
     */

    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Registers a new User and serializes it to a file
     * 
     * @param username The registered username
     * @param password The registered password
     * @throws IOException If there is an error during serialization
     */
    
    public void registerUser(String username, String password) {
        
        User newUser = new User(username, password);
        DataManager dataManager = DataManager.getInstance();
        
        try {
            dataManager.serializeObject(newUser, "users/" + username + ".ser");
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
