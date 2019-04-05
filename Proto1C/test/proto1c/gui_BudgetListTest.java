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
public class gui_BudgetListTest {
    static manager_userClient uc;
    static mediator mediatorParent;
    static ArrayList<type_TableRow> budgetList;
    static gui_BudgetList bl;
    
    @BeforeClass
    public static void setUpClass() {
        uc = new manager_userClient(mediatorParent);

    }
    
    @Before
    public void setUp() {
        bl = new gui_BudgetList(uc);
        budgetList = new ArrayList<type_TableRow>();
    }

    /**
     * Test of loadList method, of class gui_BudgetList.
     */
    @Test
    public void testLoadList() {
        budgetList.add(new type_TableRow("Item1",50.0,0));
        bl.loadList(budgetList);
        assertTrue(bl.getUserBudgetList().getValueAt(0, 0).toString() != null);
        assertEquals("0",bl.getUserBudgetList().getValueAt(0, 0).toString());
    }

    /**
     * Test of clearBoxes method, of class gui_BudgetList.
     */
    @Test
    public void testClearBoxes() {
        bl.setTxtItemName("TestItem");
        bl.setTxtPrice("1020");
        bl.setTxtPriority("7");
        
        assertEquals("TestItem",bl.getTxtItemName());
        bl.clearBoxes();
        assertEquals("",bl.getTxtItemName());
    }

    
}
