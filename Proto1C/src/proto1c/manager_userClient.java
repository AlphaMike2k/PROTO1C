package proto1c;
import java.util.*;

/**
 *
 * @author UP820734
 */
public class manager_userClient {
    private gui_Main mainInterface = new gui_Main(this);
    private mediator mediatorParent;
    
    /**
     * Creates and controls all the GUIs
     * @param mediator the mediator that created it
     */
    public manager_userClient(mediator mediator) {
        mediatorParent = mediator;
    }
    
    /**
     * Changes the interface the user sees
     * @param newInterface the string equivalent of the interface to change to
     */
    public void changeInterface(String newInterface) {
        switch (newInterface) {
            case "main": 
                mainInterface.setVisible(true);
            default: 
        }
    }
    
    /**
     * Calls to change the calendar in the gui_Main
     * @param monthToDisplay the int value of the month to display
     * @param month the String value of the month to display
     * @param startDay the int value of the day of the week that the month starts on e.g. 1 = Monday
     * @param yearToDisplay the int value of the to display
     */
    public void displayCalendar(int monthToDisplay, String month, int startDay, int yearToDisplay) {
        mainInterface.setCalendar(monthToDisplay,month,startDay,yearToDisplay);
    }
    
    /**
     * Triggers method in mediator that user has pressed 'Next' button on gui_Main calendar
     */
    public void nextMonth() {
        mediatorParent.buttonPressed("guiMainNext");
    }
    
    /**
     * Triggers method in mediator that user has pressed 'Previous' button on gui_Main calendar
     */
    public void prevMonth() {
        mediatorParent.buttonPressed("guiMainPrev");
    }
    
    
    public void displayAlert() {
        
    }
}
