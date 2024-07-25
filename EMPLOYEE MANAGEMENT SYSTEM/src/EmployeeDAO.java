import java.sql.*;
import java.util.*;

public class EmployeeDAO {


    // Add employee to the database
    public static void addEmployee(Connection conn, String tableName, Employee employee) throws SQLException
    {
        String sql = String.format("INSERT INTO %s (empId, Name, division, jobTitle, salary, ssn) VALUES (?, ?, ?, ?, ?, ?)", tableName);
        try (PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, employee.getEmpId());
            pstmt.setString(2, employee.getName());
            pstmt.setString(3,  employee.getDivision());
            pstmt.setString(4, employee.getJobTitle());
            pstmt.setDouble(5, employee.getSalary());
            pstmt.setString(6, employee.getSSN());
            pstmt.executeUpdate();
        }
    }

    // Update employee information
    public static void updateEmployee(Connection conn, Scanner inputScanner, String tableName) throws SQLException
    {
        System.out.print("Enter employee ID to update: ");
        int empId = inputScanner.nextInt();
        inputScanner.nextLine();

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

        String sql = String.format("UPDATE %s SET name = ?, division = ?, jobTitle = ?, salary = ?, ssn = ? WHERE empId = ?", tableName);
        try (PreparedStatement pstmt = conn.prepareStatement(sql))
        {
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

    // Search employee table using the employee's Social Security Number and Employee ID
    public static void searchEmployee(Connection conn, Scanner inputScanner, String tableName) throws SQLException {
        // Clears buffer
        inputScanner.nextLine();

        System.out.print("Enter employee SSN or leave blank: ");
        String ssnInput = inputScanner.nextLine().trim();

        System.out.print("Enter employee ID or leave blank: ");
        String empIdInput = inputScanner.nextLine().trim();

        System.out.print("Enter employee name or leave blank: ");
        String nameInput = inputScanner.nextLine().trim();

        System.out.println();//this is used for spacing the print statements


        StringBuilder searchSQL = new StringBuilder(String.format("SELECT * FROM %s WHERE 1=1", tableName));

        if (!nameInput.isEmpty()) {
            searchSQL.append(" AND name LIKE ?");
        }
        if (!ssnInput.isEmpty()) {
            searchSQL.append(" AND ssn LIKE ?");
        }
        if (!empIdInput.isEmpty()) {
            searchSQL.append(" AND empId LIKE ?");
        }

        try (PreparedStatement stmt = conn.prepareStatement(searchSQL.toString())) {
            int paramIndex = 1;

            if (!nameInput.isEmpty()) {
                stmt.setString(paramIndex++, "%" + nameInput + "%");
            }
            if (!ssnInput.isEmpty()) {
                stmt.setString(paramIndex++, "%" + ssnInput + "%");
            }
            if (!empIdInput.isEmpty()) {
                stmt.setString(paramIndex++, "%" + empIdInput + "%");
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Employee ID: " + rs.getInt("empId"));
                System.out.println("Full Name: " + rs.getString("name"));
                System.out.println("Division: " + rs.getString("division"));
                System.out.println("Job Title: " + rs.getString("jobTitle"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("SSN: " + rs.getString("ssn"));
                System.out.println();//this is used for spacing the print statements
            }
        }
    }

    //Deletes an employee's information from the database
    public static void deleteEmployee(Connection conn, Scanner inputScanner, String tableName) throws SQLException
    {
        System.out.print("Enter employee ID to delete: ");
        int empId = inputScanner.nextInt();
        inputScanner.nextLine();

        String sql = String.format("DELETE FROM %s WHERE empId = ?", tableName);
        try (PreparedStatement deleteStatement = conn.prepareStatement(sql))
        {
            deleteStatement.setInt(1, empId);
            deleteStatement.executeUpdate();
        }
        System.out.println("Employee deleted.");
    }

    //generates a 9-digit long unique employee id used as another way to identify an employee
    public static int generateUniqueEmployeeId(Connection conn, String tableName) throws SQLException
    {
        Random random = new Random();
        int empId;
        boolean isUnique;
        String sql = String.format("SELECT empId FROM %s WHERE empId = ?", tableName);

        do
        {
            empId = 100000000 + random.nextInt(900000000); // Generate 9-digit ID
            try (PreparedStatement statement = conn.prepareStatement(sql))
            {
                statement.setInt(1, empId);
                try (ResultSet rs = statement.executeQuery())
                {
                    isUnique = !rs.next();
                }
            }
        } while (!isUnique);

        return empId;
    }


    public static void updateEmployeeSalary(Connection conn, Scanner inputScanner, String tableName) throws SQLException
    {
        System.out.print("Enter employee ID to update employee's salary: ");
        int empId = inputScanner.nextInt();
        System.out.print("Enter salary increase % (EX: 3.2): ");
        double percentageIncrease = inputScanner.nextDouble();
        System.out.print("Enter minimum salary: ");
        double minSalary = inputScanner.nextDouble();
        System.out.print("Enter maximum salary: ");
        double maxSalary = inputScanner.nextDouble();

        double multiplier = 1 + (percentageIncrease / 100);

        String sql = String.format("UPDATE %s SET salary = salary * ? WHERE empId = ? AND salary BETWEEN ? AND ?", tableName);

        try (PreparedStatement updateStatement = conn.prepareStatement(sql))
        {

            updateStatement.setDouble(1, multiplier);
            updateStatement.setInt(2, empId);
            updateStatement.setDouble(3, minSalary);
            updateStatement.setDouble(4, maxSalary);
            updateStatement.executeUpdate();
        }
    }
}
