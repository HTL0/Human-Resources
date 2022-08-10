import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HumanResources {
    public static Scanner sc = new Scanner(System.in, "UTF-8");
    static ArrayList<Staff> staffsList = new ArrayList<Staff>();
    static ArrayList<Department> departmentsList = new ArrayList<Department>();

    public static void main(String[] args) throws Exception {
        int choice;

        /**
         * Create initialize data
         */
        departmentsList.add(new Department("HC", "Personnel"));
        departmentsList.add(new Department("IT", "IT"));
        departmentsList.add(new Department("MKT", "Marketing"));
        staffsList.add(new Employee("I001", "Hoang Van Hoang", 29, 2.5, "16/07/2022", "IT", 120, 5));
        staffsList.add(new Manager("M001", "Nguyen Thi Be", 24, 5.0, "16/07/2022", "Marketing", 125, "Business Leader"));
        staffsList.add(new Manager("H001", "Trinh Minh Cao", 35, 4.5, "16/07/2022", "Personnel", 125, "Project Leader"));
        
        do{
            System.out.println("1. Display staff list");
            System.out.println("2. Display department list.");
            System.out.println("3. Display staff list by department");
            System.out.println("4. Add new staff");
            System.out.println("5. search staff by name or ID");
            System.out.println("6. Display salary list");
            System.out.println("7. Display salary list (decrease)");
            System.out.println("0. Exit");
            System.out.print("You choice: ");
            choice = checkInputInt();
            if(choice >= 0 && choice <= 7){
                switch(choice){
                    case 1: displayEmployees(); break;
                    case 2: displayDepartment(); break;
                    case 3: displayEmployeesByDeparment(); break;
                    case 4: addStaff(); break;
                    case 5: searchEmployee(); break;
                    case 6: sortbySalaryDec(); break;
                    case 7: sortbySalaryAsc(); break;
                }
            }else{
                displayErrorMess("error, input again!");
                System.out.println();
            }
        }while(choice != 0);
    }

    /**
     * Display staff list menthod.
     * get parameter staff ArrayList.
     * @param arr
     */
    public static void displayEmployees(){
        staffsList.get(0).displayHeader();
        // for(int i = 0; i < arr.size(); i++){
        //     arr.get(i).displayInformation();
        // }
        staffsList.forEach(i -> { i.displayInformation();});
        System.out.println();
    }

    /**
     * Display department menthod.
     * get parameter department ArrayList.
     * @param arr
     */
    public static void displayDepartment(){
        departmentsList.get(0).displayHeader();
        // for(int i = 0; i < arr.size(); i++){
        //     System.out.println(arr.get(i).toString());
        // }
        departmentsList.forEach(i -> {System.out.println(i.toString());});
        System.out.println();
    }
    
    /**
     * Display staff list by department.
     * get parameter staff ArrayList and department ArrayList
     * @param staffsArr
     * @param departmentsArr
     */
    public static void displayEmployeesByDeparment(){
        departmentsList.forEach(i -> {
            System.out.println(i.getDepartmentName());
            System.out.println("---------------------------------------------------------");
            staffsList.get(0).displayHeader();
            staffsList.forEach(j ->{
                if(j.getDepartment().equals(i.getDepartmentName())){
                    j.displayInformation();
                }
            });
            System.out.println();
        });
    }

    /**
     * Add staff menthod
     * check user choice
     * call menthod add staff or add manager
     */
    public static void addStaff(){
        boolean addCompleted = true;
        do{
            System.out.println("1. Add staff");
            System.out.println("2. Add manager");
            System.out.print("You choice: ");
            int choice;
            choice = checkInputInt();
            if(choice == 1){
                addCompleted = addEmployee();
            }else if (choice == 2){
                addCompleted = addManager();
            }else{
                addCompleted = true;
                displayErrorMess("error, input again!");
                System.out.println();
            }

        }while(addCompleted);
    }

    /**
     * intput staff ID menthod
     * check id is not duplicate
     * @return int id
     */
    public static String inputId(){
        String id = "";
        boolean validate = true;
        do{
            System.out.print("Staff ID: ");
            id = sc.next();
            for(int i = 0; i < staffsList.size(); i++){
                if(staffsList.get(i).getId().equals(id)){
                    displayErrorMess("Staff ID already exists.");
                    validate = true;
                    break;
                }else{
                    validate = false;
                }
            }
        }while(validate);
        return id;
    }

    /**
     * input staff name menthod
     * @return String name
     */
    public static String inputName(){
        String name = "";
        System.out.print("Staff name: ");
        sc.nextLine();//Tránh lỗi scanner bị skip.
        name = sc.nextLine();
        System.out.println(name);
        
        return name;
    }

    /**
     * input staff age menthod
     * check input data
     * check age 18 ~ 80.
     * @return int age
     */
    public static int inputAge(){
        int age;
        boolean validate;
        do{
            System.out.print("Age: ");
            age = checkInputInt();
            if(age >= 18 && age <= 80){
                validate = false;
            }else {
                displayErrorMess("Age must be 18 ~ 80 !"); 
                validate = true;
            }
        }while(validate);

        return age;
    }

    /**
     * input coefficients salary menthod
     * check input data
     * @return double coeffSalary
     */
    public static double inputCoeffSalary(){
        double coeffSalary;
        System.out.print("Coefficients salary: ");
        coeffSalary = checkInputdouble();

        return coeffSalary;
    }

    /**
     * input start date menthod
     * Call validateDate() check syntax date
     * @return String startDate
     */
    public static String inputStartDate(){
        String startDate;
        boolean validate;
        do{
            System.out.print("Start date: ");
            startDate = sc.next();
            validate = validateDate(startDate);
        }while(validate);

        return startDate;
    }

    /**
     * validate data menthod
     * @param strDate
     * @return true/false
     */
    public static boolean validateDate(String strDate){
        /*Kiểm tra nếu trường hợp date là null */
        if(strDate.trim().equals("")){
            System.out.println("Start date can not be empty !");
            return true;
        }else {
            /*Đặt định dạng ngày MM/dd/yyyy */
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            /*setLenient hàm kiểm tra cú pháp chặt chẽ - tuyệt đối, false là kiểm tra chặt chẽ, true là kiểm tra tương đối*/
            sdf.setLenient(false); 
            /*Tạo object Date và parse định dạng ngày tháng*/
            try{
                sdf.parse(strDate);
            }catch(ParseException e){
                System.out.println(strDate + "Illegal data (dd/MM/yyyy)");
                return true;
            }
            return false;
        }
    }

    /**
     * input Vocation days menthod
     * check data type
     * @return int vocationDays
     */
    public static int inputVocationDays(){
        int vocationDays;
        System.out.print("Vocation days: ");
        vocationDays = checkInputInt();

        return vocationDays;
    }

    /**
     * input department for staff menthod
     * check input data type
     * @return String department name
     */
    public static String inputDepartment(){
        String department = "";
        int choice;
        boolean validate;

        System.out.println("1. HC - Personnel");
        System.out.println("2. IT - IT");
        System.out.println("3. MKT - Marketing");
        do{
            System.out.print("you choice department: ");
            choice = checkInputInt();
            if(choice > 4){
                validate = true;
                displayErrorMess("error, input again !");
            }else if(choice == 1){
                validate = false;
                department = "Personnel";
            }else if(choice == 2){
                validate = false;
                department = "IT";
            }else{
                validate = false;
                department = "Marketing";
            }
        }while(validate);

        return department;
    }

    /**
     * input Overtime menthod
     * check input data type
     * @return int overtime
     */
    public static int inputOvertime(){
        int overtime;
        System.out.print("Overtime: ");
        overtime = checkInputInt();

        return overtime;
    }

    /**
     * department staff menbers plus menthod
     * @param s
     */
    public static void employeeMembersPlus(Staff s){
        departmentsList.forEach(i -> {
            if(i.getDepartmentName().equals(s.getDepartment())){
                i.setEmployeeMembers(i.getEmployeeMembers() + 1);
            }
        });
    }

    /**
     * add staff menthod
     * call input menthods 
     * Create obj staff
     * Call employeeMembersPlus
     * Add new obj into staffs ArrayList
     * @return false kết thúc vòng lặp
     */
    public static boolean addEmployee(){
        String id = inputId();
        String name = inputName();
        int age = inputAge();
        double coeffSalary = inputCoeffSalary();
        String startDate = inputStartDate();
        int vocationDays = inputVocationDays();
        String department = inputDepartment();
        int overtime = inputOvertime();

        Staff s = new Employee(id, name, age, coeffSalary, startDate, department, vocationDays, overtime);
        employeeMembersPlus(s);
        staffsList.add(s);

        return false;
    }

    /**
     * add position menthod
     * check input data type
     * @return String position tên chức vụ dựa vào lựa chọn
     */
    public static String inputPosition(){
        String position = "";
        int choice;
        boolean validate;
        System.out.println("Position: ");
        System.out.println("1. Business Leader");
        System.out.println("2. Project Leader");
        System.out.println("3. Technical Leader");
        do{
            System.out.print("input: ");
            choice = checkInputInt();
            if(choice > 3){
                validate = true;
                displayErrorMess("error, input again !");
            }else if(choice == 1){
                validate = false;
                position = "Business Leader";
            }else if(choice == 2){
                validate = false;
                position = "Project Leader";
            }else{
                validate = false;
                position = "Technical Leader";
            }
        }while(validate);

        return position;
    }

    /**
     * Add manager menthod
      * call input menthods 
     * Create obj manager
     * Call employeeMembersPlus
     * Add new obj into staffs ArrayList
     * @return false for end loop
     */
    public static boolean addManager(){
        String id = inputId();
        String name = inputName();
        int age = inputAge();
        double coeffSalary = inputCoeffSalary();
        String startDate = inputStartDate();
        int vocationDays = inputVocationDays();
        String department = inputDepartment();
        String position = inputPosition();

        Staff s = new Manager(id, name, age, coeffSalary, startDate, department, vocationDays, position);
        employeeMembersPlus(s);
        staffsList.add(s);
        
        return false;
    }

    /**
     * Search employee menthod
     * check input data type
     * call searchByName or searchById.
     */
    public static void searchEmployee(){
        int choice;
        System.out.println("1. Search by staff name");
        System.out.println("2. Search by staff ID");
        
        do{
        System.out.print("You choice: ");
        choice = checkInputInt();
        if(choice == 1){
            searchByName();
            break;
        }else if (choice == 2){
            searchById();
            break;
        }else{
            displayErrorMess("error, input again !!");
            System.out.println();
        }}while(true);
    }

    /**
     * Search by name
     * check data match, add result ArrayList
     * Display result
     */
    public static void searchByName(){
        ArrayList<Staff> resultList = new ArrayList<Staff>();
        sc.nextLine();
        System.out.print("Staff name: ");
        String searchName = sc.nextLine();
        System.out.println(searchName);
        staffsList.forEach(i -> {
            if(i.getName().trim().toLowerCase().contains(searchName.toLowerCase())){
                resultList.add(i);
            }
        });

        displayResult(resultList);
    }

    /**
     * Search by ID.
     * check data match, add result ArrayList
     * Display Result
     * staff ID need unique
     */
    public static void searchById(){
        ArrayList<Staff> resultList = new ArrayList<Staff>();
        System.out.print("staff ID: ");
        sc.nextLine();
        String searchId = sc.nextLine();
        staffsList.forEach(i -> {
            if(i.getId().trim().toLowerCase().equals(searchId.toLowerCase())){
                resultList.add(i);
            }
        });
        displayResult(resultList);
    }

    /**
     * display result menthod
     * @param resultList
     */
    public static void displayResult(ArrayList<Staff> resultList){
        if(resultList.size() > 0){
            staffsList.get(0).displayHeader();
            resultList.forEach(i -> {
                i.displayInformation();
            });
        }else{
            displayErrorMess("No matching search results !");
            System.out.println();
        }
    }

    /**
     * Display salary list order by decrease
     * create ArrayList clone of staffsList
     * soft list and swap index 
     * call displayResult
     * 
     * (nên sử dụng upcasting và downcasting)
     */
    public static void sortbySalaryDec(){
        ArrayList<Staff> cloneArrayList = (ArrayList<Staff>) staffsList.clone();
        Staff temp = cloneArrayList.get(0);
        for(int i = 0; i < cloneArrayList.size() - 1; i++){
            for(int j = i + 1; j < cloneArrayList.size(); j++){
                if(checkStaff(cloneArrayList.get(i)) < checkStaff(cloneArrayList.get(j))){
                    temp = cloneArrayList.get(j);
                    cloneArrayList.set(j, cloneArrayList.get(i));
                    cloneArrayList.set(i, temp);
                }
            }
        }

        displayResult(cloneArrayList);
    }

    /**
     * Display salary list
     * create ArrayList clone of staffsList
     * soft list and swap index 
     * call displayResult
     * (nên sử dụng upcasting và downcasting)
     */
    public static void sortbySalaryAsc(){
        ArrayList<Staff> cloneArrayList = (ArrayList<Staff>) staffsList.clone();
        Staff temp = cloneArrayList.get(0);
        for(int i = 0; i < cloneArrayList.size() - 1; i++){
            for(int j = i + 1; j < cloneArrayList.size(); j++){
                if(checkStaff(cloneArrayList.get(i)) > checkStaff(cloneArrayList.get(j))){
                    temp = cloneArrayList.get(j);
                    cloneArrayList.set(j, cloneArrayList.get(i));
                    cloneArrayList.set(i, temp);
                }
            }
        }

        displayResult(cloneArrayList);
    }

    /**
     * Check staff menthod
     * use keyword "instanceof" check staff is employee or manager
     * @param s
     * @return double calSalary() of object
     */
    public static double checkStaff(Staff s){
        if(s instanceof Employee){
          return ((Employee) s).calSalary();
        }else {
            return ((Manager) s).calSalary();
        }
            
    }

    
    /**
     * Check input type integer menthod
     * @return input.
     */
    public static int checkInputInt(){
        boolean isItInt;
        int input = 0;
        do{
            try {
                input = sc.nextInt();
                isItInt = false;
            } catch (Exception e) {
                displayErrorMess("error, you must be input integer type");
                isItInt = true;
                sc.nextLine();
            }
        }while(isItInt);
        return input;
    }

    /**
     * Check input type double menthod
     * @return input.
     */
    public static double checkInputdouble(){
        boolean isItDouble;
        double input = 0;
        do{
            try {
                input = sc.nextDouble();
                isItDouble = false;
            } catch (Exception e) {
                displayErrorMess("error, you must be input double type");
                isItDouble = true;
                sc.nextLine();
            }
        }while(isItDouble);
        return input;
    }

    /**
     * display error messenger
     * @param errorMess
     */
    public static void displayErrorMess(String errorMess){
        System.out.println(errorMess);
    }

    

}
