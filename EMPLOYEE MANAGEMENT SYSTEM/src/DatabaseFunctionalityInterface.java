import java.sql.SQLException;


public interface DatabaseFunctionalityInterface {
    void createTable(String tableName) throws SQLException;
    boolean tableExist(String tableName) throws SQLException;
    void addColumn(String tableName, String columnName, String dataType) throws SQLException;
    void deleteColumn(String tableName, String columnName) throws SQLException;
    void displayTable(String tableName) throws SQLException;
}

