import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private Connection connection;

    public Connection createConnection() throws SQLException { //creates connection
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employeedb",
                    "root",
                    "password");
            System.out.println("Connection established");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return connection;
    }

    public Connection getConnection() {
        return connection;
    }
}
