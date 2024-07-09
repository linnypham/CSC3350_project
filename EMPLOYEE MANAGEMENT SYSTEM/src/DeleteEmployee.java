import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManager {

    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeDAO employeeDAO = new EmployeeDAO(); // Assuming EmployeeDAO is correctly implemented

    public static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int empId = scanner.nextInt();
        scanner.nextLine();  // consume newline

        try {
            employeeDAO.deleteEmployee(empId);
            System.out.println("Employee deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to delete employee: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
