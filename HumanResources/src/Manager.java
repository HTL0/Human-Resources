public class Manager extends Staff implements ICalculator {
    private String position;

    public Manager(String id, String name, int age, double coeffSalary, String startDate, String department, int vocationDays, String position){
        super(id, name, age, coeffSalary, startDate, department, vocationDays);
        setPosition(position);
    }

    public void setPosition(String position){
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }

    public String displayPosition(){
        return formatString(this.position, OVERTIMEORPOSITIONLENGTH);
    }

    public double calSalary(){
        double salary = super.getCoeffSalary() * 5000000;
        if(this.position.equals("Business Leader")){
            return salary + BUSINESSLEADER;  
        }else if(this.position.equals("Project Leader")){
            return salary + PROJECTLEADER;
        }else return salary + TECHNICALLEADER;
    }

    public void displayInformation(){
        System.out.println(this.displayId() + "| " + this.displayName() + "| " + this.displayAge() + "| " + this.displayCoeffSalary() + "| " + this.displayStartDate() + "| " + this.displayVocationDays() + "| " + this.displayDepartment() + "| " + this.displayPosition() + "| " + df.format(this.calSalary()));
    }
    
}
