package features;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public void AddColumnToTable(String tableName, String columnName, String dataType) throws SQLException {
    Connection conn = DatabaseConnection.getConnection();
    PreparedStatement stmt = conn.prepareStatement("ALTER TABLE ? ADD COLUMN ? ?");
    stmt.setString(1,tableName);
    stmt.setString(2,columnName);
    stmt.setString(3, dataType);
    stmt.executeUpdate();
}
