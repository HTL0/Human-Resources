### Hi, I’m LONG this is Human resource management application

Display: Simple console interface

Use OOP knowledge and java language

## 1.Project HumanResources includes file:
- The Employee.java file is the definition for the employee class
- File Manager.java is the definition for the management class
- The Department.java file is the definition for the department class
- File HumanResources.java is the class containing the main thread of the program
- The ICalculator file is an interface containing the salary calculation function
- File display is an interface containing the display function
- Interface Design: Simple console interface

## 2.Basic function
- Display the list of existing employees in the company
- Show departments in the company
- Show employees by department
- Add new employees to the company includes 2 types : add regular staff and More staff is management level (with more positions)
- Search for employee information by name or employee code
- Display payroll of company-wide employees
- Display employee payroll in ascending order

## 3.Salary formula:

Employee: Salary coefficient * 3,000,000 + overtime hours * 200,000

Manager: Salary coefficient * 5,000,000 + responsibility salary

- Responsible wage:

Business Leader = 8,000,000

Project Leader = 5,000,000

Technical Leader = 6,000,000

## 4.Implementation details
1. The ICalculator interface contains the salary function, the employee and manager classes implement the interface to calculate the appropriate salary
2. Staff.java is an abstract class containing the basic information of employees
- The displayInformation() function is an abstract function 
- the inherited classes implement the appropriate display of information. 
- Attributes: ID, name, age, salary coefficient, start date, department, vocation days.
3. Employee.java: contains general information about employees
- Inheritance: inherit from Staff class and implements the ICalculator interface
- Attribute: overtime
- Method: calculateSalary() returns employee salary, displayInformation() displays employee information.
- Employee inherits the Staff class that implements the ICalculator interface
4. Manager.java: contains general information about management
- Inheritance: Manager is also an employee, so it will inherit from Staff class and implements the ICalculator interface
- Attribute: position
- Method: displayInformation() displays information including position
5. Department.java: contains general information about the department
- Attributes: department ID, name, employee members
- The method: toString() displays information about the part.
6. HumanResources.java: contains general information about employees
- main to handle the main thread of the program
- Use an ArrayList to manage a list of department, employees in the company including employees and managers




