package proto1c;
import java.sql.*;
import java.io.*;

/**
 *
 * @author UP820734
 * @author -
 * 
 */
public class Proto1C {
    static final String dbLocation = System.getProperty("user.dir") + "\\Proto1C.mdb";
    static Connection conn = null;
    /**
     * Main class that creates database if it doesn't exist.
     * Creates and starts the mediator which controls everything.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connectDatabase();
        
        mediator mediator = new mediator(conn);
        mediator.startMediator();
    }
    
    /**
     * Checks if database exists and creates it if false.
     * Uses ucanaccess: http://ucanaccess.sourceforge.net/site.html#home
     * @exception Exception upon any error
     */
    private static void connectDatabase() {
        File tmpFile = new File(dbLocation);
        
        if (tmpFile.exists() == false) {
            String connectionString = "jdbc:ucanaccess://" + dbLocation + ";newDatabaseVersion=V2010";
        
            try{
                conn = DriverManager.getConnection(connectionString);
                createTables(conn);
                insertData(conn);
            }

            catch(Exception e){
                e.printStackTrace();
            }
        }
        else {
            try {
                conn = DriverManager.getConnection("jdbc:ucanaccess://" + dbLocation + ";");
            }
            
             catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    /**
     * The DDL to create the tables in the database
     * @param conn the connection to the database
     * @exception SQLException upon any errors with the SQL
     */
    private static void createTables(Connection conn) {
        Statement stmt = null;
        
                try {
            stmt = conn.createStatement();
            
            stmt.execute("create table Event(EveID AUTOINCREMENT PRIMARY KEY, EveName char(30) not null,EveType char(30) not null,EveDateTime DateTime not null);");
            
            stmt.execute("create table Reminder(RemID AUTOINCREMENT PRIMARY KEY,RemName char(30) not null, RemDateTime DateTime not null);");
            
            stmt.execute("create table Task(TaskID AUTOINCREMENT PRIMARY KEY, TaskName char(30) not null, TaskDateTime DateTime not null, TaskCompleted INTEGER NOT NULL);");
            
            stmt.execute("create table Budget(CurrentBudget Float);");
            
            stmt.execute("create table BudgetList(BudID AUTOINCREMENT PRIMARY KEY, BudItem char(30) NOT NULL, ItemCost Float NOT NULL, Priority INTEGER NOT NULL);");
            
            stmt.execute("create table Login(UserName char(30), Password char(30));");
            
        }
        
        catch(SQLException se){
                se.printStackTrace();
            }
    }
    
    /**
     * Inserts dummy data into the database
     * @param conn the connection to the database
     */
    private static void insertData(Connection conn) {
        Statement stmt = null;
        
        try {
            stmt = conn.createStatement();
            
            stmt.execute("insert into Event(EveName, EveType, EveDateTime) values ('Basketball', 'Social', '2019-03-28 10:00:00');");
            stmt.execute("insert into Event(EveName, EveType, EveDateTime) values ('Basketball2', 'Social', '2019-03-28 10:00:00');");
            
            stmt.execute("insert into Reminder(RemName, RemDateTime) values ('Test', '2019-03-28 10:00:00');");
            stmt.execute("insert into Reminder(RemName, RemDateTime) values ('Test2', '2019-03-28 10:00:00');");
            
            stmt.execute("insert into Task(TaskName, TaskDateTime, TaskCompleted) values ('Shopping', '2019-03-28 10:00:00', 0);");
            stmt.execute("insert into Task(TaskName, TaskDateTime, TaskCompleted) values ('Shopping2', '2019-03-28 10:00:00', 0);");
            
            stmt.execute("insert into Budget(CurrentBudget) values (0.00);");
            
            stmt.execute("insert into BudgetList(BudItem, ItemCost, Priority) values ('Item1', 20.00, 1);");
            stmt.execute("insert into BudgetList(BudItem, ItemCost, Priority) values ('Item2', 40.50, 2);");
        }
        
        catch(SQLException se){
                se.printStackTrace();
            }
        
    }
}
