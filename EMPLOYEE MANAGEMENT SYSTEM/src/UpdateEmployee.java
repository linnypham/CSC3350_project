import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManager {

    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeDAO employeeDAO = new EmployeeDAO(); // Assuming EmployeeDAO is correctly implemented

    public static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int empId = scanner.nextInt();
        scanner.nextLine();  // consume newline

        try {
            Employee emp = employeeDAO.getEmployeeById(empId);
            if (emp == null) {
                System.out.println("Employee not found.");
                return;
            }

            System.out.print("Enter Name (" + emp.getName() + "): ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                emp.setName(name);
            }

            System.out.print("Enter Division (" + emp.getDivision() + "): ");
            String division = scanner.nextLine().trim();
            if (!division.isEmpty()) {
                emp.setDivision(division);
            }

            System.out.print("Enter Job Title (" + emp.getJobTitle() + "): ");
            String jobTitle = scanner.nextLine().trim();
            if (!jobTitle.isEmpty()) {
                emp.setJobTitle(jobTitle);
            }

            System.out.print("Enter Salary (" + emp.getSalary() + "): ");
            String salaryStr = scanner.nextLine().trim();
            if (!salaryStr.isEmpty()) {
                double salary = Double.parseDouble(salaryStr);
                if (salary > 0) {
                    emp.setSalary(salary);
                } else {
                    System.out.println("Invalid salary input. Salary must be greater than 0.");
                }
            }

            System.out.print("Enter SSN (" + emp.getSsn() + "): ");
            String ssn = scanner.nextLine().trim();
            if (!ssn.isEmpty()) {
                emp.setSsn(ssn);
            }

            employeeDAO.updateEmployee(emp);
            System.out.println("Employee updated successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to update employee: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        updateEmployee();
    }
}
