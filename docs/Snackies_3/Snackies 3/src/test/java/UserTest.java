/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.snackies.User;

/**
 *
 * @author chase
 */

public class UserTest {
    
    private User user;

    @Before
    public void setUp() {
        user = new User("testUser", "testPassword");
    }

    @Test
    public void testUsername() {
        assertEquals("testUser", user.getUsername());
    }

    @Test
    public void testPassword() {
        assertEquals("testPassword", user.getPassword());
    }

    @Test
    public void testSetUsername() {
        user.setUsername("newUsername");
        assertEquals("newUsername", user.getUsername());
    }

    @Test
    public void testSetPassword() {
        user.setPassword("newPassword");
        assertEquals("newPassword", user.getPassword());
    }

}
