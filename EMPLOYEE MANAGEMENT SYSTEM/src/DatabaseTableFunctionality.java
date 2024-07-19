import java.sql.*;

public class DatabaseTableFunctionality implements DatabaseFunctionality {

    private String tableName;
    private DatabaseConnection dbConnection;
    private Connection connection;

    // Constructor
    public DatabaseTableFunctionality(String tableName) throws SQLException {
        this.tableName = tableName;
        this.dbConnection = new DatabaseConnection();
        this.connection = dbConnection.createConnection(); //returns Connection object
    }

    @Override
    public void createTable(String tableName) throws SQLException {
        if (connection != null) {
            if (!tableExist(tableName)) {
                String createTableSQL = "CREATE TABLE " + tableName + " (" +
                        "empId INT PRIMARY KEY," +
                        "firstName VARCHAR(25)," +
                        "lastName VARCHAR(25)," +
                        "division VARCHAR(50)," +
                        "jobTitle VARCHAR(50)," +
                        "salary DECIMAL(10,2)," +
                        "ssn CHAR(9) )";
                executeUpdate(createTableSQL, "Table " + tableName + " created");
            } else {
                System.out.println("Table " + tableName + " already exists");
            }
        }
    }

    @Override
    public boolean tableExist(String tableName) throws SQLException {
        boolean exists = false;
        try (ResultSet resultSet = connection.getMetaData().getTables(null, null, tableName, null)) {
            if (resultSet.next()) {
                exists = true;
            }
        }
        return exists;
    }

    @Override
    public void addColumn(String tableName, String columnName, String dataType) throws SQLException {
        if (!columnExists(tableName, columnName)) {
            String addColumnSQL = String.format("ALTER TABLE %s ADD COLUMN %s %s", tableName, columnName, dataType);
            executeUpdate(addColumnSQL, "Column " + columnName + " added to table " + tableName);
        } else {
            System.out.println("Column " + columnName + " already exists in table " + tableName);
        }
    }

    @Override
    public void deleteColumn(String tableName, String columnName) throws SQLException {
        if (columnExists(tableName, columnName)) {
            String deleteColumnSQL = String.format("ALTER TABLE %s DROP COLUMN %s", tableName, columnName);
            executeUpdate(deleteColumnSQL, "Column " + columnName + " deleted from table " + tableName);
        } else {
            System.out.println("Column " + columnName + " does not exist in table " + tableName);
        }
    }

    public void displayTable(String tableName) throws SQLException {
        if (connection != null) {
            if (tableExist(tableName)) {
                String query = "SELECT * FROM " + tableName;
                try (PreparedStatement statement = connection.prepareStatement(query);
                     ResultSet resultSet = statement.executeQuery()) {
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    // Print column headers
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(metaData.getColumnName(i) + "\t");
                    }
                    System.out.println();

                    // Print rows
                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                }
            } else {
                System.out.println("Table " + tableName + " does not exist");
            }
        }
    }

    @Override
    public void updateTable() throws SQLException {
        // this will be used to update the table
    }

    @Override
    public void searchTable(String tableName) throws SQLException {
        // this will be used to searching the table
    }

    private void executeUpdate(String sql, String successMessage) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println(successMessage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean columnExists(String tableName, String columnName) throws SQLException {
        boolean exists = false;
        try (ResultSet resultSet = connection.getMetaData().getColumns(null, null, tableName, columnName)) {
            if (resultSet.next()) {
                exists = true;
            }
        }
        return exists;
    }
}
