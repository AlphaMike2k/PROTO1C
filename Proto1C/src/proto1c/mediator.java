package proto1c;

/**
 *
 * @author Josh
 */
public class mediator {
    private manager_Calendar calendarManager;
    private manager_userClient userClient;
    private manager_Reminder reminderManager;
    private manager_Task taskManager;
    private manager_Budget budgetManager;
    private manager_BudgetList budgetList;
    
    public mediator(manager_Calendar calMan, manager_userClient userCli, manager_Reminder remindMan, manager_Task taskMan, manager_Budget budgMan, manager_BudgetList budList) {
        calendarManager = calMan;
        userClient = userCli;
        reminderManager = remindMan;
        taskManager = taskMan;
        budgetManager = budgMan;
        budgetList = budList;
    }
    
    public void startMediator() {
        
    }
}
