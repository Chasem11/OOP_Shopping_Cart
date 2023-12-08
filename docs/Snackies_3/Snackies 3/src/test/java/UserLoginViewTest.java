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
import com.mycompany.snackies.UserLoginView;
import com.mycompany.snackies.UserController;
import com.mycompany.snackies.User;

/**
 *
 * @author chase
 */

public class UserLoginViewTest {
    
    private UserLoginView view;
    private UserController controller;

    @Before
    public void setUp() {
        controller = new UserController(new User("test", "test"));
        view = new UserLoginView();
        view.setController(controller);
    }

    @Test
    public void testInitialFields() {
        assertEquals("", view.getUsernameField());
        assertEquals("", view.getPasswordField());
    }

    @Test
    public void clearFieldsTest() {
        view.clearFields();
        assertEquals("", view.getUsernameField());
        assertEquals("", view.getPasswordField());
    }

}
