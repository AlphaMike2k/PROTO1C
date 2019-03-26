package proto1c;
import java.util.*;

/**
 *
 * @author Josh
 */
public class manager_userClient {
    private gui_Main mainInterface = new gui_Main(this);
    private mediator mediatorParent;
    
    public manager_userClient(mediator mediator) {
        mediatorParent = mediator;
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
    
    public void nextMonth() {
        mediatorParent.buttonPressed("guiMainNext");
    }
    
    public void prevMonth() {
        mediatorParent.buttonPressed("guiMainPrev");
    }
    
    public void displayAlert() {
        
    }
}
