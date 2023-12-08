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
import com.mycompany.snackies.DataManager;
import java.io.File;

/**
 *
 * @author chase
 */

public class DataManagerTest {
    
    private DataManager dataManager;
    private final String testFilePath = "users/testUser.ser";
    private User testUser;

    @Before
    public void setUp() {
        dataManager = DataManager.getInstance();
        testUser = new User("testUser", "testPassword");
    }

    @After
    public void tearDown() {
        File testFile = new File(testFilePath);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    public void testSerialization() throws Exception {
        dataManager.serializeObject(testUser, testFilePath);
        File testFile = new File(testFilePath);
        assertTrue(testFile.exists());
    }

    @Test
    public void testDeserialization() throws Exception {
        dataManager.serializeObject(testUser, testFilePath);
        User deserializedUser = (User) dataManager.deserializeObject(testFilePath);
        assertNotNull(deserializedUser);
    }
}
