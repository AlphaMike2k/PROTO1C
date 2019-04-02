/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto1c;

/**
 **Class that returns the monthly, weekly and daily budget.
 **@author UP875166
 */
public class manager_Budget {
    private double budget;
    private double expense;

/**
     *
     * @param budget The budget of the user.
     * @param expense The expenses of the user.
     */
public void manager_Budget(double monthlyBudget, double monthlyExpense){
    monthlyBudget = budget;
    monthlyExpense = expense;
}

/**
     * Method that returns the budget.
     @return Returns budget.
     */
public double getBudget(double budget){
    return budget;
}

/**
     * Method that changes the budget value according to the user.
     */
public void setBudget(double newBudget){
    budget = newBudget;
}

/**
     * Method that subtracts the expenses from the budget and updates it.
     */
public void enterExpense(double expense){
    budget -= expense;
}

/**
     * Method that returns the weekly budget.
     @return Returns weeklyBudget.
     */
public double getWeeklyBudget(double weeklyBudget){
    return weeklyBudget = budget/4;
}

/**
     * Method that calculates the yearly and daily budget and returns the daily one.
     @return Returns dailyBudget.
     */
public double getDailyBudget(double dailyBudget){
    int yearlyBudget = (int) (budget * 12);
    return dailyBudget = yearlyBudget/365;
}

}
