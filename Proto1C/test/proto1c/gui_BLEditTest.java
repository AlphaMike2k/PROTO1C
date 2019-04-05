/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto1c;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Josh
 */
public class gui_BLEditTest {
    static manager_userClient uc;
    static mediator mediatorParent;
    static ArrayList<type_TableRow> budgetList;
    static gui_BLEdit blEdit;
    
    public gui_BLEditTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        uc = new manager_userClient(mediatorParent);
    }
    
    @Before
    public void setUp() {
        blEdit = new gui_BLEdit(uc);
        budgetList = new ArrayList<type_TableRow>();
    }

    /**
     * Test of loadList method, of class gui_BLEdit.
     */
    @Test
    public void testLoadList() {
        System.out.println("loadList");
        budgetList.add(new type_TableRow("Item1",50.0,0));
        blEdit.loadList(budgetList);
        assertTrue(blEdit.getUserBudgetList().getValueAt(0, 0).toString() != null);
        assertEquals("0",blEdit.getUserBudgetList().getValueAt(0, 0).toString());
        
    }

    /**
     * Test of clearBoxes method, of class gui_BLEdit.
     */
    @Test
    public void testClearBoxes() {
        System.out.println("clearBoxes");
        blEdit.setTxtItemName("TestItem");
        blEdit.setTxtPrice("1020");
        blEdit.setTxtPriority("7");
        
        assertEquals("TestItem",blEdit.getTxtItemName());
        blEdit.clearBoxes();
        assertEquals("",blEdit.getTxtItemName());
    }
    
}
