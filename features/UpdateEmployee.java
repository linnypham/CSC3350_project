import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int empId = scanner.nextInt();
        scanner.nextLine();  // consume newline
        try {
            Employee emp = employeeDAO.getEmployeeById(empId);
            if (emp == null) {
                System.out.println("Employee not found.");
                return;
            }

            System.out.print("Enter Name (" + emp.getName() + "): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) emp.setName(name);
            System.out.print("Enter Division (" + emp.getDivision() + "): ");
            String division = scanner.nextLine();
            if (!division.isEmpty()) emp.setDivision(division);
            System.out.print("Enter Job Title (" + emp.getJobTitle() + "): ");
            String jobTitle = scanner.nextLine();
            if (!jobTitle.isEmpty()) emp.setJobTitle(jobTitle);
            System.out.print("Enter Salary (" + emp.getSalary() + "): ");
            double salary = scanner.nextDouble();
            if (salary > 0) emp.setSalary(salary);
            scanner.nextLine();  // consume newline
            System.out.print("Enter SSN (" + emp.getSsn() + "): ");
            String ssn = scanner.nextLine();
            if (!ssn.isEmpty()) emp.setSsn(ssn);

            employeeDAO.updateEmployee(emp);
            System.out.println("Employee updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update employee.");
        }
    }

    public Employee getEmployeeById(int id) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employee WHERE empId = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Employee emp = new Employee();
            emp.setEmpId(rs.getInt("empId"));
            emp.setName(rs.getString("name"));
            emp.setDivision(rs.getString("division"));
            emp.setJobTitle(rs.getString("jobTitle"));
            emp.setSalary(rs.getDouble("salary"));
            emp.setSsn(rs.getString("ssn"));
            return emp;
        } else {
            return null;
        }
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