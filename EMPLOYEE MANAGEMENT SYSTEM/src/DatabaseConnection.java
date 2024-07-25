import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection implements DatabaseConnectionInterface {

    private Connection databaseConnection;

    public void createConnection() throws SQLException { //creates connection
        databaseConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employeedb",
                "root",
                "password");
        System.out.println("Connection established");
    }

    public Connection getConnection() {
        return databaseConnection;
    }
}