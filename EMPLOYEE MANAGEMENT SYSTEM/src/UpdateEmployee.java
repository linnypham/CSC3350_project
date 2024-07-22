import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployee {
    public void changeName(Employee emp,String name)throws SQLException {
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
    public void changeDivision(Employee emp, String division)throws SQLException{

    }
    public void changeJobTitle(Employee emp, String jobTitle)throws SQLException{

    }
    public void changeSalary(Employee emp, int salary)throws SQLException{

    }
    public void changeSsn(Employee emp, String salary)throws SQLException{

    }
}
