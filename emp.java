import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}

class EmployeeManagementSystem {
    private List<Employee> employees;

    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> findEmployeesByName(String name) {
        List<Employee> employeesWithName = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                employeesWithName.add(employee);
            }
        }
        return employeesWithName;
    }

    public void printAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public double getTotalSalaryCost() {
        double totalSalaryCost = 0;
        for (Employee employee : employees) {
            totalSalaryCost += employee.getSalary();
        }
        return totalSalaryCost;
    }

    public Employee getEmployeeWithHighestSalary() {
        Employee highestSalaryEmployee = null;
        double maxSalary = Double.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                highestSalaryEmployee = employee;
            }
        }
        return highestSalaryEmployee;
    }

    public Employee getEmployeeWithLowestSalary() {
        Employee lowestSalaryEmployee = null;
        double minSalary = Double.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                lowestSalaryEmployee = employee;
            }
        }
        return lowestSalaryEmployee;
    }

    public void updateEmployeeSalary(Employee employee, double newSalary) {
        employee.setSalary(newSalary);
    }

    public void clearAllEmployees() {
        employees.clear();
    }

    public boolean checkSalaryGreaterThan(Employee employee, double amount) {
        return employee.getSalary() > amount;
    }

    public boolean checkSalaryLessThan(Employee employee, double amount) {
        return employee.getSalary() < amount;
    }

    public boolean checkSalaryNotEqual(Employee employee, double amount) {
        return employee.getSalary() != amount;
    }

    public boolean checkEmployeeExists(Employee employee) {
        return employees.contains(employee);
    }
    public List<Employee> getEmployeesBySalaryRange(double minSalary, double maxSalary) {
        List<Employee> foundEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSalary() >= minSalary && employee.getSalary() <= maxSalary) {
                foundEmployees.add(employee);
            }
        }
        return foundEmployees;
    }
}

