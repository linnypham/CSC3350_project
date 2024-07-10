import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public void AddColumnToTable(String tableName, String columnName, String dataType) throws SQLException {
    Connection conn = DatabaseConnection.getConnection();
    String sql = String.format("ALTER TABLE %s ADD COLUMN %s %s", tableName, columnName, dataType);
    try (Statement stmt = conn.createStatement()) {
        stmt.executeUpdate(sql);
    }
}
