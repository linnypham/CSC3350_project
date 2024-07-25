import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DatabaseTableFunctionality implements DatabaseFunctionalityInterface {

    private final Connection connection;


    public DatabaseTableFunctionality(Connection connection)
    {
        if (connection == null)
        {
            throw new IllegalArgumentException("Connection cannot be null");
        }
        this.connection = connection;
    }

    @Override
    public void createTable(String tableName) throws SQLException
    {
        if (!tableExist(tableName))
        {
            Map<String, String> columns = getColumnDefinitions(tableName);
            if (columns == null)
            {
                throw new IllegalArgumentException("Unknown table: " + tableName);
            }

            StringBuilder createTableSQL = new StringBuilder("CREATE TABLE " + tableName + " (");
            for (Map.Entry<String, String> entry : columns.entrySet())
            {
                createTableSQL.append(entry.getKey()).append(" ").append(entry.getValue()).append(", ");
            }

            // Remove the trailing comma and space
            createTableSQL.setLength(createTableSQL.length() - 2);
            createTableSQL.append(")");

            executeUpdate(createTableSQL.toString(), "Table " + tableName + " created");

            // Handle constraints if any
            addConstraints(tableName);
        } else
        {
            System.out.println("Table " + tableName + " already exists");
        }
    }


    private Map<String, String> getColumnDefinitions(String tableName) {
        Map<String, String> columns = new HashMap<>();

        switch (tableName)
        {
            case "Employee":
                columns.put("empId", "INT PRIMARY KEY");
                columns.put("name", "VARCHAR(25)");
                columns.put("division", "VARCHAR(50)");
                columns.put("jobTitle", "VARCHAR(50)");
                columns.put("salary", "DECIMAL(10, 2)");
                columns.put("ssn", "CHAR(9)");
                break;
            case "PayStatement":
                columns.put("transactionID", "BIGINT NOT NULL");
                columns.put("empId", "INT NOT NULL");
                columns.put("payDate", "DATE NOT NULL");
                columns.put("amount", "DECIMAL(10, 2)");
                break;
            case "TestTable":
                columns.put("empId", "INT PRIMARY KEY");
                columns.put("name", "VARCHAR(25)");
                break;
            default:
                return null;
        }

        return columns;
    }

    private void addConstraints(String tableName) throws SQLException
    {
        String addConstraintsSQL = null;
        if (tableName.equals("PayStatement"))
        {
            addConstraintsSQL = "ALTER TABLE PayStatement " +
                    "ADD PRIMARY KEY (empId, payDate), " +
                    "ADD FOREIGN KEY (empId) REFERENCES Employee(empId)";
            // Add more cases if there are more tables with constraints
        }

        if (addConstraintsSQL != null)
        {
            executeUpdate(addConstraintsSQL, "Constraints added to " + tableName + " table");
        }
    }

    @Override
    public boolean tableExist(String tableName) throws SQLException
    {

        boolean exists = false;
        try (ResultSet resultSet = connection.getMetaData().getTables(null, null, tableName, null))
        {
            if (resultSet.next())
            {
                exists = true;
            }
        }
        return exists;
    }

    @Override
    public void addColumn(String tableName, String columnName, String dataType) throws SQLException
    {

        if (!columnExists(tableName, columnName))
        {
            String addColumnSQL = String.format("ALTER TABLE %s ADD COLUMN %s %s", tableName, columnName, dataType);
            executeUpdate(addColumnSQL, "Column " + columnName + " added to table " + tableName);
        }
        else
        {
            System.out.println("Column " + columnName + " already exists in table " + tableName);
        }
    }

    @Override
    public void deleteColumn(String tableName, String columnName) throws SQLException
    {

        if (columnExists(tableName, columnName))
        {
            String deleteColumnSQL = String.format("ALTER TABLE %s DROP COLUMN %s", tableName, columnName);
            executeUpdate(deleteColumnSQL, "Column " + columnName + " deleted from table " + tableName);
        }
        else
        {
            System.out.println("Column " + columnName + " does not exist in table " + tableName);
        }
    }

    @Override
    public void displayTable(String tableName) throws SQLException
    {

        if (!tableExist(tableName))
        {
            System.out.println("Table " + tableName + " does not exist");
            return;
        }

        String query = "SELECT * FROM " + tableName;
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery())
        {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            int[] columnWidths = new int[columnCount];
            for (int i = 1; i <= columnCount; i++)
            {
                String columnName = metaData.getColumnName(i);
                columnWidths[i - 1] = Math.max(columnName.length(), 24);
            }

            printSeparator(columnWidths);
            printRow(metaData, columnWidths);
            printSeparator(columnWidths);

            while (resultSet.next()) {
                printRow(resultSet, columnWidths);
            }
            printSeparator(columnWidths);
        }
    }

    private void printSeparator(int[] columnWidths)
    {
        for (int width : columnWidths)
        {
            System.out.print("+" + "-".repeat(width + 2));
        }
        System.out.println("+");
    }

    private void printRow(ResultSetMetaData metaData, int[] columnWidths) throws SQLException
    {
        for (int i = 1; i <= columnWidths.length; i++)
        {
            System.out.print("| " + padRight(metaData.getColumnName(i), columnWidths[i - 1]) + " ");
        }
        System.out.println("|");
    }

    private void printRow(ResultSet resultSet, int[] columnWidths) throws SQLException
    {
        for (int i = 1; i <= columnWidths.length; i++)
        {
            System.out.print("| " + padRight(resultSet.getString(i), columnWidths[i - 1]) + " ");
        }
        System.out.println("|");
    }

    private String padRight(String text, int length)
    {
        return String.format("%-" + length + "s", text);
    }


    private void executeUpdate(String sql, String successMessage) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println(successMessage);
        } catch (SQLException e) {
            System.err.println("Error executing update: " + e.getMessage());
            throw e;
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
