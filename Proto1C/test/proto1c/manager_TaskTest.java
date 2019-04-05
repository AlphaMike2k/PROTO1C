/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class manager_TaskTest {
    static String connectionString;
    static Connection conn;
    static Statement statement;
    
    public manager_TaskTest() {
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
     * Test of getTasks method, of class manager_Task.
     */
    @Test
    public void testGetTasks() {
       System.out.println("getTasks");
        manager_Task me = new manager_Task(conn);
        ResultSet result = me.getTasks();
        try {
            assertEquals(true,result.next());
        }
        
        catch(Exception e){
                e.printStackTrace();
            }
    }
    
}
