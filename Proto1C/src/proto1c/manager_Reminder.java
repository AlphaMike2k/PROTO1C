package proto1c;
import java.time.*;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author UP875166
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
public static String getCurrentTimeStamp() {
    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
    Date now = new Date();
    String strDate = sdfDate.format(now);
    return strDate;
}

public String getReminderName(String name){
    return name;
}

public String getLocation(String location){
    return location;
}

public String getDescription(String description){
    return description;
}

}
