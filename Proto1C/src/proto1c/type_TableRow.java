package proto1c;
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
    private String tblType = null;
    
    public type_TableRow(String name, String date, String time) {
        tblTime = time;
        tblName = name;
        tblDate = date;
    }
    
    public type_TableRow(String name, String date, String time, String type) {
        tblTime = time;
        tblName = name;
        tblDate = date;
        tblType = type;
    }
        
    public type_TableRow(String name, double cost, int priority) {
        itemName = name;
        itemCost = cost;
        itemPriority = priority;
    }
    
    public type_TableRow(String name, double cost, int priority, String newName, double newCost, int newPriority) {
        itemName = name;
        itemCost = cost;
        itemPriority = priority;
        newItemName = newName;
        newItemCost = newCost;
        newItemPriority = newPriority;
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

    public String getTblType() {
        return tblType;
    }
    
    
    
}
