package proto1c;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 **Class that returns the monthly, weekly and daily budget.
 **@author UP875166
 */
public class manager_Budget {
    private mediator mediatorParent = null;
    private Connection dbConnection = null;
    
    /**
     * Constructor for testing
     * @param conn The connection to database
     */
    public manager_Budget(Connection conn) {
        dbConnection = conn;
    }

    /**
     * Controls anything related to the budget
     * @param mediator The parent that created the class
     * @param conn The connection to the database
     */
    public manager_Budget(mediator mediator, Connection conn) {
        mediatorParent = mediator;
        dbConnection = conn;
    }

    /**
         * Method that gets data from the database.
         * @return Returns result containing value from database
         */
    public ResultSet getBudget() {
        try{
            Statement statement = dbConnection.createStatement();
            ResultSet resultData = statement.executeQuery("SELECT * FROM Budget;");

            return resultData;
        }

        catch(SQLException se){
            se.printStackTrace();
        }
        return null;
    }

        /**
         * Method that updates the budget.
         * @param row The double value representing the price
         */
    public void updateBudget(type_TableRow row) {
            try {
                Statement statement = null;
                statement = dbConnection.createStatement();
                String sql = "UPDATE Budget Set CurrentBudget = " + row.getNewBudget() + "WHERE CurrentBudget = " + row.getNewBudget() + ";";
                statement.execute(sql);
            }

            catch(SQLException se){
                se.printStackTrace();
            }
        }
}
