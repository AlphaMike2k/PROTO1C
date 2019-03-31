package proto1c;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author UP820734
 */
public class manager_userClient {
    private final gui_Main mainInterface = new gui_Main(this);
    private final mediator mediatorParent;
    private final Connection dbConnection;
    private String sqlString;
    private ResultSet dbResults;
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
    
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
            
        switch (newInterface) {
        case "main": 
            mainInterface.setVisible(true);
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
    
    public void displayTasks(LocalDate date) {
        sqlString = "SELECT * FROM Task;";
        dbResults = getData(sqlString);
        mainInterface.setTasks(formatData(dbResults, date,"TaskDateTime","TaskName"));
    }
    
    public void displayReminders(LocalDate date) {
        sqlString = "SELECT * FROM Reminder;";
        dbResults = getData(sqlString);
        mainInterface.setReminders(formatData(dbResults, date,"RemDateTime","RemName"));
    }
    
    public void displayEvents(LocalDate date) {
        sqlString = "SELECT * FROM Event;";
        dbResults = getData(sqlString);
        mainInterface.setEvents(formatData(dbResults, date,"EveDateTime","EveName"));
    }
    
    /**
     * Triggers method in mediator that user has pressed 'Next' button on gui_Main calendar
     */
    public void nextMonth() {
        mediatorParent.buttonPressed("guiMainNext",0);
    }
    
    /**
     * Triggers method in mediator that user has pressed 'Previous' button on gui_Main calendar
     */
    public void prevMonth() {
        mediatorParent.buttonPressed("guiMainPrev",0);
    }
    
    public void calendarClicked(int clickedDay) {
        mediatorParent.buttonPressed("calendarClicked", clickedDay);
    }
    
    private ResultSet getData(String sql) {
        try{
            Statement st = dbConnection.createStatement();
            ResultSet resultData = st.executeQuery(sql);
            /*
            *    while (test.next() ) {
            *    System.out.println(test.getInt("EveID"));
            *    System.out.println(test.getString("EveName"));
            *}
            *System.out.println("Test");
            */
            return resultData; 
        }
        
        catch(SQLException se){
            se.printStackTrace();
        }
        return null;
    }
    
    private ArrayList <type_TableRow> formatData(ResultSet data, LocalDate date, String colName, String colName2) {
        LocalDate dsDate;
        String dsString;
        ArrayList <Timestamp> dsDatesList = new ArrayList<Timestamp>();
        ArrayList <String> dsStringList = new ArrayList<String>();
        ArrayList<type_TableRow> tableRows= new ArrayList<type_TableRow>();
        
        try{
            while (data.next()) {
                dsDate = data.getDate(colName).toLocalDate();
                dsString = data.getString(colName2);
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
                //System.out.println(dsStringList.get(j) + " " + tmpDateTime.format(dateFormat) + " " + tmpDateTime.format(timeFormat));
                tableRows.add(new type_TableRow(dsStringList.get(j),tmpDateTime.format(dateFormat),tmpDateTime.format(timeFormat)));
            }
            
            return tableRows;
        }
        
        catch(SQLException se){
            se.printStackTrace();
        } 
        return null;
    }
    
    public void displayAlert() {
        
    }
}
