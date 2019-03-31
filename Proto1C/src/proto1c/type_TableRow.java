package proto1c;
import java.time.LocalDate;
import java.sql.*;
/**
 *
 * @author UP820734
 */
public class type_TableRow {
    private String tblName;
    private String tblDate;
    private String tblTime;
    
    public type_TableRow(String name, String date, String time) {
        tblName = name;
        tblDate = date;
        tblTime = time;
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
    
    
}
