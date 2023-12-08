/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snackies;
import java.io.*;

/**
 *
 * @author chase
 */

public class DataManager {
    
    private static DataManager instance;

    /**
     * Private constructor for Singleton pattern
     */
     
    private DataManager() {}

    /**
     * Returns the single instance of DataManager.
     * 
     * @return The singleton instance of DataManager
     */
    
    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    /**
     * Serializes an object to a file.
     *
     * @param obj  The object to serialize.
     * @param path The file path to serialize the object to.
     * @throws IOException If an I/O error occurs during serialization.
     */
    
    public void serializeObject(Object obj, String path) throws IOException {
        File file = new File(path);

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(obj);
        }    
    }

    /**
     * Deserializes an object from a file.
     *
     * @param path The file path to deserialize the object from.
     * @return The deserialized object.
     * @throws IOException If an I/O error occurs during deserialization.
     * @throws ClassNotFoundException If the class of the serialized object cannot be found.
     */
    
    public Object deserializeObject(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            return in.readObject();
        }
    }
}