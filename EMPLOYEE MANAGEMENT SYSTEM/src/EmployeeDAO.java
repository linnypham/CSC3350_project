import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {
    private Connection connection;

    public EmployeeDAO() {
        try {
            connection = connectDB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addSSNColumn() {
        String sql = "ALTER TABLE Employee ADD COLUMN ssn VARCHAR(9)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee searchEmployeeById(int empid) {
        Employee employee = null;
        String sql = "SELECT * FROM Employee WHERE empid = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, empid);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                employee = new Employee();
                employee.setEmpid(resultSet.getInt("empid"));
                employee.setName(resultSet.getString("name"));
                employee.setSsn(resultSet.getString("ssn"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setJobTitle(resultSet.getString("job_title"));
                employee.setDivision(resultSet.getString("division"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    // Other methods for updating employee data, salary increase, etc.
}
