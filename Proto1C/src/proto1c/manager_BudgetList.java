package proto1c;

import java.sql.*;

/**
 *
 * @author UP820734
 */
public class manager_BudgetList {
    private final mediator mediatorParent;
    private final Connection dbConnection;
    
    public manager_BudgetList(mediator mediator, Connection conn) {
        mediatorParent = mediator;
        dbConnection = conn;
    }
    
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
}
