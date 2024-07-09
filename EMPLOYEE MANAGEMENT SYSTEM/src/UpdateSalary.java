import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManager {

    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeDAO employeeDAO = new EmployeeDAO(); // Assuming EmployeeDAO is correctly implemented

    public static void updateSalary() {
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
            System.out.println("Failed to update salaries: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
