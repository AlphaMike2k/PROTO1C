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
    private final manager_Event eventManager;
        
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
        reminderManager = new manager_Reminder(this,dbConnection);
        taskManager = new manager_Task(this,dbConnection);
        budgetManager = new manager_Budget(this,dbConnection);
        budgetList = new manager_BudgetList(this,dbConnection);
        eventManager = new manager_Event(this,dbConnection);
    }
    
    /**
     * Starts the program by instructing the start up GUI with current date
     */
    public void startMediator() {
        dateToSend = calendarManager.getCurrentDate();
        userClient.changeInterface("guiMain");
        userClient.displayCalendar(calendarManager.getNumDays(calendarManager.getCurrentMonth()),calendarManager.getMonth(calendarManager.getCurrentMonth()),calendarManager.getFirstDay(calendarManager.getCurrentMonth(), calendarManager.getCurrentYear()), calendarManager.getCurrentYear());
        userClient.displayEvents(dateToSend, eventManager.getEvents());
        userClient.displayReminders(dateToSend, reminderManager.getReminders());
        userClient.displayTasks(dateToSend, taskManager.getTasks());
    }
    
    /**
     * Method triggered by user interacting with GUI, passed by GUI parent.
     * Instructs based on which button pressed.
     * @param button the button the user pressed given a string value
     * @param val
     * @param newRow
     */
    public void buttonPressed(String button, int val, type_TableRow newRow) {
        switch (button) {
            case "back":
                userClient.changeInterface("guiMain");
                break;
            case "guiMainNext":
                calendarManager.setGuiMonth(calendarManager.getGuiMonth()+1);
                userClient.displayCalendar(calendarManager.getNumDays(calendarManager.getGuiMonth()),calendarManager.getMonth(calendarManager.getGuiMonth()),calendarManager.getFirstDay(calendarManager.getGuiMonth(), calendarManager.getGuiYear()), calendarManager.getGuiYear());
                break;
            case "guiMainPrev":
                calendarManager.setGuiMonth(calendarManager.getGuiMonth()-1);
                userClient.displayCalendar(calendarManager.getNumDays(calendarManager.getGuiMonth()),calendarManager.getMonth(calendarManager.getGuiMonth()),calendarManager.getFirstDay(calendarManager.getGuiMonth(), calendarManager.getGuiYear()), calendarManager.getGuiYear());
                break;
            case "calendarClicked":
                dateToSend = LocalDate.of(calendarManager.getGuiYear(), calendarManager.getGuiMonth(), val);
                userClient.displayEvents(dateToSend, eventManager.getEvents());
                userClient.displayReminders(dateToSend, reminderManager.getReminders());
                userClient.displayTasks(dateToSend, taskManager.getTasks());
                break;
            case "guiMainSpendingList":
                userClient.changeInterface(button);
                userClient.displaySpendingList(budgetList.getBudgetList());
                break;
            case "guiSpendListAdd":
                budgetList.insertNewItem(newRow);
                userClient.displaySpendingList(budgetList.getBudgetList());
                break;
            case "spendingCheckBox":
                budgetList.deleteItem(newRow);
                userClient.displaySpendingList(budgetList.getBudgetList());
                break;
            case "guiSpendingListEdit":
                userClient.changeInterface(button);
                userClient.displaySpendingListEdit(budgetList.getBudgetList());
                break;
            case "spendingListSave":
                budgetList.updateItem(newRow);
                userClient.displaySpendingListEdit(budgetList.getBudgetList());
                break;
            case "spendingListDelete":
                budgetList.deleteItem(newRow);
                userClient.displaySpendingListEdit(budgetList.getBudgetList());
                break;
            case "guiMainEventScreen":
                userClient.changeInterface(button);
                userClient.showEvents(eventManager.getEvents());
                break;
            case "guiEventEdit":
                userClient.changeInterface(button);
                userClient.showEventEdit(newRow);
                break;
            case "saveEventEdit":
                eventManager.updateEvent(newRow);
                userClient.changeInterface("guiMainEventScreen");
                userClient.showEvents(eventManager.getEvents());
                break;
            case "deleteEvent":
                eventManager.deleteEvent(newRow);
                userClient.showEvents(eventManager.getEvents());
                break;
            case "createEvent":
                userClient.changeInterface(button);
                break;
            case "saveCreateEvent":
                eventManager.insertNewEvent(newRow);
                userClient.changeInterface("guiMainEventScreen");
                break;
            case "remindersAdd":
                reminderManager.insertNewReminder(newRow);
                userClient.changeInterface("showReminders");
                 userClient.showReminderList(reminderManager.getReminders());
                break;
            case "updateBudget":
                userClient.changeInterface("guiBudget");
                budgetManager.updateBudget(newRow);
                break;
            case "showReminders":
                userClient.changeInterface(button);
                userClient.showReminderList(reminderManager.getReminders());
                break;
            case "deleteReminder":
                reminderManager.removeReminder(newRow);
                userClient.showReminderList(reminderManager.getReminders());
                break;
            case "remindersCreate":
                userClient.changeInterface("guiReminder");
                break;
            default:
                userClient.displayAlert("Unknown button");
        }
    }
}
