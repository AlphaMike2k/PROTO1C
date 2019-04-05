/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto1c;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Josh
 */
public class gui_EventeditTest {
    static manager_userClient uc;
    static mediator mediatorParent;
    static gui_Eventedit eveEdit;
    
    public gui_EventeditTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        uc = new manager_userClient(mediatorParent);
    }

    /**
     * Test of loadEvent method, of class gui_Eventedit.
     */
    @Test
    public void testLoadEvent() {
        System.out.println("loadEvent");
        type_TableRow eventToDisplay = new type_TableRow();
        gui_Eventedit instance = null;
        instance.loadEvent(eventToDisplay);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
