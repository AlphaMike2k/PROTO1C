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
}
