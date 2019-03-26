package proto1c;
import java.time.*;
import java.util.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author Josh
 */
public class manager_Calendar {
    private static Calendar currentCalendar = Calendar.getInstance();
    private static Calendar modCalendar = Calendar.getInstance();
    private int guiMonth;
    private int currentDay;
    private int currentMonth;
    private int currentYear;
    private SimpleDateFormat dayFormat = new SimpleDateFormat("u",Locale.getDefault());
    
    public manager_Calendar() {
    currentDay = currentCalendar.get(Calendar.DATE);
    currentMonth = currentCalendar.get(Calendar.MONTH) +1;
    currentYear = currentCalendar.get(Calendar.YEAR);
    guiMonth = currentMonth;
    
    //System.out.println(currentCalendar.getTime());
    //System.out.println(currentCalendar.get(Calendar.DATE));
    //System.out.println(currentCalendar.get(Calendar.DAY_OF_WEEK));
    //System.out.println("Here:" + " " + day + " " + (month +1) + " " + year);
    //System.out.print(yearMonth);
    //System.out.print(yearMonth.lengthOfMonth());
    //System.out.println(currentDay);
    //System.out.println(currentMonth);
    //System.out.println(currentYear);
    }
    
    public int getNumDays(int month) {
        YearMonth yearMonth = YearMonth.of(currentYear, month);
        return yearMonth.lengthOfMonth();
    }
    
    public int getFirstDay (int month, int year) {
        modCalendar.set(year, month -1, 1);
        //System.out.println(dayFormat.format(modCalendar.getTime()));
        return Integer.valueOf(dayFormat.format(modCalendar.getTime()));
    }
    
    public String getMonth(int month) {
        return Month.of(month).name();
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public int getCurrentMonth() {
        return currentMonth;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public int getGuiMonth() {
        //System.out.println(guiMonth);
        return guiMonth;
    }

    public void setGuiMonth(int guiMonth) {
        this.guiMonth = guiMonth;
        //System.out.println(guiMonth);
    }
    
    
    
}
