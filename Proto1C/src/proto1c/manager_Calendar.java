package proto1c;
import java.util.Calendar;
/**
 *
 * @author Josh
 */
public class manager_Calendar {
    private static Calendar calendar = Calendar.getInstance();
    private int day;
    private int month;
    private int year;
    
    public manager_Calendar() {
    day = calendar.get(Calendar.DATE);
    month = calendar.get(Calendar.MONTH);
    year = calendar.get(Calendar.YEAR);
    
    //System.out.println(calendar.getTime());
    //System.out.println("Here:" + " " + day + " " + (month +1) + " " + year);
    }
}
