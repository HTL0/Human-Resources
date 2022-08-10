import java.text.DecimalFormat;
/**
 * Class display
 * Khai báo hằng số độ dài hiền thị theo từng trường
 * Khai báo DecimalFormat để phục vụ hiển thị lương, lấy 2 chữ số sau dấu chấm động
 */
public interface display {
    DecimalFormat df = new DecimalFormat("#,###.##");

    public static final int IDLENGTH = 15;
    public static final int NAMELENGTH = 25;
    public static final int AGELENGTH = 5;
    public static final int COEFFSALARYLENGTH = 10;
    public static final int DEPARTMENTLENGTH = 25;
    public static final int DATELENGTH = 15;
    public static final int VOCATIONDAYSLENGTH = 15;
    public static final int OVERTIMEORPOSITIONLENGTH = 25;
    public static final int SALARYLENGTH = 12;

    String formatString(String str, int length);
    
    void displayHeader();
}
