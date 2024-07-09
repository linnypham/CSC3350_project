import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManager {

    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeDAO employeeDAO = new EmployeeDAO(); // Assuming EmployeeDAO is correctly implemented

    public static void addEmployee() {
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

        Employee emp = new Employee();
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
            System.out.println("Failed to add employee: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
