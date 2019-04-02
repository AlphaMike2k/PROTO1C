package proto1c;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author UP820734
 */
public class manager_userClient {
    private final gui_Main mainInterface = new gui_Main(this);
    private final gui_BudgetList budgetList = new gui_BudgetList(this);
    private final gui_BLEdit blEdit = new gui_BLEdit(this);
    private final gui_Event mainEvent = new gui_Event(this);
    
    private final mediator mediatorParent;
    private final Connection dbConnection;
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
    private javax.swing.JFrame currentGui = new javax.swing.JFrame();
    
    /**
     * Creates and controls all the GUIs
     * @param mediator the mediator that created it
     * @param conn  the connection to the database
     */
    public manager_userClient(mediator mediator, Connection conn) {
        mediatorParent = mediator;
        dbConnection = conn;
    }
    
    /**
     * Changes the interface the user sees
     * @param newInterface the string equivalent of the interface to change to
     */
    public void changeInterface(String newInterface) {
        currentGui.setVisible(false);
        
        switch (newInterface) {
        case "guiMain":
            mainInterface.setVisible(true);
            currentGui = mainInterface;
            break;
        case "guiMainSpendingList":
            budgetList.setVisible(true);
            currentGui = budgetList;
            break;
        case "guiSpendingListEdit":
            blEdit.setVisible(true);
            currentGui = blEdit;
            break;
        case "guiMainEventScreen":
            mainEvent.setVisible(true);
            currentGui = mainEvent;
            break;
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
     * 
     * @param date 
     * @param tasks 
     */
    public void displayTasks(LocalDate date, ResultSet tasks) {
        mainInterface.setTasks(formatData(tasks, date,"TaskDateTime","TaskName"));
    }
    
    /**
     * 
     * @param date 
     * @param reminders 
     */
    public void displayReminders(LocalDate date, ResultSet reminders) {
        mainInterface.setReminders(formatData(reminders, date,"RemDateTime","RemName"));
    }
    
    /**
     * 
     * @param date 
     * @param events 
     */
    public void displayEvents(LocalDate date, ResultSet events) {
        mainInterface.setEvents(formatData(events, date,"EveDateTime","EveName"));
    }
    
    /**
     * Triggers method in mediator that user has pressed 'Next' button on gui_Main calendar
     */
    public void nextMonth() {
        mediatorParent.buttonPressed("guiMainNext",0,null);
    }
    
    /**
     * Triggers method in mediator that user has pressed 'Previous' button on gui_Main calendar
     */
    public void prevMonth() {
        mediatorParent.buttonPressed("guiMainPrev",0,null);
    }
    
    /**
     * Triggers method in mediator that user has pressed 'Spending List' button on gui_Main calendar
     */
    public void spendingList() {
         mediatorParent.buttonPressed("guiMainSpendingList",0,null);
    }
    
    public void editSpendingList() {
         mediatorParent.buttonPressed("guiSpendingListEdit",0,null);
    }
    
     /**
     * Triggers method in mediator that user has pressed 'Events' button on gui_Main screen
     */
    
   
    
    public void viewEvents(){
        mediatorParent.buttonPressed("guiMainEventScreen",0,null);
    }
    /**
     * Triggers method in mediator that user has pressed 'Back' button on a GUI
     */
    public void back() {
        mediatorParent.buttonPressed("back",0,null);
    }
    
    /**
     * 
     * @param newRow 
     */
    public void spendingListAdd(type_TableRow newRow) {
        mediatorParent.buttonPressed("guiSpendListAdd", 0, newRow);
    }
    
    /**
     * 
     * @param budgetSet 
     */
    public void displaySpendingList(ResultSet budgetSet) {
        budgetList.loadList(formatData(budgetSet, "BudItem", "ItemCost", "Priority"));
    }
    
    public void displaySpendingListEdit(ResultSet budgetSet) {
        blEdit.loadList(formatData(budgetSet, "BudItem", "ItemCost", "Priority"));
    }
    
    
    public void spendingListCheck(type_TableRow row) {
        mediatorParent.buttonPressed("spendingListDelete", 0, row);
    }
    
    public void spendingListSave(type_TableRow row) {
        mediatorParent.buttonPressed("spendingListSave", 0, row);
    }
    
    /**
     * 
     * @param clickedDay 
     */
    public void calendarClicked(int clickedDay) {
        mediatorParent.buttonPressed("calendarClicked", clickedDay,null);
    }
    
    
    /**
     * 
     * @param data
     * @param date
     * @param colName
     * @param colName2
     * @return 
     */
    private ArrayList <type_TableRow> formatData(ResultSet data, LocalDate date, String colName, String colName2) {
        LocalDate dsDate;
        ArrayList <Timestamp> dsDatesList = new ArrayList<Timestamp>();
        ArrayList <String> dsStringList = new ArrayList<String>();
        ArrayList<type_TableRow> tableRows= new ArrayList<type_TableRow>();
        
        try{
            while (data.next()) {
                dsDate = data.getDate(colName).toLocalDate();
                if (dsDate.equals(date)) {
                    dsDatesList.add(data.getTimestamp(colName));
                    dsStringList.add(data.getString(colName2));
                }
            }
            
            for (int i = 1; i < dsDatesList.size(); i++) {
                int insertAt = i;
                Timestamp curListDate = dsDatesList.get(i);
                String curString = dsStringList.get(i);
                
                while (insertAt > 0 & dsDatesList.get(insertAt-1).after(curListDate)) {
                    dsDatesList.set(insertAt, dsDatesList.get(insertAt-1));
                    dsStringList.set(insertAt, dsStringList.get(insertAt-1));
                    insertAt --;
                }
                
                dsDatesList.set(insertAt, curListDate);
                dsStringList.set(insertAt, curString);
            }
            
            for (int j = 0; j < dsDatesList.size(); j++) {
                LocalDateTime tmpDateTime = dsDatesList.get(j).toLocalDateTime();
                tableRows.add(new type_TableRow(dsStringList.get(j),tmpDateTime.format(dateFormat),tmpDateTime.format(timeFormat)));
            }
            
            return tableRows;
        }
        
        catch(SQLException se){
            se.printStackTrace();
        } 
        return null;
    }
    
    /**
     * 
     * @param data
     * @param colName
     * @param colName2
     * @param colName3
     * @return 
     */
    private ArrayList <type_TableRow> formatData(ResultSet data, String colName, String colName2, String colName3) {
        ArrayList <String> dsNamesList = new ArrayList<String>();
        ArrayList <Double> dsCostList = new ArrayList<Double>();
        ArrayList <Integer> dsPriorityList = new ArrayList<Integer>();
        
        ArrayList<type_TableRow> tableRows= new ArrayList<type_TableRow>();
        
        try{
            while (data.next()) {
                dsNamesList.add(data.getString(colName));
                dsCostList.add(data.getDouble(colName2));
                dsPriorityList.add(data.getInt(colName3));
            }
            
            for (int i = 1; i < dsPriorityList.size(); i++) {
                int insertAt = i;
                String curName = dsNamesList.get(i);
                double curCost = dsCostList.get(i);
                int curPriority = dsPriorityList.get(i);
                
                while (insertAt > 0 & dsPriorityList.get(insertAt-1) > curPriority) {
                    dsPriorityList.set(insertAt, dsPriorityList.get(insertAt-1));
                    dsCostList.set(insertAt, dsCostList.get(insertAt-1));
                    dsNamesList.set(insertAt, dsNamesList.get(insertAt-1));
                    insertAt --;
                }
                
                dsPriorityList.set(insertAt, curPriority);
                dsCostList.set(insertAt, curCost);
                dsNamesList.set(insertAt, curName);
            }
            
            for (int j = 0; j < dsPriorityList.size(); j++) {
                tableRows.add(new type_TableRow(dsNamesList.get(j),dsCostList.get(j),dsPriorityList.get(j)));
            }
            
            return tableRows;
        }
        
        catch(SQLException se){
            se.printStackTrace();
        } 
        return null;
    }
    
    /**
     * 
     * @param message 
     */
    public void displayAlert(String message) {
        JOptionPane.showConfirmDialog(null, message, "Error", -1);
    }
}
