package proto1c;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import static proto1c.Proto1C.conn;

/**
 **Class that returns the monthly, weekly and daily budget.
 **@author UP875166
 */
public class manager_Budget {
    private double budget;
    private double expense;
    private mediator mediatorParent = null;
    private Connection dbConnection = null;

    /**
         *
         * @param budget The budget of the user.
         * @param expense The expenses of the user.
         */
    public void manager_Budget(double monthlyBudget, double monthlyExpense){
        monthlyBudget = budget;
        monthlyExpense = expense;
    }

    public manager_Budget(mediator mediator, Connection conn) {
                    mediatorParent = mediator;
                    dbConnection = conn;
    }

    /**
         * Method that returns the budget.
         @return Returns budget.
         */
    public double getBudget(){
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

    /**
         * Method that gets data from the database.
         */
    public ResultSet getReminders() {
        try{
            Statement statement = dbConnection.createStatement();
            ResultSet resultData = statement.executeQuery("SELECT * FROM Budget;");

            return resultData;
        }

        catch(SQLException se){
            se.printStackTrace();
        }
        return null;
    }

        /**
         * Method that updates the budget.
         */
    public void updateBudget() {
            try {
                Statement statement = null;
                statement = dbConnection.createStatement();
                String sql = "UPDATE Budget WHERE " + getBudget() + ";";
                statement.execute(sql);
            }

            catch(SQLException se){
                se.printStackTrace();
            }
        }
}
