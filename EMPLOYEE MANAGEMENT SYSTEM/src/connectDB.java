import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class connectDB {
    private static final String url = "jdbc:mysql://localhost:3306/employeedb";
    private static final String username = "root";
    private static final String password = "password123456";
     public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
