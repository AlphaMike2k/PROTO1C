/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto1c;

import java.sql.DriverManager;
import java.sql.ResultSet;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static proto1c.Proto1C.dbLocation;
import java.sql.*;

/**
 *
 * @author Josh
 */
public class manager_BudgetTest {
    static String connectionString;
    static Connection conn;
    static Statement statement;
    
    public manager_BudgetTest() {
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
     * Test of getBudget method, of class manager_Budget.
     */
    @Test
    public void testGetBudget() { 
        System.out.println("getBudget");
        manager_Budget mb = new manager_Budget(conn);
        ResultSet result = mb.getBudget();
        try {
            assertEquals(true,result.next());
        }
        
        catch(Exception e){
                e.printStackTrace();
            }
    }

    /**
     * Test of updateBudget method, of class manager_Budget.
     */
    @Test
    public void testUpdateBudget() {
        System.out.println("updateBudget");
        type_TableRow row = new type_TableRow(1234.5);
        manager_Budget mb = new manager_Budget(conn);
        mb.updateBudget(row);
        assertEquals("1234.5", mb.getBudget().toString());
    }
    
}
