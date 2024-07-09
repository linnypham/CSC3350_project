import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {

    private static Scanner scanner = new Scanner(System.in);
    private static PayStatementDAO payStatementDAO = new PayStatementDAO(); // Assuming PayStatementDAO is correctly implemented

    public static void viewPayStatements() {
        System.out.print("Enter Employee ID to view pay statements: ");
        int empId = scanner.nextInt();
        scanner.nextLine();  // consume newline

        try {
            List<PayStatement> payStatements = payStatementDAO.getPayStatementsByEmployeeId(empId);
            if (payStatements.isEmpty()) {
                System.out.println("No pay statements found for Employee ID: " + empId);
                return;
            }
            for (PayStatement ps : payStatements) {
                System.out.println(ps);
            }
        } catch (SQLException e) {
            System.out.println("Failed to view pay statements: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
