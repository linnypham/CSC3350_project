import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils {

    private Connection connection; // Assume this is initialized somewhere in your class

    // Method to add a column to a table
    public void addColumnToTable(String tableName, String columnName) {
        String alterQuery = "ALTER TABLE " + tableName + " ADD COLUMN " + columnName + " VARCHAR(255)";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(alterQuery);
            System.out.println("Column '" + columnName + "' added successfully to table '" + tableName + "'");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Other methods related to database operations could follow here
}
