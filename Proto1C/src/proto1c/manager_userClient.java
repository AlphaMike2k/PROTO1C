package proto1c;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * Class that all GUIs interact with and are created from
 * @author UP820734
 */
public class manager_userClient {
    private final gui_Main mainInterface = new gui_Main(this);
    private final gui_BudgetList budgetList = new gui_BudgetList(this);
    private final gui_BLEdit blEdit = new gui_BLEdit(this);
    private final gui_Event mainEvent = new gui_Event(this);
    private final gui_EventNew newEvent = new gui_EventNew(this);
    private final gui_Eventedit editEvent = new gui_Eventedit(this);
    private final gui_Reminders reminders = new gui_Reminders(this);
    private final gui_RemindersMain mainReminders = new gui_RemindersMain(this);
    
    private final gui_Budget budget = new gui_Budget(this);
    
    private final mediator mediatorParent;
    private Connection dbConnection = null;
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
    private javax.swing.JFrame currentGui = new javax.swing.JFrame();
    
    /**
     * Constructor for testing
     * @param mediator The mediator that creates class
     */
    public manager_userClient(mediator mediator) {
        mediatorParent = mediator;
    }
    
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
        case "guiEventEdit":
            editEvent.setVisible(true);
            currentGui = editEvent;
            break;
        case "createEvent":
            newEvent.setVisible(true);
            currentGui = newEvent;
            break;
        case "guiReminder":
            reminders.setVisible(true);
            currentGui = reminders;
            break;
        case "showReminders":
            mainReminders.setVisible(true);
            currentGui = mainReminders;
            break;
        case "guiBudget":
            budget.setVisible(true);
            currentGui = budget;
            break;
        default: 
            displayAlert("No GUI found");
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
     * Calls the main GUI to populate task Jtable.
     * Sends date time sorted array list
     * @param date The date tasks should match to be displayed
     * @param tasks A result set containing all tasks
     */
    public void displayTasks(LocalDate date, ResultSet tasks) {
        mainInterface.setTasks(formatData(tasks, date,"TaskDateTime","TaskName"));
    }
    
    /**
     * Calls the main GUI to populate reminder Jtable.
     * Sends date time sorted array list
     * @param date The date reminders should match to be displayed
     * @param reminders A result set containing all reminders
     */
    public void displayReminders(LocalDate date, ResultSet reminders) {
        mainInterface.setReminders(formatData(reminders, date,"RemDateTime","RemName"));
    }
    
    /**
     * Calls the main GUI to populate event Jtable.
     * Sends date time sorted array list
     * @param date The date events should match to be displayed
     * @param events A result set containing all events
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
    
    /**
     * Triggers method in mediator that user has pressed 'Edit Spending List' button.
     * Location: Spending list GUI
     */
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
     * Calls to event GUI to populate Jtable.
     * Sends date time sorted array list
     * @param rs The ResultSet containing all events
     */
    public void showEvents(ResultSet rs){
        mainEvent.loadList(formatEventData(rs,"EveName", "EveType", "EveDateTime"));
    }
    
    /**
     * Triggers method in mediator that user has pressed 'Edit' button.
     * Location: Event GUI
     * @param row The Jtable row the user selected (contains all values in Jtable row)
     */
    public void editEvent(type_TableRow row) {
         mediatorParent.buttonPressed("guiEventEdit",0,row);
    }
    
    /**
     * Calls to event edit GUI to load selected event.
     * @param row The row containing values to display
     */
    public void showEventEdit(type_TableRow row) {
        editEvent.loadEvent(row);
    }
    
    /**
     * Triggers method in mediator that user has pressed 'Save' button.
     * Location: Eventedit GUI
     * @param row The old values and new values the user entered
     */
    public void saveEventEdit(type_TableRow row) {
        mediatorParent.buttonPressed("saveEventEdit", 0, row);
    }
    /**
     * Triggers method in mediator that user has pressed 'Delete' button.
     * Location: Event GUI
     * @param row The row to delete (contains valiues from Jtable)
     */
    public void eventDelete(type_TableRow row) {
        mediatorParent.buttonPressed("deleteEvent", 0, row);
    }
    
    /**
     * Triggers method in mediator that user has pressed 'Create' button.
     * Location: Event GUI
     */
    public void createEvent() {
        mediatorParent.buttonPressed("createEvent", 0, null);
    }
    
