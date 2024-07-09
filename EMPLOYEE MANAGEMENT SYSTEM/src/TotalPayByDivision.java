import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManager {

    private static Scanner scanner = new Scanner(System.in);
    private static PayStatementDAO payStatementDAO = new PayStatementDAO(); // Assuming PayStatementDAO is correctly implemented

    public static void totalPayByDivision() {
        System.out.print("Enter Division: ");
        String division = scanner.nextLine();

        try {
            double totalPay = payStatementDAO.getTotalPayByDivision(division);
            System.out.println("Total Pay for " + division + ": " + totalPay);
        } catch (SQLException e) {
            System.out.println("Failed to calculate total pay: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
