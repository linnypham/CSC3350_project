import java.sql.*;
import java.util.List;

public class Report {
    private Database db;

    public Report(Database db) {
        this.db = db;
    }

    public void generateEmployeePayHistory() throws SQLException {
        List<Employee> employees = db.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.getEmpId());
            System.out.println("Name: " + employee.getName());
            System.out.println("SSN: " + employee.getSsn());
            System.out.println("Job Title: " + employee.getJobTitle());
            System.out.println("Division: " + employee.getDivision());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("Pay History:");
            for (PayStatement payStatement : employee.getPayHistory()) {
                System.out.println("  Month: " + payStatement.getMonth() + ", Amount: " + payStatement.getAmount());
            }
            System.out.println();
        }
    }

    public void generateTotalPayByJobTitle(String month) throws SQLException {
        String query = "SELECT jobTitle, SUM(amount) AS totalPay FROM employee e " +
                       "JOIN payStatements p ON e.empId = p.empId WHERE p.month = ? GROUP BY jobTitle";
        try (PreparedStatement stmt = db.getConnection().prepareStatement(query)) {
            stmt.setString(1, month);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Total Pay by Job Title for " + month + ":");
            while (rs.next()) {
                System.out.println("Job Title: " + rs.getString("jobTitle") + ", Total Pay: " + rs.getDouble("totalPay"));
            }
        }
    }

    public void generateTotalPayByDivision(String month) throws SQLException {
        String query = "SELECT division, SUM(amount) AS totalPay FROM employee e " +
                       "JOIN payStatements p ON e.empId = p.empId WHERE p.month = ? GROUP BY division";
        try (PreparedStatement stmt = db.getConnection().prepareStatement(query)) {
            stmt.setString(1, month);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Total Pay by Division for " + month + ":");
            while (rs.next()) {
                System.out.println("Division: " + rs.getString("division") + ", Total Pay: " + rs.getDouble("totalPay"));
            }
        }
    }
}
