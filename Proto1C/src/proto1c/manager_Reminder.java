package proto1c;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.text.SimpleDateFormat;
import static proto1c.Proto1C.conn;


/**
 **Class that controls reminders
 **@author UP875166
 */
public class manager_Reminder {
    private String reminderName;
    private int reminderDay;
    private int reminderMonth;
    private int reminderYear;
    private int reminderHour;
    private int reminderMinute;
    private String reminderLocation;
    private String reminderDescription;

    private mediator mediatorParent = null;
    private final Connection dbConnection;
    
    /**
     * Constructor for testing
     * @param conn The connection to database
     */
    public manager_Reminder(Connection conn) {
        dbConnection = conn;
    }
    
    /**
     * Constructor for initial creation
     * @param mediator 
     * @param conn 
     */
    public manager_Reminder(mediator mediator, Connection conn) {
        mediatorParent = mediator;
        dbConnection = conn;
    }
    /**
         * Creates parents and required variables
         * @param name The name of the reminder.
         * @param day The day that the user selects for the reminder.
         * @param month The month that the user selects for the reminder.
         * @param year The year that the user selects for the reminder.
         * @param hour The hour that the user selects for the reminder.
         * @param minute The minute that the user selects for the reminder.
         * @param location The location of the reminder.
         * @param description The description of the reminder.
         */
    public manager_Reminder(String name, int day, int month, int year, int hour, int minute,String location, String description){
        mediator mediator = null;
        mediatorParent = mediator;
        dbConnection = conn;
        name = reminderName;
        day =  reminderDay;
        month = reminderMonth;
        year = reminderYear;
        hour = reminderHour;
        minute =  reminderMinute;
        location = reminderLocation;
        description = reminderDescription;
    }


    /**
     * Method that formats the date and time of the reminder.
     * @return Return string version of current date time
     */
    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
    
    /**
    * Method that returns the day that the reminder is set.
    *@return Returns remnderDay.
    */
    public int getReminderDay() {
        return reminderDay;
    }

    /**
    * Method that returns the month that the reminder is set.
    *@return Returns reminderMonth.
    */
    public int getReminderMonth() {
        return reminderMonth;
    }

    /**
    * Method that returns the year that the reminder is set.
    *@return Returns reminderYear.
    */
    public int getReminderYear() {
        return reminderYear;
    }

    /**
    * Method that returns the hour that the reminder is set.
    *@return Returns reminderHour.
    */
    public int getReminderHour() {
        return reminderHour;
    }
    
    /**
    * Method that returns the minute that the reminder is set.
    *@return Returns reminderMinute.
    */
    public int getReminderMinute() {
        return reminderMinute;
    }
    
    /**
    * Method that returns the name of the reminder.
    *@return Returns name.
    */
    public String getReminderName(){
        return reminderName;
    }

    /**
    * Method that returns the location of the reminder.
    *@return Returns location.
    */
    public String getLocation(){
        return reminderLocation;
    }

    /**
    * Method that returns the description of the reminder.
    *@return Returns description.
    */
    public String getDescription(){
        return reminderDescription;
    }

    /**
    * Method that gets data from the database.
     * @return ResultSet containing all reminders
    */
    public ResultSet getReminders() {
        try{
            Statement statement = dbConnection.createStatement();
            ResultSet resultData = statement.executeQuery("SELECT * FROM Reminder;");

            return resultData;
        }

        catch(SQLException se){
            se.printStackTrace();
        }
        return null;
    }

    /**
    * Method that inserts a new reminder.
    * @param row The row to insert (contains all values required)
    */
    public void insertNewReminder(type_TableRow row) {
            try {
                Statement statement = null;
                statement = dbConnection.createStatement();
                String sql = "insert into Reminder(RemName, RemDateTime, RemLocation, RemDescription) values ('" + row.getRemName() + "' , '" + row.getRemDateTime() + "' , '" + row.getRemLocation() + "' , '" + row.getRemDescription() + "');";
                statement.execute(sql);
            }

            catch(SQLException se){
                se.printStackTrace();
            }
        }

    /**
    * Method that removes a reminder.
    * @param row The row to remove (contains all values required)
    */
    public void removeReminder(type_TableRow row) {
            try {
                Statement statement = null;
                statement = dbConnection.createStatement();
                String sql = "DELETE FROM Reminder WHERE RemName = '" + row.getRemName() + "' AND RemDateTime = '" + row.getRemDateTime() + "' AND RemLocation = '" + row.getRemLocation() + "' AND RemDescription = '" + row.getRemDescription() + "';";
                statement.execute(sql);
            }

            catch(SQLException se){
                se.printStackTrace();
            }
        }
    
    //public void updateReminder(type_TableRow row){
        /*
        try {
                Statement statement = null;
                statement = dbConnection.createStatement();
                String sql = "UPDATE Reminder Set reminderName = "+ row.getRemName() + ", reminderDay = " + row.getRemDay() + " , reminderMonth = " + row.getRemMonth() + " , reminderYear = " + row.getRemYear() + 
                        " , reminderHour = " + row.getRemHour() + " , reminderMinute = " + row.getRemMinute() + " , reminderLocation = " + row.getRemLocation() + " , reminderDescription = " + row.getRemDescription() + 
                        "WHERE reminderName = " + getReminderName() + "' AND reminderDay = " + getReminderDay() + " AND reminderMonth = " + getReminderMonth()
                        + " AND reminderYear = " + getReminderYear() + "' AND reminderHour = " + getReminderHour() + " AND reminderMinute = " + getReminderMinute()
                        + " AND reminderLocation = " + getLocation() +  " AND reminderDescription = " + getDescription() + ";";
                statement.execute(sql);
    }
        catch(SQLException se){
                se.printStackTrace();
            }
    */
    //}
}