    /**
     * Triggers method in mediator that user has pressed 'Save' button.
     * Location: EventNew
     * @param row The values the user has entered
     */
    public void saveNewEvent(type_TableRow row) {
        mediatorParent.buttonPressed("saveCreateEvent", 0, row);
    }
    
    /**
     * Triggers method in mediator that user has pressed 'Back' button on a GUI
     */
    public void back() {
        mediatorParent.buttonPressed("back",0,null);
    }
    
    /**
     * Triggers method in mediator that user has pressed 'Add' button.
     * Location: BudgetList GUI
     * @param newRow The data the user has entered
     */
    public void spendingListAdd(type_TableRow newRow) {
        mediatorParent.buttonPressed("guiSpendListAdd", 0, newRow);
    }
    
    /**
     * Calls to budget list GUI to populate Jtable.
     * Sends priority sorted array list
     * @param budgetSet A ResultSet with all items from database
     */
    public void displaySpendingList(ResultSet budgetSet) {
        budgetList.loadList(formatData(budgetSet, "BudItem", "ItemCost", "Priority"));
    }
    
    /**
     * Calls to BL edit GUI to populate Jtable.
     * Sends priority sorted array list
     * @param budgetSet A ResultSet with all items from database
     */
    public void displaySpendingListEdit(ResultSet budgetSet) {
        blEdit.loadList(formatData(budgetSet, "BudItem", "ItemCost", "Priority"));
    }
    
    /**
     * Triggers method in mediator that user has checked tickbox.
     * Location: Budget GUI
     * @param row The data from the selected row from Jtable
     */
    public void spendingListCheck(type_TableRow row) {
        mediatorParent.buttonPressed("spendingListDelete", 0, row);
    }
    
    /**
     * Triggers method in mediator that user has pressed 'Save' button.
     * Location: BLEdit GUI
     * @param row The data the user has entered
     */
    public void spendingListSave(type_TableRow row) {
        mediatorParent.buttonPressed("spendingListSave", 0, row);
    }
    
    /**
     * Triggers method in mediator that user has clicked the calendar.
     * Location: Main GUI
     * @param clickedDay An int representing the day in the calendar
     */
    public void calendarClicked(int clickedDay) {
        mediatorParent.buttonPressed("calendarClicked", clickedDay,null);
    }
    
    /**
     * Triggers method in mediator that user has pressed 'Reminders' button.
     * Location: Main GUI
     */
    public void remindersPressed() {
        mediatorParent.buttonPressed("showReminders", 0, null);
    }
    
    /**
     * Calls to reminder GUI to populate Jtable.
     * Sends date time sorted array list
     * @param reminderSet A ResultSet with all reminders from database
     */
    public void showReminderList(ResultSet reminderSet) {
        mainReminders.loadList(formatData(reminderSet,"RemName","RemDateTime","RemLocation","RemDescription"));
    }
    
    /**
     * Triggers method in mediator that user has pressed 'Delete' button.
     * Location: RemindersMain GUI
     * @param row The data from the selected Jtable row
     */
    public void reminderDelete(type_TableRow row) {
        mediatorParent.buttonPressed("deleteReminder", 0, row);
    }
    
    /**
     * Triggers method in mediator that user has pressed 'Create' button.
     * Location: RemindersMain
     */
    public void createReminder() {
        mediatorParent.buttonPressed("remindersCreate", 0, null);
    }
    
    /**
     * Triggers method in mediator that user has pressed 'Add' button.
     * Location: Reminders GUI
     * @param row The data the user has entered
     */
    public void remindersAdd(type_TableRow row) {
        mediatorParent.buttonPressed("remindersAdd", 0, row);
    }
    
    /**
     * Triggers the Budget GUI for the budget to be updated.
     */
    public void updateBudget(){
        mediatorParent.buttonPressed("updateBudget", 0, null);
    }
    
