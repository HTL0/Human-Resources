/**
 * Class Department kế thừa class display
 * Thêm các phương thức display cho từng trường.
 */
public class Department implements display{
    private String departmentId;
    private String departmentName;
    private int employeeMembers;

    public Department(String departmentId, String departmentName){
        setdepartmentId(departmentId);
        setdepartmentName(departmentName);
        employeeMembers = 1;
    }

    public void setdepartmentId(String departmentId){
        this.departmentId = departmentId;
    }

    public void setdepartmentName(String departmentName){
        this.departmentName = departmentName;
    }

    public void setEmployeeMembers(int employeeMembers){
        this.employeeMembers = employeeMembers;
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public String displayDepartmentId(){
        return formatString(this.getDepartmentId(), IDLENGTH);
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public String displayDepartmentName(){
        return formatString(this.getDepartmentName(), DEPARTMENTLENGTH);
    }

    public int getEmployeeMembers() {
        return this.employeeMembers;
    }

    public String toString(){
        return this.displayDepartmentId() + "| " + this.displayDepartmentName() + "| " + this.getEmployeeMembers();
    }

    /**
     * Hàm hiền thị chuỗi
     * Nhận tham số chuỗi muốn hiển thị và độ dài 
     * @param str
     * @param length
     * @return Trà về chuỗi muốn hiển thị
     */
    @Override
    public String formatString(String str, int length){
        String space = " ";
        int addSpace = length - str.length();
        for(int i = 0; i < addSpace; i++){
            str += space;
        }
        return str;
    }
    
    /**
     * Hàm hiển thị đầu trang cho bộ phận
     * 
     */
    @Override
    public void displayHeader() {
        System.out.println(formatString("ID", IDLENGTH) + "| " + formatString("Department name", DEPARTMENTLENGTH) + "| Staff members");
        System.out.println("-------------------------------------------------------------------");
    }

}
