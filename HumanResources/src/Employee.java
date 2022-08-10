public class Employee extends Staff implements ICalculator {
    private int overtime;
    
    public Employee(String id, String name, int age, double coeffSalary, String startDate, String department, int vocationDays, int overtime){
        super(id, name, age, coeffSalary, startDate, department, vocationDays);
        setOvertime(overtime);
    }

    public void setOvertime(int overtime){
        this.overtime = overtime;
    }

    public int getOvertime() {
        return this.overtime;
    }

    public String displayOvertime(){
        return formatString(String.valueOf(this.overtime), OVERTIMEORPOSITIONLENGTH);
    }

    public double calSalary(){
        return super.getCoeffSalary() * 3000000 + (double)this.overtime * 200000;
    }

    public void displayInformation(){
        System.out.println(this.displayId() + "| " + this.displayName() + "| " + this.displayAge() + "| " + this.displayCoeffSalary() + "| " + this.displayStartDate() + "| " + this.displayVocationDays() + "| " + this.displayDepartment() + "| " + this.displayOvertime() + "| " + df.format(this.calSalary()));
    }
}
