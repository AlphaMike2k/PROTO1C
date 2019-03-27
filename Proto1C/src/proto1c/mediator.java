package proto1c;
import java.sql.*;
/**
 * @author UP820734
 */
public class mediator {
    private manager_Calendar calendarManager = new manager_Calendar();
    private manager_userClient userClient = new manager_userClient(this);
    private manager_Reminder reminderManager = new manager_Reminder();
    private manager_Task taskManager = new manager_Task();
    private manager_Budget budgetManager = new manager_Budget();
    private manager_BudgetList budgetList = new manager_BudgetList();
    
    private Connection dbConnection;
    
    /**
     * The mediator controls everything but doesn't do calculations
     * @param conn the connection to the database
     */
    public mediator(Connection conn) {
        dbConnection = conn;
    }
    
    /**
     * Starts the program by instructing the start up GUI with current date
     */
    public void startMediator() {
        userClient.changeInterface("main");
        userClient.displayCalendar(calendarManager.getNumDays(calendarManager.getCurrentMonth()),calendarManager.getMonth(calendarManager.getCurrentMonth()),calendarManager.getFirstDay(calendarManager.getCurrentMonth(), calendarManager.getCurrentYear()), calendarManager.getCurrentYear());
    }
    
    /**
     * Method triggered by user interacting with GUI, passed by GUI parent.
     * Instructs based on which button pressed.
     * @param button the button the user pressed given a string value
     */
    public void buttonPressed(String button) {
        switch (button) {
            case "guiMainNext":
                calendarManager.setGuiMonth(calendarManager.getGuiMonth()+1);
                userClient.displayCalendar(calendarManager.getNumDays(calendarManager.getGuiMonth()),calendarManager.getMonth(calendarManager.getGuiMonth()),calendarManager.getFirstDay(calendarManager.getGuiMonth(), calendarManager.getGuiYear()), calendarManager.getGuiYear());
                break;
            case "guiMainPrev":
                calendarManager.setGuiMonth(calendarManager.getGuiMonth()-1);
                userClient.displayCalendar(calendarManager.getNumDays(calendarManager.getGuiMonth()),calendarManager.getMonth(calendarManager.getGuiMonth()),calendarManager.getFirstDay(calendarManager.getGuiMonth(), calendarManager.getGuiYear()), calendarManager.getGuiYear());
                break;
            default: 
        }
    }
}
