import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnectionInterface {
    void createConnection() throws SQLException;
    Connection getConnection();
}
