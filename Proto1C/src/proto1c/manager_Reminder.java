package proto1c;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;
import java.util.*;
import java.text.SimpleDateFormat;
import static proto1c.Proto1C.conn;


/**
 **Class that adds a new reminder.
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
    private Connection dbConnection = null;

    public manager_Reminder(mediator mediator, Connection conn) {
	        mediatorParent = mediator;
	        dbConnection = conn;
	    }

    /**
         *
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
     * @return
     */
    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
    
    /**
             * Method that returns the day that the reminder is set.
             @return Returns remnderDay.
             */
    public int getReminderDay() {
        return reminderDay;
    }

    /**
         * Method that returns the month that the reminder is set.
         @return Returns reminderMonth.
         */
    public int getReminderMonth() {
        return reminderMonth;
    }

    /**
         * Method that returns the year that the reminder is set.
         @return Returns reminderYear.
         */
    public int getReminderYear() {
        return reminderYear;
    }

    /**
         * Method that returns the hour that the reminder is set.
         @return Returns reminderHour.
         */
    public int getReminderHour() {
        return reminderHour;
    }
    
    /**
         * Method that returns the minute that the reminder is set.
         @return Returns reminderMinute.
         */
    public int getReminderMinute() {
        return reminderMinute;
    }
    
    /**
         * Method that returns the name of the reminder.
         @return Returns name.
         */
    public String getReminderName(){
        return reminderName;
    }

    /**
         * Method that returns the location of the reminder.
         @return Returns location.
         */
    public String getLocation(){
        return reminderLocation;
    }

    /**
         * Method that returns the description of the reminder.
         @return Returns description.
         */
    public String getDescription(){
        return reminderDescription;
    }

    /**
         * Method that gets data from the database.
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
         */
    public void insertNewReminder() {
            try {
                Statement statement = null;
                statement = dbConnection.createStatement();
                String sql = "insert into Reminder(RemName, RemDateTime, RemLocation, RemDescription) values "
                        + "('" + getReminderName() + "'," + getReminderDay() + "," + getReminderMonth() + "," + getReminderYear() + getReminderHour() + "," + getReminderMinute() + "," + getLocation() + "," + getDescription() + ");";
                statement.execute(sql);
            }

            catch(SQLException se){
                se.printStackTrace();
            }
        }

    /**
         * Method that removes a reminder.
         */
    public void removeReminder() {
            try {
                Statement statement = null;
                statement = dbConnection.createStatement();
                String sql = "DELETE FROM Reminder WHERE reminderName = " + getReminderName() + "' AND reminderDay = " + getReminderDay() + " AND reminderMonth = " + getReminderMonth()
                        + " AND reminderYear = " + getReminderYear() + "' AND reminderHour = " + getReminderHour() + " AND reminderMinute = " + getReminderMinute()
                        + " AND reminderLocation = " + getLocation() + "' AND reminderHour = " + getReminderHour() + " AND reminderDescription = " + getDescription() + ";";
                statement.execute(sql);
            }

            catch(SQLException se){
                se.printStackTrace();
            }
        }
}
