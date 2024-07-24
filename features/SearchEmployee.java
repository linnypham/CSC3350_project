import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

private static void searchEmployee() {
        System.out.print("Enter search keyword (name, SSN, or empId): ");
        String keyword = scanner.nextLine();
        try {
            List<Employee> employees = employeeDAO.searchEmployee(keyword);
            if (employees.isEmpty()) {
                System.out.println("No employees found.");
                return;
            }
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to search employees.");
        }
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