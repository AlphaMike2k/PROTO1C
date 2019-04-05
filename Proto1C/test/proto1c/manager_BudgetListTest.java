package proto1c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static proto1c.Proto1C.dbLocation;

/**
 *
 * @author Josh
 */
public class manager_BudgetListTest {
    static String connectionString;
    static Connection conn;
    static Statement statement;
    
    public manager_BudgetListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        try {
           connectionString = "jdbc:ucanaccess://" + dbLocation + ";newDatabaseVersion=V2010";
           conn = DriverManager.getConnection(connectionString);
       }
       
       catch(Exception e){
                e.printStackTrace();
            }
    }
    
    @AfterClass
    public static void tearDownClass() {
        try {
           conn.close(); 
        }
        
        catch(Exception e){
                e.printStackTrace();
            }
    }

    /**
     * Test of getBudgetList method, of class manager_BudgetList.
     */
    @Test
    public void testGetBudgetList() {
        System.out.println("getBudgetList");
        manager_BudgetList mbl = new manager_BudgetList(conn);
        ResultSet result = mbl.getBudgetList();
        try {
            assertEquals(true,result.next());
        }
        
        catch(Exception e){
                e.printStackTrace();
            }
    }

    /**
     * Test of insertNewItem method, of class manager_BudgetList.
     */
    @Test
    public void testInsertNewItem() {
        System.out.println("insertNewItem");
        manager_BudgetList mbl = new manager_BudgetList(conn);
        type_TableRow row = new type_TableRow("JustInserted",50.2,8);
        mbl.insertNewItem(row);
        ResultSet result = mbl.getBudgetList();
        try {
            while (result.next()) {
                if (result.getString("BudItem").equals("JustInserted")) {
                    assertEquals("JustInserted", result.getString("BudItem"));
                    break;
                }
                
            }
        }
        
        catch(Exception e){
                e.printStackTrace();
            }
        
    }

    /**
     * Test of deleteItem method, of class manager_BudgetList.
     */
    @Test
    public void testDeleteItem() {
        System.out.println("deleteItem");
        manager_BudgetList mbl = new manager_BudgetList(conn);
        type_TableRow row = new type_TableRow("JustInserted",50.2,8);
        mbl.insertNewItem(row);
        mbl.deleteItem(row);
        ResultSet result = mbl.getBudgetList();
        try {
            while (result.next()) {
                if (result.getString("BudItem").equals("JustInserted")) {
                    assertFalse(result.getString("BudItem").equals("JustInserted"));
                }
            }
        }
        
        catch(Exception e){
                e.printStackTrace();
            }
    }
    
}
