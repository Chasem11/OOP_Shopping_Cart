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
import com.mycompany.snackies.UserController;
import com.mycompany.snackies.UserLoginView;
import com.mycompany.snackies.User;
import com.mycompany.snackies.DataManager;
import java.io.IOException;
import java.io.File;

/**
 *
 * @author chase
 */

public class UserControllerTest {
    
    private UserController controller;
    private User user;
    private UserLoginView view;
    private DataManager dataManager;
    private final String testUsername = "testUser";
    private final String testPassword = "testPassword";
    private final String testFilePath = "users/testUser.ser";

    @Before
    public void setUp() throws IOException {
        user = new User(testUsername, testPassword);
        view = new UserLoginView();
        dataManager = DataManager.getInstance();
        controller = new UserController(null);
        controller.setView(view);
        dataManager.serializeObject(user, testFilePath);
    }
    
    @After
    public void tearDown() {
        new File(testFilePath).delete();
    }

    @Test
    public void successfulLoginTest() {
        controller.login(testUsername, testPassword);
        assertTrue(controller.isLoggedIn());
    }

    @Test
    public void failedLoginTest() {
        controller.login("wrongUser", "wrongPassword");
        assertFalse(controller.isLoggedIn());
    }
}
