/**
 * Khai báo Hằng số lương cho chức vụ
 * Khai báo hàm abstract calSalary() 
 */
public interface ICalculator {
    static final double BUSINESSLEADER = 8000000;
    static final double PROJECTLEADER = 5000000;
    static final double TECHNICALLEADER = 6000000; 
    double calSalary();
}
