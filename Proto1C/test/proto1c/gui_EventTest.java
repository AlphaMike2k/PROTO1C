/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto1c;

import java.sql.Timestamp;
import java.util.ArrayList;
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
public class gui_EventTest {
    static manager_userClient uc;
    static mediator mediatorParent;
    static ArrayList<type_TableRow> eventList;
    static gui_Event eve;
    
    public gui_EventTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        uc = new manager_userClient(mediatorParent);
    }
    
    @Before
    public void setUp() {
        eve = new gui_Event(uc);
        eventList = new ArrayList<type_TableRow>();;
    }

    /**
     * Test of loadList method, of class gui_Event.
     */
    @Test
    public void testLoadList() {
        System.out.println("loadList");
        Timestamp ts = Timestamp.valueOf("2017-03-26 15:00:00");
        eventList.add(new type_TableRow("LoadedEvent","Social",ts));
        eve.loadList(eventList);
        
        assertTrue(eve.getEventList().getValueAt(0, 0).toString() != null);
        assertEquals("LoadedEvent",eve.getEventList().getValueAt(0, 0).toString());
    }
    
}
