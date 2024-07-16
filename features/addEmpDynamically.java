import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class EmployeeDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/employeedb";
    private static final String USER = "root";
    private static final String PASSWORD = "password123456";

    public static void addEmpDynamically(Map<String, String> employeeData) throws SQLException {
        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();

        for (String column : employeeData.keySet()) {
            columns.append(column).append(",");
            values.append("?,");
        }

        // Remove the last comma
        columns.setLength(columns.length() - 1);
        values.setLength(values.length() - 1);

        String sql = "INSERT INTO employee (" + columns.toString() + ") VALUES (" + values.toString() + ")";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            int index = 1;
            for (String value : employeeData.values()) {
                pstmt.setString(index++, value);
            }

            pstmt.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