public class emp {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Find Employee by ID");
            System.out.println("4. Find Employees by Name");
            System.out.println("5. Print All Employees");
            System.out.println("6. Get Total Salary Cost");
            System.out.println("7. Get Employee with Highest Salary");
            System.out.println("8. Get Employee with Lowest Salary");
            System.out.println("9. Update Employee Salary");
            System.out.println("10. Clear All Employees");
            System.out.println("11. Check if the Employee's Salary is Greater Than Amount");
            System.out.println("12. Check if the Employee's Salary is Less Than Amount");
            System.out.println("13. Check if the Employee's Salary is Not Equal to Actual Amount");
            System.out.println("14. Check if the Employee is Present in the System");
            System.out.println("15. Get Employees by Salary Range");
            System.out.println("16. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    Employee employee = new Employee(id, name, salary);
                    ems.addEmployee(employee);
                    System.out.println("Employee added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Employee ID: ");
                    int removeId = scanner.nextInt();
                    Employee removeEmployee = ems.findEmployeeById(removeId);
                    if (removeEmployee != null) {
                        ems.removeEmployee(removeEmployee);
                        System.out.println("Employee removed successfully!");
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Employee ID: ");
                    int searchId = scanner.nextInt();
                    Employee searchEmployee = ems.findEmployeeById(searchId);
                    if (searchEmployee != null) {
                        System.out.println("Employee found:");
                        System.out.println(searchEmployee);
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Employee Name: ");
                    String searchName = scanner.next();
                    List<Employee> employeesWithName = ems.findEmployeesByName(searchName);
                    if (!employeesWithName.isEmpty()) {
                        System.out.println("Employees found:");
                        for (Employee emp : employeesWithName) {
                            System.out.println(emp);
                        }
                    } else {
                        System.out.println("Employees not found!");
                    }
                    break;
                case 5:
                    System.out.println("All Employees:");
                    ems.printAllEmployees();
                    break;
                case 6:
                    double totalSalaryCost = ems.getTotalSalaryCost();
                    System.out.println("Total Salary Cost: " + totalSalaryCost);
                    break;
                case 7:
                    Employee highestSalaryEmployee = ems.getEmployeeWithHighestSalary();
                    if (highestSalaryEmployee != null) {
                        System.out.println("Employee with Highest Salary:");
                        System.out.println(highestSalaryEmployee);
                    } else {
                        System.out.println("No employees found!");
                    }
                    break;
                case 8:
                    Employee lowestSalaryEmployee = ems.getEmployeeWithLowestSalary();
                    if (lowestSalaryEmployee != null) {
                        System.out.println("Employee with Lowest Salary:");
                        System.out.println(lowestSalaryEmployee);
                    } else {
                        System.out.println("No employees found!");
                    }
                    break;
                case 9:
                    System.out.print("Enter Employee ID: ");
                    int updateId = scanner.nextInt();
                    Employee updateEmployee = ems.findEmployeeById(updateId);
                    if (updateEmployee != null) {
                        System.out.print("Enter new Salary: ");
                        double newSalary = scanner.nextDouble();
                        ems.updateEmployeeSalary(updateEmployee, newSalary);
                        System.out.println("Employee salary updated successfully!");
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case 10:
                    ems.clearAllEmployees();
                    System.out.println("All employees cleared!");
                    break;
                case 11:
                    System.out.print("Enter Employee ID: ");
                    int checkId = scanner.nextInt();
                    Employee checkEmployee = ems.findEmployeeById(checkId);
                    if (checkEmployee != null) {
                        System.out.print("Enter amount: ");
                        double checkAmount = scanner.nextDouble();
                        boolean isSalaryGreaterThan = ems.checkSalaryGreaterThan(checkEmployee, checkAmount);
                        System.out.println("Employee's Salary is Greater Than Amount: " + isSalaryGreaterThan);
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case 12:
                    System.out.print("Enter Employee ID: ");
                    int checkId2 = scanner.nextInt();
                    Employee checkEmployee2 = ems.findEmployeeById(checkId2);
                    if (checkEmployee2 != null) {
                        System.out.print("Enter amount: ");
                        double checkAmount2 = scanner.nextDouble();
                        boolean isSalaryLessThan = ems.checkSalaryLessThan(checkEmployee2, checkAmount2);
                        System.out.println("Employee's Salary is Less Than Amount: " + isSalaryLessThan);
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case 13:
                    System.out.print("Enter Employee ID: ");
                    int checkId3 = scanner.nextInt();
                    Employee checkEmployee3 = ems.findEmployeeById(checkId3);
                    if (checkEmployee3 != null) {
                        System.out.print("Enter actual amount: ");
                        double actualAmount = scanner.nextDouble();
                        boolean isSalaryNotEqual = ems.checkSalaryNotEqual(checkEmployee3, actualAmount);
                        System.out.println("Employee's Salary is Not Equal to Actual Amount: " + isSalaryNotEqual);
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case 14:
                    System.out.print("Enter Employee ID: ");
                    int checkId4 = scanner.nextInt();
                    Employee checkEmployee4 = ems.findEmployeeById(checkId4);
                    boolean isEmployeePresent = ems.checkEmployeeExists(checkEmployee4);
                    System.out.println("Employee is Present in the System: " + isEmployeePresent);
                    break;
                case 15:
                    System.out.print("Enter minimum salary: ");
                    double minSalary = scanner.nextDouble();
                    System.out.print("Enter maximum salary: ");
                    double maxSalary = scanner.nextDouble();
                    List<Employee> employeesBySalaryRange = ems.getEmployeesBySalaryRange(minSalary, maxSalary);
                    if (!employeesBySalaryRange.isEmpty()) {
                        System.out.println("Employees in the specified salary range:");
                        for (Employee emp : employeesBySalaryRange) {
                            System.out.println(emp);
                        }
                    } else {
                        System.out.println("No employees found in the specified salary range.");
                    }
                    break;

                case 16:
                    System.out.println("Exiting Employee Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }

            System.out.println();
        }
    }
}