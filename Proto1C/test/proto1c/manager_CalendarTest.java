/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto1c;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Josh
 */
public class manager_CalendarTest {
    
    public manager_CalendarTest() {
    }
    

    /**
     * Test of getNumDays method, of class manager_Calendar.
     */
    @Test
    public void testGetNumDays() {
        System.out.println("getNumDays");
        int month = 4;
        manager_Calendar mc = new manager_Calendar();
        int result = mc.getNumDays(month);
        assertEquals(30, result);
        
        assertEquals(31,mc.getNumDays(3));
    }

    /**
     * Test of getFirstDay method, of class manager_Calendar.
     */
    @Test
    public void testGetFirstDay() {
        System.out.println("getFirstDay");
        int month = 3;
        int year = 2019;
        manager_Calendar mc = new manager_Calendar();
        int result = mc.getFirstDay(month, year);
        assertEquals(5, result);
    }

    /**
     * Test of getMonth method, of class manager_Calendar.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        int month = 4;
        manager_Calendar mc = new manager_Calendar();
        String expResult = "APRIL";
        String result = mc.getMonth(month);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentMonth method, of class manager_Calendar.
     */
    @Test
    public void testGetCurrentMonth() {
        System.out.println("getCurrentMonth");
        manager_Calendar mc = new manager_Calendar();
        int expResult = 4;
        int result = mc.getCurrentMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentYear method, of class manager_Calendar.
     */
    @Test
    public void testGetCurrentYear() {
        System.out.println("getCurrentYear");
        manager_Calendar mc = new manager_Calendar();
        int expResult = 2019;
        int result = mc.getCurrentYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGuiMonth method, of class manager_Calendar.
     */
    @Test
    public void testSetGuiMonth() {
        System.out.println("setGuiMonth");
        int guiMonth = 8;
         manager_Calendar mc = new manager_Calendar();
        mc.setGuiMonth(guiMonth);
        assertEquals(8,mc.getGuiMonth());
        
         mc.setGuiMonth(13);
         assertEquals(2020,mc.getGuiYear());
         
         mc.setGuiMonth(-2);
         assertEquals(2019,mc.getGuiYear());
    }
}
