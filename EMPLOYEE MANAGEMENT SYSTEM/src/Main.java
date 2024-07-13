import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static EmployeeDAO employeeDAO = new EmployeeDAO();
    private static PayStatementDAO payStatementDAO = new PayStatementDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Show All Employee");
            System.out.println("2. Add Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Update Salary");
            System.out.println("7. View Pay Statements by ID");
            System.out.println("8. Total Pay by Job Title");
            System.out.println("9. Total Pay by Division");
            System.out.println("10. Change Column Name");
            System.out.println("11. Add Column to Table");
            System.out.println("12. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    getAllEmployees();
                case 2:
                    addEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    searchEmployee();
                    break;
                case 6:
                    updateSalary();
                    break;
                case 7:
                    viewPayStatements();
                    break;
                case 8:
                    totalPayByJobTitle();
                    break;
                case 9:
                    totalPayByDivision();
                    break;
                case 10:
                    changeColumnName();
                    break;
                case 11:
                    addColumn();
                    break;
                case 12:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void getAllEmployees(){
        System.out.println(employeeDAO.getAllEmployees());
    }
    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Division: ");
        String division = scanner.nextLine();
        System.out.print("Enter Job Title: ");
        String jobTitle = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();  // consume newline
        System.out.print("Enter SSN (no dashes): ");
        String ssn = scanner.nextLine();

        com.company.Employee emp = new com.company.Employee();
        emp.setEmpId(empId);
        emp.setName(name);
        emp.setDivision(division);
        emp.setJobTitle(jobTitle);
        emp.setSalary(salary);
        emp.setSsn(ssn);

        try {
            employeeDAO.addEmployee(emp);
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to add employee.");
        }
    }

    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int empId = scanner.nextInt();
        scanner.nextLine();  // consume newline
        try {
            com.company.Employee emp = employeeDAO.getEmployeeById(empId);
            if (emp == null) {
                System.out.println("Employee not found.");
                return;
            }

            System.out.print("Enter Name (" + emp.getName() + "): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) emp.setName(name);
            System.out.print("Enter Division (" + emp.getDivision() + "): ");
            String division = scanner.nextLine();
            if (!division.isEmpty()) emp.setDivision(division);
            System.out.print("Enter Job Title (" + emp.getJobTitle() + "): ");
            String jobTitle = scanner.nextLine();
            if (!jobTitle.isEmpty()) emp.setJobTitle(jobTitle);
            System.out.print("Enter Salary (" + emp.getSalary() + "): ");
            double salary = scanner.nextDouble();
            if (salary > 0) emp.setSalary(salary);
            scanner.nextLine();  // consume newline
            System.out.print("Enter SSN (" + emp.getSsn() + "): ");
            String ssn = scanner.nextLine();
            if (!ssn.isEmpty()) emp.setSsn(ssn);

            employeeDAO.updateEmployee(emp);
            System.out.println("Employee updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update employee.");
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int empId = scanner.nextInt();
        try {
            employeeDAO.deleteEmployee(empId);
            System.out.println("Employee deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to delete employee.");
        }
    }

    private static void searchEmployee() {
        System.out.print("Enter search keyword (name, SSN, or empId): ");
        String keyword = scanner.nextLine();
        try {
            List<com.company.Employee> employees = employeeDAO.searchEmployee(keyword);
            if (employees.isEmpty()) {
                System.out.println("No employees found.");
                return;
            }
            for (com.company.Employee emp : employees) {
                System.out.println(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to search employees.");
        }
    }

    private static void updateSalary() {
        System.out.print("Enter percentage increase: ");
        double percentage = scanner.nextDouble();
        System.out.print("Enter minimum salary: ");
        double minSalary = scanner.nextDouble();
        System.out.print("Enter maximum salary: ");
        double maxSalary = scanner.nextDouble();
        try {
            employeeDAO.updateSalary(percentage, minSalary, maxSalary);
            System.out.println("Salaries updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update salaries.");
        }
    }

    private static void viewPayStatements() {
        System.out.print("Enter Employee ID to view pay statements: ");
        int empId = scanner.nextInt();
        try {
            List<PayStatement> payStatements = payStatementDAO.getPayStatementsByEmployeeId(empId);
            if (payStatements.isEmpty()) {
                System.out.println("No pay statements found.");
                return;
            }
            for (PayStatement ps : payStatements) {
                System.out.println(ps);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to view pay statements.");
        }
    }

    private static void totalPayByJobTitle() {
        System.out.print("Enter Job Title: ");
        String jobTitle = scanner.nextLine();
        try {
            double totalPay = payStatementDAO.getTotalPayByJobTitle(jobTitle);
            System.out.println("Total Pay for " + jobTitle + ": " + totalPay);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to calculate total pay.");
        }
    }

    private static void totalPayByDivision() {
        System.out.print("Enter Division: ");
        String division = scanner.nextLine();
        try {
            double totalPay = payStatementDAO.getTotalPayByDivision(division);
            System.out.println("Total Pay for " + division + ": " + totalPay);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to calculate total pay.");
        }
    }
}
