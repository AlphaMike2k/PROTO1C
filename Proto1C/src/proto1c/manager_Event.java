package proto1c;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  Class that controls operations and data relating to events
 * @author 848130
 */
public class manager_Event {
    private mediator mediatorParent = null;
    private final Connection dbConnection;
    
    /**
     * Constructor for testing
     * @param conn The connection to the database
     */
    public manager_Event(Connection conn) {
        dbConnection = conn;
    }
    
    /**
     * Creates connection to parents
     * @param mediator The mediator parent that creates class
     * @param conn The connection to the database
     */
    public manager_Event(mediator mediator, Connection conn) {
        mediatorParent = mediator;
        dbConnection = conn;
    }
    
    /**
     * Gets the events table from database
     * @return ResultSet containing all the events
     */
    public ResultSet getEvents() {
        try{
            Statement st = dbConnection.createStatement();
            ResultSet resultData = st.executeQuery("SELECT * FROM Event;");
            
            return resultData; 
        }
        
        catch(SQLException se){
            se.printStackTrace();
        }
        return null;
    }
        /**
         * Inserts new row in database
         * @param row The row to insert (contains values needed)
         */
        public void insertNewEvent(type_TableRow row) {
        try {
            Statement stmt = null;
            stmt = dbConnection.createStatement();
            String sql = "insert into Event (EveName, EveType, EveDateTime) values ('" + row.getEventName() + "' , '" + row.getEventType() + "' , '" + row.getEventDateTime() + "');";
            stmt.execute(sql);
        }
        
        catch(SQLException se){
            se.printStackTrace();
        }
    }
    
        /**
         * Deletes event from database
         * @param row The row to delete
         */
    public void deleteEvent(type_TableRow row) {
        try {
            Statement stmt = null;
            stmt = dbConnection.createStatement();
            String sql = "DELETE FROM Event WHERE EveName = '" + row.getEventName() + "' AND EveType = '" + row.getEventType() + "' AND EveDateTime = '" + row.getEventDateTime() + "';";
            stmt.execute(sql);
        }
        
            catch(SQLException se){
            se.printStackTrace();
        }
    }
    
        /**
         * Updates event in database
         * @param row The row to update (contains both old and new values)
         */
     public void updateEvent (type_TableRow row) {
        try {
            Statement stmt = null;
            stmt = dbConnection.createStatement();
            String sql = "UPDATE Event Set EveName = '" + row.getEventName()+ "' , EveType = '" + row.getEventType() + "' , EveDateTime = '" + row.getEventDateTime() + "' WHERE EveName = '" + row.getOldEventName() + "' AND EveType = '" + row.getOldEventType() + "' AND EveDateTime = '" + row.getOldEventDateTime() + "';";
            stmt.execute(sql);
        }
        
        catch(SQLException se){
            se.printStackTrace();
        }
    }
    
    
}
