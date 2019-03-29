/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto1c;

/**
 *
 * @author UP875166
 */
public class manager_Budget {
    private double budget;
    private double expense;
    
    
public manager_Budget(double monthlyBudget, double monthlyExpense){
    monthlyBudget = budget;
    monthlyExpense = expense;
}    

public double getBudget(double budget){
    return budget;
}

public void setBudget(double newBudget){
    budget = newBudget;
}

public void enterExpense(double expense){
    budget -= expense;
}

public double getWeeklyBudget(double weeklyBudget){
    return weeklyBudget = budget/4;
}

public double getDailyBudget(double dailyBudget){
    int yearlyBudget = (int) (budget * 12);
    return dailyBudget = yearlyBudget/365;
}

}

