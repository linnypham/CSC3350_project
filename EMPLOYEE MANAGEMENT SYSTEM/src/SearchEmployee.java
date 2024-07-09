import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {

    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeDAO employeeDAO = new EmployeeDAO(); // Assuming EmployeeDAO is correctly implemented

    public static void searchEmployee() {
        System.out.print("Enter search keyword (name, SSN, or empId): ");
        String keyword = scanner.nextLine();

        try {
            List<Employee> employees = employeeDAO.searchEmployee(keyword);
            if (employees.isEmpty()) {
                System.out.println("No employees found.");
                return;
            }
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        } catch (SQLException e) {
            System.out.println("Failed to search employees: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        searchEmployee();
    }
}
