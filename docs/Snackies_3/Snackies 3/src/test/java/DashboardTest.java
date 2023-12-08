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
import com.mycompany.snackies.Dashboard;

/**
 *
 * @author chase
 */

public class DashboardTest {

    private Dashboard dashboard;
    
    @Before
    public void setUp() {
        dashboard = new Dashboard();
    }
   
    @Test
    public void testQtyIsZeroWithZeroQuantity() {
        assertFalse("Should return false for zero quantity", dashboard.qtyIsZero(0));
    }

    @Test
    public void testQtyIsZeroWithNonZeroQuantity() {
        assertTrue("Should return true for non-zero quantity", dashboard.qtyIsZero(5));
    }
    
    @Test
    public void testTextFieldTax() {
        assertEquals("Tax field should show '0.0'", "0.0", dashboard.getTextFieldTaxText());
    }

    @Test
    public void testTextFieldTotal() {
        assertEquals("Total field should show '0.0'", "0.0", dashboard.getTextFieldTotalText());
    }
    
    @Test
    public void testReset() {
        dashboard.reset();
        assertEquals("Spinner1 should be reset to 0", 0, dashboard.getSpinner1Value());
        assertEquals("Spinner2 should be reset to 0", 0, dashboard.getSpinner2Value());
        assertEquals("Spinner3 should be reset to 0", 0, dashboard.getSpinner3Value());
        assertEquals("Spinner4 should be reset to 0", 0, dashboard.getSpinner4Value());
        assertEquals("Spinner5 should be reset to 0", 0, dashboard.getSpinner5Value());
        assertEquals("Spinner6 should be reset to 0", 0, dashboard.getSpinner6Value());
        assertEquals("Spinner7 should be reset to 0", 0, dashboard.getSpinner7Value());
        assertEquals("Spinner8 should be reset to 0", 0, dashboard.getSpinner8Value());
        assertEquals("Tax field should be reset to '0.0'", "0.00", dashboard.getTextFieldTaxText());
        assertEquals("Total field should be reset to '0.0'", "0.00", dashboard.getTextFieldTotalText());
    }
    
    
}