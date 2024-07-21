import java.sql.*;
import java.util.*;

public class EmployeeFucntionality {

    Employee employee = new Employee();

    private int empId;
    private String name;
    private String division;
    private String jobTitle;
    private double salary;
    private String ssn;

    // Add employee to the database
    public static void addEmployee(Connection conn, String tableName, Employee employee) throws SQLException {
        String sql = String.format("INSERT INTO %s (empId, Name, division, jobTitle, salary, ssn) VALUES (?, ?, ?, ?, ?, ?)", tableName);
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, employee.getEmpId());
            pstmt.setString(2, employee.getName());
            pstmt.setString(4,  employee.getDivision());
            pstmt.setString(5, employee.getJobTitle());
            pstmt.setDouble(6, employee.getSalary());
            pstmt.setString(7, employee.getSSN());
            pstmt.executeUpdate();
        }
    }


    // Update employee information
    public static void updateEmployee(Connection conn, Scanner inputScanner, String tableName) throws SQLException {
        System.out.print("Enter employee ID to update: ");
        int empId = inputScanner.nextInt();
        inputScanner.nextLine(); // Consume newline

        System.out.print("Enter new Full Name: ");
        String name = inputScanner.nextLine();

        System.out.print("Enter new division: ");
        String division = inputScanner.nextLine();

        System.out.print("Enter new job title: ");
        String jobTitle = inputScanner.nextLine();

        System.out.print("Enter new salary: ");
        double salary = inputScanner.nextDouble();
        inputScanner.nextLine(); // Consume newline

        System.out.print("Enter new SSN: ");
        String ssn = inputScanner.nextLine();

        String sql = String.format("UPDATE %s SET firstName = ?, division = ?, jobTitle = ?, salary = ?, ssn = ? WHERE empId = ?", tableName);
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, division);
            pstmt.setString(3, jobTitle);
            pstmt.setDouble(4, salary);
            pstmt.setString(5, ssn);
            pstmt.setInt(6, empId);
            pstmt.executeUpdate();
        }
        System.out.println("Employee information updated.");
    }

    // Search employee table
    public static void searchEmployeeTable(Connection conn, Scanner inputScanner, String tableName) throws SQLException {
        System.out.print("Enter employee ID to search: ");
        int empId = inputScanner.nextInt();
        inputScanner.nextLine(); // Consume newline

        String sql = String.format("SELECT * FROM %s WHERE empId = ?", tableName);
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, empId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Employee ID: " + rs.getInt("empId"));
                System.out.println("Full Name: " + rs.getString("name"));
                System.out.println("Division: " + rs.getString("division"));
                System.out.println("Job Title: " + rs.getString("jobTitle"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("SSN: " + rs.getString("ssn"));
            }
        }
    }

    // Delete employee data
    public static void deleteEmployee(Connection conn, Scanner inputScanner, String tableName) throws SQLException {
        System.out.print("Enter employee ID to delete: ");
        int empId = inputScanner.nextInt();
        inputScanner.nextLine();

        String sql = String.format("DELETE FROM %s WHERE empId = ?", tableName);
        try (PreparedStatement deleteStatement = conn.prepareStatement(sql)) {
            deleteStatement.setInt(1, empId);
            deleteStatement.executeUpdate();
        }
        System.out.println("Employee deleted.");
    }

    public static int generateUniqueEmployeeId(Connection conn, String tableName) throws SQLException {
        Random random = new Random();
        int empId;
        boolean isUnique;
        String sql = String.format("SELECT empId FROM %s WHERE empId = ?", tableName);

        do {
            empId = 100000000 + random.nextInt(900000000); // Generate 9-digit ID
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, empId);
                try (ResultSet rs = statement.executeQuery()) {
                    isUnique = !rs.next();
                }
            }
        } while (!isUnique);

        return empId;
    }



}
