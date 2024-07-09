import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManager {

    private static Scanner scanner = new Scanner(System.in);
    private static PayStatementDAO payStatementDAO = new PayStatementDAO(); // Assuming PayStatementDAO is correctly implemented

    public static void totalPayByJobTitle() {
        System.out.print("Enter Job Title: ");
        String jobTitle = scanner.nextLine();

        try {
            double totalPay = payStatementDAO.getTotalPayByJobTitle(jobTitle);
            System.out.println("Total Pay for " + jobTitle + ": " + totalPay);
        } catch (SQLException e) {
            System.out.println("Failed to calculate total pay: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
