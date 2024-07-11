import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public List<Employee> getAllEmployees() throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");
        return rs;
    }

    public Employee getEmployeeById(int id) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employee WHERE empId = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs;
        } else {
            return null;
        }
    }

    public void addEmployee(int empId, String name, String division, String jobTitle, double salary, String ssn) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Employee (empId, name, division, jobTitle, salary, ssn) VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setInt(1, empId);
        stmt.setString(2, name);
        stmt.setString(3, division);
        stmt.setString(4, jobTitle);
        stmt.setDouble(5, salary);
        stmt.setString(6, ssn);
        stmt.executeUpdate();
    }

    public void updateEmployee(Employee emp) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement("UPDATE Employee SET name = ?, division = ?, jobTitle = ?, salary = ?, ssn = ? WHERE empId = ?");
        stmt.setString(1, emp.getName());
        stmt.setString(2, emp.getDivision());
        stmt.setString(3, emp.getJobTitle());
        stmt.setDouble(4, emp.getSalary());
        stmt.setString(5, emp.getSsn());
        stmt.setInt(6, emp.getEmpId());
        stmt.executeUpdate();
    }

    public void deleteEmployee(int id) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM Employee WHERE empId = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public List<Employee> searchEmployee(String keyword) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employee WHERE name LIKE ? OR ssn LIKE ? OR empId LIKE ?");
        String searchPattern = "%" + keyword + "%";
        stmt.setString(1, searchPattern);
        stmt.setString(2, searchPattern);
        stmt.setString(3, searchPattern);
        ResultSet rs = stmt.executeQuery();
        List<Employee> employees = new ArrayList<>();

        while (rs.next()) {
            Employee emp = new Employee();
            emp.setEmpId(rs.getInt("empId"));
            emp.setName(rs.getString("name"));
            emp.setDivision(rs.getString("division"));
            emp.setJobTitle(rs.getString("jobTitle"));
            emp.setSalary(rs.getDouble("salary"));
            emp.setSsn(rs.getString("ssn"));
            employees.add(emp);
        }

        return employees;
    }

    public void updateSalary(double percentage, double minSalary, double maxSalary) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement("UPDATE Employee SET salary = salary + (salary * ? / 100) WHERE salary >= ? AND salary < ?");
        stmt.setDouble(1, percentage);
        stmt.setDouble(2, minSalary);
        stmt.setDouble(3, maxSalary);
        stmt.executeUpdate();
    }
}
