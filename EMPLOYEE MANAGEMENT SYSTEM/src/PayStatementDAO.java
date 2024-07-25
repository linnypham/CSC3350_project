import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class PayStatementDAO
{
    public static void payByJob(Connection conn, Scanner inputScanner) throws SQLException {
        System.out.print("Enter pay month: ");
        int month = inputScanner.nextInt();
        inputScanner.nextLine();

        String payByJobSql = "SELECT e.jobTitle, SUM(ps.amount) " +
                "AS totalPay FROM PayStatement ps JOIN Employee e " +
                "ON ps.empId = e.empId WHERE MONTH(ps.payDate) = ? " +
                "GROUP BY e.jobTitle ORDER BY e.jobTitle";

        try(PreparedStatement stmt = conn.prepareStatement(payByJobSql)){
            stmt.setInt(1,month);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String jobTitle = rs.getString("jobTitle");
                double totalPay = rs.getDouble("totalPay");

                System.out.println("Job Title: " + jobTitle);
                System.out.println("Total Pay: " + totalPay);
                System.out.println();
            }

        }
    }

    public static void payByDivision(Connection conn, Scanner inputScanner) throws SQLException {
        System.out.print("Enter pay month: ");
        int month = inputScanner.nextInt();
        inputScanner.nextLine();

        String payByDivisionSql = "SELECT e.Division, SUM(ps.amount) AS totalPay " +
                "FROM PayStatement ps JOIN Employee e ON ps.empId = e.empId " +
                "WHERE MONTH(ps.payDate) = ? " +
                "GROUP BY e.Division ORDER BY e.Division";

        try (PreparedStatement stmt = conn.prepareStatement(payByDivisionSql)) {
            stmt.setInt(1, month);

            try (ResultSet rs = stmt.executeQuery()) {
                // Print results
                while (rs.next()) {
                    String division = rs.getString("Division");
                    double totalPay = rs.getDouble("totalPay");

                    System.out.println("Division: " + division);
                    System.out.println("Total Pay: " + totalPay);
                    System.out.println();
                }
            }
        }
    }


    public static void payStatementHistory(Connection conn, Scanner inputScanner) throws SQLException {
        System.out.print("Enter employee ID: ");
        int empId = inputScanner.nextInt();
        inputScanner.nextLine(); // To consume the newline left by nextInt()

        String payStatementHistorySql = "SELECT e.name, e.empId, ps.payDate, ps.amount " +
                "FROM PayStatement ps JOIN Employee e ON ps.empId = e.empId " +
                "WHERE e.empId = ?";

        try (PreparedStatement stmt = conn.prepareStatement(payStatementHistorySql)) {
            stmt.setInt(1, empId);

            try (ResultSet rs = stmt.executeQuery()) {
                // Print results
                while (rs.next()) {
                    String fullName = rs.getString("name");
                    int id = rs.getInt("empId");
                    Date payDate = rs.getDate("payDate");
                    double amount = rs.getDouble("amount");

                    System.out.println("Employee ID: " + id);
                    System.out.println("Full Name: " + fullName );
                    System.out.println("Pay Date: " + payDate);
                    System.out.println("Amount: " + amount);
                    System.out.println();
                }
            }
        }
    }


}
