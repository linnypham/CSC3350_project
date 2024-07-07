import java.sql.*;
import java.util.*;

public class Database {
    private Connection connection;

    public Database(String dbUrl, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public void addEmployee(Employee employee) throws SQLException {
        String query = "INSERT INTO employee (empId, name, ssn, jobTitle, division, salary) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, employee.getEmpId());
            stmt.setString(2, employee.getName());
            stmt.setString(3, employee.getSsn());
            stmt.setString(4, employee.getJobTitle());
            stmt.setString(5, employee.getDivision());
            stmt.setDouble(6, employee.getSalary());
            stmt.executeUpdate();
        }
    }

    public Employee searchEmployeeById(int empId) throws SQLException {
        String query = "SELECT * FROM employee WHERE empId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, empId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Employee(
                        rs.getInt("empId"),
                        rs.getString("name"),
                        rs.getString("ssn"),
                        rs.getString("jobTitle"),
                        rs.getString("division"),
                        rs.getDouble("salary")
                );
            }
        }
        return null;
    }

    public Employee searchEmployeeByName(String name) throws SQLException {
        String query = "SELECT * FROM employee WHERE name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Employee(
                        rs.getInt("empId"),
                        rs.getString("name"),
                        rs.getString("ssn"),
                        rs.getString("jobTitle"),
                        rs.getString("division"),
                        rs.getDouble("salary")
                );
            }
        }
        return null;
    }

    public Employee searchEmployeeBySSN(String ssn) throws SQLException {
        String query = "SELECT * FROM employee WHERE ssn = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, ssn);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Employee(
                        rs.getInt("empId"),
                        rs.getString("name"),
                        rs.getString("ssn"),
                        rs.getString("jobTitle"),
                        rs.getString("division"),
                        rs.getDouble("salary")
                );
            }
        }
        return null;
    }

    public void updateEmployee(Employee employee) throws SQLException {
        String query = "UPDATE employee SET name = ?, ssn = ?, jobTitle = ?, division = ?, salary = ? WHERE empId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getSsn());
            stmt.setString(3, employee.getJobTitle());
            stmt.setString(4, employee.getDivision());
            stmt.setDouble(5, employee.getSalary());
            stmt.setInt(6, employee.getEmpId());
            stmt.executeUpdate();
        }
    }

    public void updateEmployeeSalary(double percentage, double minSalary, double maxSalary) throws SQLException {
        String query = "UPDATE employee SET salary = salary * ? WHERE salary >= ? AND salary < ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDouble(1, 1 + (percentage / 100));
            stmt.setDouble(2, minSalary);
            stmt.setDouble(3, maxSalary);
            stmt.executeUpdate();
        }
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employee";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("empId"),
                        rs.getString("name"),
                        rs.getString("ssn"),
                        rs.getString("jobTitle"),
                        rs.getString("division"),
                        rs.getDouble("salary")
                );
                employees.add(employee);
            }
        }
        return employees;
    }

    public Connection getConnection() {
        return connection;
    }
}
