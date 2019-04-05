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
import java.sql.Timestamp;
import static proto1c.manager_BudgetListTest.conn;

/**
 *
 * @author Josh
 */
public class manager_EventTest {
    static String connectionString;
    static Connection conn;
    static Statement statement;
    
    public manager_EventTest() {
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
     * Test of getEvents method, of class manager_Event.
     */
    @Test
    public void testGetEvents() {
        System.out.println("getEvents");
        manager_Event me = new manager_Event(conn);
        ResultSet result = me.getEvents();
        try {
            assertEquals(true,result.next());
        }
        
        catch(Exception e){
                e.printStackTrace();
            }
    }
    
    /**
     * Test of insertNewEvent method, of class manager_Event.
     */
    @Test
    public void testInsertNewEvent() {
        System.out.println("insertNewEvent");
        manager_Event me = new manager_Event(conn);
        Timestamp ts = Timestamp.valueOf("2019-04-26 15:00:00");
        type_TableRow row = new type_TableRow("JustInserted","Social",ts);
        me.insertNewEvent(row);
        ResultSet result = me.getEvents();
        try {
            while (result.next()) {
                if (result.getString("EveName").equals("JustInserted")) {
                    assertEquals("JustInserted", result.getString("EveName"));
                    break;
                }
                
            }
        }
        
        catch(Exception e){
                e.printStackTrace();
            }
    }

    /**
     * Test of deleteEvent method, of class manager_Event.
     */
    @Test
    public void testDeleteEvent() {
        System.out.println("deleteEvent");
        manager_Event me = new manager_Event(conn);
        Timestamp ts = Timestamp.valueOf("2019-04-26 15:00:00");
        type_TableRow row = new type_TableRow("JustInserted","Social",ts);
        me.insertNewEvent(row);
        me.deleteEvent(row);
        ResultSet result = me.getEvents();
        try {
            while (result.next()) {
                if (result.getString("EveName").equals("JustInserted")) {
                    assertFalse(result.getString("EveName").equals("JustInserted"));
                }
            }
        }
        
        catch(Exception e){
                e.printStackTrace();
            }
    }

    /**
     * Test of updateEvent method, of class manager_Event.
     */
    @Test
    public void testUpdateEvent() {
        System.out.println("updateEvent");
        manager_Event me = new manager_Event(conn);
        Timestamp ts = Timestamp.valueOf("2019-04-26 15:00:00");
        Timestamp ts2 = Timestamp.valueOf("2020-05-30 08:00:00");
        type_TableRow row = new type_TableRow("JustInserted","Social",ts);
        me.insertNewEvent(row);
        
        row = new type_TableRow("JustInserted","Social",ts,"NowUpdated","Lecture",ts2);
        me.updateEvent(row);
        ResultSet result = me.getEvents();
        try {
            while (result.next()) {
                    assertFalse(result.getString("EveName").equals("JustInserted"));
            }
        }
        
        catch(Exception e){
                e.printStackTrace();
            }
    }
    
}
