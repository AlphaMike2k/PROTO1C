/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto1c;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Josh
 */
public class mediatorTest {
    
    public mediatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of startMediator method, of class mediator.
     */
    @Test
    public void testStartMediator() {
        System.out.println("startMediator");
        mediator instance = null;
        instance.startMediator();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buttonPressed method, of class mediator.
     */
    @Test
    public void testButtonPressed() {
        System.out.println("buttonPressed");
        String button = "";
        int val = 0;
        type_TableRow newRow = null;
        mediator instance = null;
        instance.buttonPressed(button, val, newRow);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
