package proto1c;
import java.util.*;

/**
 *
 * @author Josh
 */
public class manager_userClient {
    private gui_Main mainInterface = new gui_Main();
    
    public manager_userClient() {
        
    }
    
    public void changeInterface(String newInterface) {
        switch (newInterface) {
            case "main": 
                mainInterface.setVisible(true);
            default: 
        }
    }
    
    public void displayCalendar(int monthToDisplay, String month, int startDay) {
        mainInterface.setCalendar(monthToDisplay,month,startDay);
    }
    
    public void displayAlert() {
        
    }
}
