import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PayStatementDAO {
    public List<PayStatement> getPayStatementsByEmployeeId(int empId) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PayStatement WHERE empId = ?");
        stmt.setInt(1, empId);
        ResultSet rs = stmt.executeQuery();
        List<PayStatement> payStatements = new ArrayList<>();

        while (rs.next()) {
            PayStatement payStatement = new PayStatement();
            payStatement.setPayStatementId(rs.getInt("payStatementId"));
            payStatement.setEmpId(rs.getInt("empId"));
            payStatement.setPayDate(rs.getDate("payDate"));
            payStatement.setAmount(rs.getDouble("amount"));
            payStatements.add(payStatement);
        }

        return payStatements;
    }

    public double getTotalPayByJobTitle(String jobTitle) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT SUM(amount) AS totalPay FROM PayStatement ps JOIN Employee e ON ps.empId = e.empId WHERE e.jobTitle = ?");
        stmt.setString(1, jobTitle);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getDouble("totalPay");
        } else {
            return 0;
        }
    }

    public double getTotalPayByDivision(String division) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT SUM(amount) AS totalPay FROM PayStatement ps JOIN Employee e ON ps.empId = e.empId WHERE e.division = ?");
        stmt.setString(1, division);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getDouble("totalPay");
        } else {
            return 0;
        }
    }
}