    /**
     * Sorts a result set
     * @param data The result set to be sorted
     * @param date The date to match data from ResultSet to
     * @param colName String representing database column name
     * @param colName2 String representing database column name
     * @return A date time sorted array list matching date parameter
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
     * Sorts a ResultSet
     * @param data The ResultSet to sort
     * @param colName String representing database column name
     * @param colName2 String representing database column name
     * @param colName3 String representing database column name
     * @return A priority sorted array list
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
                
                while (insertAt > 0 && dsPriorityList.get(insertAt-1) > curPriority) {
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
     * Sorts a ResultSet
     * @param data The ResultSet to sort
     * @param colName String representing database column name
     * @param colName2 String representing database column name
     * @param colName3 String representing database column name
     * @param colName4 String representing database column name
     * @return A date time sorted array list
     */
    private ArrayList <type_TableRow> formatData(ResultSet data, String colName, String colName2, String colName3, String colName4) {
        ArrayList <String> dsNamesList = new ArrayList<String>();
        ArrayList <Timestamp> dsTimeList = new ArrayList<Timestamp>();
        ArrayList <String> dsLocationList = new ArrayList<String>();
        ArrayList <String> dsDescriptionList = new ArrayList<String>();
        
        ArrayList<type_TableRow> tableRows= new ArrayList<type_TableRow>();
        
        try{
            while (data.next()) {
                dsNamesList.add(data.getString(colName));
                dsTimeList.add(data.getTimestamp(colName2));
                dsLocationList.add(data.getString(colName3));
                dsDescriptionList.add(data.getString(colName4));
            }
            
            for (int i = 1; i < dsTimeList.size(); i++) {
                int insertAt = i;
                String curName = dsNamesList.get(i);
                Timestamp curTime = dsTimeList.get(i);
                String curLocation = dsLocationList.get(i);
                String curDescription = dsDescriptionList.get(i);
                
                while (insertAt > 0 && dsTimeList.get(insertAt-1).after(curTime)) {
                    dsNamesList.set(insertAt, dsNamesList.get(insertAt-1));
                    dsTimeList.set(insertAt, dsTimeList.get(insertAt-1));
                    dsLocationList.set(insertAt, dsLocationList.get(insertAt-1));
                    dsDescriptionList.set(insertAt, dsDescriptionList.get(insertAt-1));
                    
                    insertAt --;
                }
                
                dsNamesList.set(insertAt, curName);
                dsTimeList.set(insertAt, curTime);
                dsLocationList.set(insertAt, curLocation);
                dsDescriptionList.set(insertAt, curDescription);
                
            }
            
            for (int j = 0; j < dsTimeList.size(); j++) {
                tableRows.add(new type_TableRow(dsNamesList.get(j),dsLocationList.get(j),dsDescriptionList.get(j),dsTimeList.get(j)));
            }
            
            return tableRows;
        }
        
        catch(SQLException se){
            se.printStackTrace();
        } 
        return null;
    }
     /**
      * Sorts event data
      * @param data The ResultSet to sort
      * @param colName String representing database column name
      * @param colName2 String representing database column name
      * @param colName3 String representing database column name
      * @return  A date time sorted array list
      */
    private ArrayList <type_TableRow> formatEventData(ResultSet data, String colName, String colName2, String colName3) {
        ArrayList <String> dsNamesList = new ArrayList<String>();
        ArrayList <String> dsTypeList = new ArrayList<String>();
        ArrayList <Timestamp> dsTimeList = new ArrayList<Timestamp>();
        
        ArrayList<type_TableRow> tableRows= new ArrayList<type_TableRow>();
        
        try{
            while (data.next()) {
                dsNamesList.add(data.getString(colName));
                dsTypeList.add(data.getString(colName2));
                dsTimeList.add(data.getTimestamp(colName3));
            }
            
            for (int i = 1; i < dsTimeList.size(); i++) {
                int insertAt = i;
                String curName = dsNamesList.get(i);
                String curType = dsTypeList.get(i);
                Timestamp curTime = dsTimeList.get(i);
                
                while (insertAt > 0 && dsTimeList.get(insertAt-1).after(curTime)) {
                    dsTimeList.set(insertAt, dsTimeList.get(insertAt-1));
                    dsTypeList.set(insertAt, dsTypeList.get(insertAt-1));
                    dsNamesList.set(insertAt, dsNamesList.get(insertAt-1));
                    insertAt --;
                }
                
                dsTimeList.set(insertAt, curTime);
                dsTypeList.set(insertAt, curType);
                dsNamesList.set(insertAt, curName);
            }
            
            for (int j = 0; j < dsTimeList.size(); j++) {
                tableRows.add(new type_TableRow(dsNamesList.get(j),dsTypeList.get(j),dsTimeList.get(j)));
            }
            
            return tableRows;
        }
        
        catch(SQLException se){
            se.printStackTrace();
        } 
        return null;
    }
    
    /**
     * Displays an alert box to the user
     * @param message The message to display
     */
    public void displayAlert(String message) {
        JOptionPane.showConfirmDialog(null, message, "Error", -1);
    }

}
