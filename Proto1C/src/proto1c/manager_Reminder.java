/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto1c;
import java.time.*;
import java.util.*;
import java.text.SimpleDateFormat;

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

    /**
         *
         * @param reminderName The name of the reminder.
         * @param reminderDay The day that the user selects for the reminder.
         * @param reminderMonth The month that the user selects for the reminder.
         * @param reminderYear The year that the user selects for the reminder.
         * @param reminderHour The hour that the user selects for the reminder.
         * @param reminderMinute The minute that the user selects for the reminder.
         * @param reminderLocation The location of the reminder.
         * @param reminderDescription The description of the reminder.
         */
    public void manager_Reminder(String name, int day, int month, int year, int hour, int minute,String location, String description){
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
         */
    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    /**
         * Method that returns the name of the reminder.
         @return Returns name.
         */
    public String getReminderName(String name){
        return name;
    }

    /**
         * Method that returns the location of the reminder.
         @return Returns location.
         */
    public String getLocation(String location){
        return location;
    }

    /**
         * Method that returns the description of the reminder.
         @return Returns description.
         */
    public String getDescription(String description){
        return description;
    }


}
