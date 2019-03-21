/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto1c;

/**
 *
 * @author Josh
 */
public class Proto1C {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        gui_Main screen = new gui_Main();
        screen.setVisible(true);
        
        manager_Calendar calendarManager = new manager_Calendar();
        manager_userClient userClient = new manager_userClient();
        manager_Reminder reminderManager = new manager_Reminder();
        manager_Task taskManager = new manager_Task();
        manager_Budget budgetManager = new manager_Budget();
        manager_BudgetList budgetList = new manager_BudgetList();
        
        mediator mediator = new mediator(calendarManager,userClient, reminderManager, taskManager, budgetManager, budgetList);
        mediator.startMediator();
    }
    
}
