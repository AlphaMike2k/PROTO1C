package proto1c;

import java.sql.*;

/**
 * Class that manages all operations and data associated with the budget list
 * @author UP820734
 */
public class manager_BudgetList {
    private mediator mediatorParent = null;
    private final Connection dbConnection;
    
    /**
     * Constructor for tests
     * @param conn The connection to the database
     */
    public manager_BudgetList(Connection conn) {
        dbConnection = conn;
    }
    
    /**
     * Defines parents
     * @param mediator The mediator that created this class
     * @param conn The connection to the database
     */
    public manager_BudgetList(mediator mediator, Connection conn) {
        mediatorParent = mediator;
        dbConnection = conn;
    }
    
    /**
     * Gets whole budget list table from database
     * @return The result set with the database data
     */
    public ResultSet getBudgetList() {
        try{
            Statement st = dbConnection.createStatement();
            ResultSet resultData = st.executeQuery("SELECT * FROM BudgetList;");
            
            return resultData; 
        }
        
        catch(SQLException se){
            se.printStackTrace();
        }
        return null;
    }
    
    /**
     * Inserts a new row into database
     * @param row The row to insert (contains all values for table)
     */
    public void insertNewItem(type_TableRow row) {
        try {
            Statement stmt = null;
            stmt = dbConnection.createStatement();
            String sql = "insert into BudgetList(BudItem, ItemCost, Priority) values ('" + row.getItemName() + "'," + row.getItemCost() + "," + row.getItemPriority() + ");";
            stmt.execute(sql);
        }
        
        catch(SQLException se){
            se.printStackTrace();
        }
    }
    
    /**
     * Removes row from database
     * @param row The row to delete (contains all values for table)
     */
    public void deleteItem(type_TableRow row) {
        try {
            Statement stmt = null;
            stmt = dbConnection.createStatement();
            String sql = "DELETE FROM BudgetList WHERE BudItem = '" + row.getItemName() + "' AND ItemCost = " + row.getItemCost() + " AND Priority = " + row.getItemPriority() + ";";
            stmt.execute(sql);
        }
        
        catch(SQLException se){
            se.printStackTrace();
        }
    }
    
    /**
     * Updates a value in the database
     * @param row The row to update (old and new values)
     */
    public void updateItem (type_TableRow row) {
        try {
            Statement stmt = null;
            stmt = dbConnection.createStatement();
            String sql = "UPDATE BudgetList Set BudItem = '" + row.getNewItemName() + "' , ItemCost = " + row.getNewItemCost() + " , Priority = " + row.getNewItemPriority() + " WHERE BudItem = '" + row.getItemName() + "' AND ItemCost = " + row.getItemCost() + " AND Priority = " + row.getItemPriority() + ";";
            stmt.execute(sql);
        }
        
        catch(SQLException se){
            se.printStackTrace();
        }
    }
    
    
}
