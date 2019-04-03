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



    public manager_Budget(mediator mediator, Connection conn) {
                    mediatorParent = mediator;
                    dbConnection = conn;
    }

    /**
         * Method that gets data from the database.
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
         * @param row
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
