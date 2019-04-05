package proto1c;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class to control task data and operations
 * @author UP820734
 */
public class manager_Task {
    private mediator mediatorParent = null;
    private final Connection dbConnection;
    
    /**
     * Constructor for testing
     * @param conn 
     */
    public manager_Task(Connection conn) {
        dbConnection = conn;
    }
    
    /**
     * Creates parents
     * @param mediator The mediator that creates class
     * @param conn The connection to the database
     */
    public manager_Task(mediator mediator, Connection conn) {
        mediatorParent = mediator;
        dbConnection = conn;
    }
    
    /**
     * Gets all tasks from database
     * @return A ResulSet with all tasks
     */
    public ResultSet getTasks() {
        try{
            Statement st = dbConnection.createStatement();
            ResultSet resultData = st.executeQuery("SELECT * FROM Task;");
            
            return resultData; 
        }
        
        catch(SQLException se){
            se.printStackTrace();
        }
        return null;
    }
}
