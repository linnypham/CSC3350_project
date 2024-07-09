import java.sql.*;
public class DatabaseConnection {

    private Connection connection;

    void createConnection() { //creates connection
        try {
             connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employeedb",
                    "root",
                    "password");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
