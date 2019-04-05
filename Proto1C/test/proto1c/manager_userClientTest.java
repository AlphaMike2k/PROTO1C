/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto1c;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Josh
 */
public class manager_userClientTest {
    static mediator mediatorParent;
    static manager_userClient uc;
    gui_Main mainInterface = new gui_Main(uc);
    gui_BudgetList budgetList = new gui_BudgetList(uc);
    
    public manager_userClientTest() {
    }
    
    @Before
    public void setUp() {
         uc = new manager_userClient(mediatorParent);
    }
   

    /**
     * Test of changeInterface method, of class manager_userClient.
     */
    @Test
    public void testChangeInterface() {
        System.out.println("changeInterface");
        uc.changeInterface("guiMain");
        assertFalse(mainInterface.isVisible());
    }

    /**
     * Test of back method, of class manager_userClient.
     */
    @Ignore
    @Test
    public void testBack() {
        System.out.println("back");
        uc.back();
        
        assertTrue(mainInterface.isVisible());
    }
    
}
