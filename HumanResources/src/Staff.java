/**
 * Class abstract nhân viên kế thừa class display
 * Thêm phương thức display để hiển thị ra console cho từng trường. 
 */
public abstract class Staff implements display{
    private String id;
    private String name;
    private int age;
    private double coeffSalary; //Biến double hệ số lương.
    private String startDate;  //Biến ngày bắt đầu làm việc.
    private String department;  //Biến bộ phận làm việc.
    private int vocationDays; //Biến số ngày được nghỉ.


    public abstract void displayInformation();

    public Staff(String id, String name, int age, double coeffSalary, String startDate, String department, int vocationDays){
        setId(id);
        setName(name);
        setAge(age);
        setCoeffSalary(coeffSalary);
        setStartDate(startDate);
        setDepartment(department);
        setVocationDays(vocationDays);
    }

    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setCoeffSalary(double coeffSalary){
        this.coeffSalary = coeffSalary;
    }
    public void setStartDate(String startDate){
        this.startDate = startDate;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public void setVocationDays(int vocationDays){
        this.vocationDays = vocationDays;
    }

    
    public String getId() {
        return this.id;
    }

    public String displayId(){
        return formatString(this.getId(), IDLENGTH);
    }

    public String getName() {
        return this.name;
    }

    public String displayName(){
        return formatString(this.getName(), NAMELENGTH);
    }

    public int getAge() {
        return this.age;
    }

    public String displayAge(){
        return formatString(String.valueOf(this.getAge()), AGELENGTH);
    }

    public double getCoeffSalary() {
        return this.coeffSalary;
    }

    public String displayCoeffSalary(){
        return formatString(String.valueOf(this.getCoeffSalary()), COEFFSALARYLENGTH);
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String displayStartDate(){
        return formatString(this.getStartDate(), DATELENGTH);
    }

    public String getDepartment() {
        return this.department;
    }

    public String displayDepartment(){
        return formatString(this.getDepartment(), DEPARTMENTLENGTH);
    }

    public int getVocationDays() {
        return this.vocationDays;
    }

    public String displayVocationDays(){
        return formatString(String.valueOf(this.getVocationDays()), VOCATIONDAYSLENGTH);
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
     * Hàm hiển thị đầu trang cho nhân viên
     * 
     */
    @Override
    public void displayHeader(){
        System.out.println(formatString("Staff ID", IDLENGTH) + "| " + formatString("Staff name", NAMELENGTH) + "| " + formatString("Age", AGELENGTH) + "| " + formatString("Coe Salary", COEFFSALARYLENGTH) + "| " + formatString("Start date", DATELENGTH) + "| " + formatString("Vocation days", VOCATIONDAYSLENGTH) + "| " + formatString("Deparment", DEPARTMENTLENGTH) + "| " + formatString("Overtime/Position", OVERTIMEORPOSITIONLENGTH) + "| " + formatString("Salary", SALARYLENGTH));
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    
}
