package proto1c;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 
 */
public class manager_Event {
    private final mediator mediatorParent;
    private final Connection dbConnection;
    
    
    public manager_Event(mediator mediator, Connection conn) {
        mediatorParent = mediator;
        dbConnection = conn;
    }
    
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
    
        public void insertNewEvent(type_TableRow row) {
        try {
            Statement stmt = null;
            stmt = dbConnection.createStatement();
            String sql = "insert into Event (EveName, EveType, EveDateTime) values ('" + row.getItemName() + "'," + row.getItemCost() + "," + row.getItemPriority() + ");";
            stmt.execute(sql);
        }
        
        catch(SQLException se){
            se.printStackTrace();
        }
    }
    
    public void deleteEvent(type_TableRow row) {
        try {
            Statement stmt = null;
            stmt = dbConnection.createStatement();
            String sql = "DELETE FROM Event WHERE EveName = '" + row.getItemName() + "' AND EveType = " + row.getItemCost() + " AND EveDateTime = " + row.getItemPriority() + ";";
            stmt.execute(sql);
        }
        
            catch(SQLException se){
            se.printStackTrace();
        }
    }
    
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
