package proto1c;
import java.sql.*;
import java.time.*;
/**
 * @author UP820734
 */
public class mediator {
    private final manager_Calendar calendarManager;
    private final manager_userClient userClient;
    private final manager_Reminder reminderManager;
    private final manager_Task taskManager;
    private final manager_Budget budgetManager;
    private final manager_BudgetList budgetList;
    
    private final Connection dbConnection;
    private LocalDate dateToSend;
    /**
     * The mediator controls everything but doesn't do calculations
     * @param conn the connection to the database
     */
    public mediator(Connection conn) {
        dbConnection = conn;
        calendarManager = new manager_Calendar();
        userClient = new manager_userClient(this,dbConnection);
        reminderManager = new manager_Reminder();
        taskManager = new manager_Task();
        budgetManager = new manager_Budget();
        budgetList = new manager_BudgetList();
    }
    
    /**
     * Starts the program by instructing the start up GUI with current date
     */
    public void startMediator() {
        dateToSend = calendarManager.getCurrentDate();
        userClient.changeInterface("main");
        userClient.displayCalendar(calendarManager.getNumDays(calendarManager.getCurrentMonth()),calendarManager.getMonth(calendarManager.getCurrentMonth()),calendarManager.getFirstDay(calendarManager.getCurrentMonth(), calendarManager.getCurrentYear()), calendarManager.getCurrentYear());
        userClient.displayEvents(dateToSend);
        userClient.displayReminders(dateToSend);
        userClient.displayTasks(dateToSend);
    }
    
    /**
     * Method triggered by user interacting with GUI, passed by GUI parent.
     * Instructs based on which button pressed.
     * @param button the button the user pressed given a string value
     * @param day
     */
    public void buttonPressed(String button, int day) {
        switch (button) {
            case "guiMainNext":
                calendarManager.setGuiMonth(calendarManager.getGuiMonth()+1);
                userClient.displayCalendar(calendarManager.getNumDays(calendarManager.getGuiMonth()),calendarManager.getMonth(calendarManager.getGuiMonth()),calendarManager.getFirstDay(calendarManager.getGuiMonth(), calendarManager.getGuiYear()), calendarManager.getGuiYear());
                break;
            case "guiMainPrev":
                calendarManager.setGuiMonth(calendarManager.getGuiMonth()-1);
                userClient.displayCalendar(calendarManager.getNumDays(calendarManager.getGuiMonth()),calendarManager.getMonth(calendarManager.getGuiMonth()),calendarManager.getFirstDay(calendarManager.getGuiMonth(), calendarManager.getGuiYear()), calendarManager.getGuiYear());
                break;
            case "calendarClicked":
                dateToSend = LocalDate.of(calendarManager.getGuiYear(), calendarManager.getGuiMonth(), day);
                userClient.displayEvents(dateToSend);
                userClient.displayReminders(dateToSend);
                userClient.displayTasks(dateToSend);
                break;
            default: 
        }
    }
}
