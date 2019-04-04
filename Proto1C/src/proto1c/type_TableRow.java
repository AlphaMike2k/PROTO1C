package proto1c;
import java.sql.Timestamp;
/**
 *
 * @author UP820734
 */
public class type_TableRow {
    private String tblName = null;
    private String tblDate = null;
    private String tblTime = null;
    private String itemName = null;
    private double itemCost = 0.00;
    private int itemPriority = 0;
    private String newItemName = null;
    private double newItemCost = 0.00;
    private int newItemPriority = 0;

    private Timestamp eventDateTime = null;
    private String eventType = null;
    private String eventName = null;
    private Timestamp oldEventDateTime = null;
    private String oldEventType = null;
    private String oldEventName = null;

    private String remName = null;
    private String remLocation = null;
    private String remDescription = null;
    private Timestamp remDateTime = null;
    
    private double newBudget = 0.00;
    
    public type_TableRow() {
        
    }
    
    public type_TableRow(String name, String date, String time) {
        tblTime = time;
        tblName = name;
        tblDate = date;
    }
        
    public type_TableRow(String name, double cost, int priority) {
        itemName = name;
        itemCost = cost;
        itemPriority = priority;
    }
    
    public type_TableRow(double budget){
        newBudget = budget;
    }
   
    
    public type_TableRow(String name, String location, String description, Timestamp dateTime){
        remName = name;
        remDateTime = dateTime;
        remLocation = location;
        remDescription = description;
    }
    
    public type_TableRow(String name, double cost, int priority, String newName, double newCost, int newPriority) {
        itemName = name;
        itemCost = cost;
        itemPriority = priority;
        newItemName = newName;
        newItemCost = newCost;
        newItemPriority = newPriority;
    }
    
    public type_TableRow(String name, String type, Timestamp dateTime) {
        eventName = name;
        eventType = type;
        eventDateTime = dateTime;
    }
    
    public type_TableRow(String oldName, String oldType, Timestamp oldDateTime, String name, String type, Timestamp dateTime) {
        eventName = name;
        eventType = type;
        eventDateTime = dateTime;
        oldEventName = oldName;
        oldEventType = oldType;
        oldEventDateTime = oldDateTime;
    }

    public String getTblName() {
        return tblName;
    }

    public String getTblDate() {
        return tblDate;
    }

    public String getTblTime() {
        return tblTime;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemCost() {
        return itemCost;
    }

    public int getItemPriority() {
        return itemPriority;
    }

    public String getNewItemName() {
        return newItemName;
    }

    public double getNewItemCost() {
        return newItemCost;
    }

    public int getNewItemPriority() {
        return newItemPriority;
    }

    public Timestamp getEventDateTime() {
        return eventDateTime;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventName() {
        return eventName;
    }

    public Timestamp getOldEventDateTime() {
        return oldEventDateTime;
    }

    public String getOldEventType() {
        return oldEventType;
    }

    public String getOldEventName() {
        return oldEventName;
    }

    public double getNewBudget() {
        return newBudget;
    }

    public String getRemName() {
        return remName;
    }

    public Timestamp getRemDateTime() {
        return remDateTime;
    }

    public String getRemLocation() {
        return remLocation;
    }

    public String getRemDescription() {
        return remDescription;
    }

}
