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
    
    
    
}
