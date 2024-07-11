import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public void AddEmployee(int empId, String name, String division, String jobTitle, double salary, String ssn) throws SQLException {
        String sql = "INSERT INTO Employee (empId, name, division, jobTitle, salary, ssn) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);) {
                stmt.setInt(1, empId);
                stmt.setString(2, name);
                stmt.setString(3, division);
                stmt.setString(4, jobTitle);
                stmt.setDouble(5, salary);
                stmt.setString(6, ssn);
                stmt.executeUpdate();
                System.out.println("Employee added successfully.");
        }catch(SQLException e) {
                e.printStackTrace();
        }
    }