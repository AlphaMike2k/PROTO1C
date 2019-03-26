package proto1c;

/**
 *
 * @author Josh
 */
public class mediator {
    private manager_Calendar calendarManager = new manager_Calendar();
    private manager_userClient userClient = new manager_userClient(this);
    private manager_Reminder reminderManager = new manager_Reminder();
    private manager_Task taskManager = new manager_Task();
    private manager_Budget budgetManager = new manager_Budget();
    private manager_BudgetList budgetList = new manager_BudgetList();
    
    public mediator() {
    
    }
    
    public void startMediator() {
        userClient.changeInterface("main");
        userClient.displayCalendar(calendarManager.getNumDays(calendarManager.getCurrentMonth()),calendarManager.getMonth(calendarManager.getCurrentMonth()),calendarManager.getFirstDay(calendarManager.getCurrentMonth(), calendarManager.getCurrentYear()));
    }
    
    public void buttonPressed(String button) {
        switch (button) {
            case "guiMainNext":
                calendarManager.setGuiMonth(calendarManager.getGuiMonth()+1);
                userClient.displayCalendar(calendarManager.getNumDays(calendarManager.getGuiMonth()),calendarManager.getMonth(calendarManager.getGuiMonth()),calendarManager.getFirstDay(calendarManager.getGuiMonth(), calendarManager.getCurrentYear()));
                break;
            case "guiMainPrev":
                calendarManager.setGuiMonth(calendarManager.getGuiMonth()-1);
                userClient.displayCalendar(calendarManager.getNumDays(calendarManager.getGuiMonth()),calendarManager.getMonth(calendarManager.getGuiMonth()),calendarManager.getFirstDay(calendarManager.getGuiMonth(), calendarManager.getCurrentYear()));
                break;
            default: 
        }
    }
}
