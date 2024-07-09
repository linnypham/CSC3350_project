import java.sql.*;

public class DatabaseTable implements DatabaseFunctionality {

    String tableName;
    DatabaseConnection dbConnection;
    Connection connection;

    //constructor
    DatabaseTable() throws SQLException {
        super();
        this.tableName = tableName;
        dbConnection = new DatabaseConnection(); //obj of DatabaseConnection class
        dbConnection.createConnection(); //establishing connection to database
        connection = dbConnection.getConnection(); //returns connection
    }

    //methods
    @Override
    public void createTable(String tableName) throws SQLException {

        if(connection != null){//check for connection first

            if(!tableExist(connection, tableName)){//if the table does not exist
                try {
                    Statement statement = connection.createStatement();
                    String createTable = "CREATE TABLE " +tableName+" ("+
                            "empId INT PRIMARY KEY,"+
                            "firstName VARCHAR(25),"+
                            "lastName VARCHAR(25),"+
                            "division VARCHAR(50),"+
                            "jobTitle VARCHAR(50),"+
                            "salary DECIMAL(10,2),"+
                            "ssn CHAR(9) )";
                    statement.execute(createTable);
                    System.out.println("Table " +tableName+" created");

                }catch(SQLException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("Table " +tableName+ " already exist");
            }
        }
    }

    //checks if tableExist
    public boolean tableExist( Connection connection, String tableName) throws SQLException {
        boolean exist = false;

        try (ResultSet resultSet = connection.getMetaData().getTables(null, null, tableName, null)) {
            while (resultSet.next()) {
                String tName = resultSet.getString("TABLE_NAME");
                if (tName != null && tName.equals(tableName)) {
                    exist = true;
                    break;
                }
            }
        }

        return exist;
    }

    //checks if column exist
    public boolean columnExist(String tableName, String columnName) throws SQLException{
        boolean exist = false;

        try (ResultSet resultSet = connection.getMetaData().getColumns(null, null, columnName, null)){
            while(resultSet.next()){
                String cName = resultSet.getString("COLUMN_NAME");
                if (cName != null && cName.equals(columnName)) {
                    exist = true;
                    break;
                }
            }
        }
        return exist;
    }

    //updates table
    public void updateTable() throws SQLException{//vague
        if(connection != null){//check for connection first

            if(!tableExist(connection, tableName)){//if the table does not exist
                try {
                    Statement statement = connection.createStatement();
                    String updateTable = "CREATE TABLE " +tableName+" ("+
                            "empId INT PRIMARY KEY,"+
                            "firstName VARCHAR(25),"+
                            "lastName VARCHAR(25),"+
                            "division VARCHAR(50),"+
                            "jobTitle VARCHAR(50),"+
                            "salary DECIMAL(10,2),"+
                            "ssn CHAR(9) )";
                    statement.execute(updateTable);
                    System.out.println("Table " +tableName+" created");

                }catch(SQLException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("Table " +tableName+ " already exist");
            }
        }

    }

    //allows for searching of table
    public void searchTable(){

    }

    //allows for column to be added
    public void addColumn(String tableName, String columnName, String dataType)throws SQLException{

        if(!columnExist(tableName, columnName)){
            try{
                Statement statement = connection.createStatement();
                String createColumn = "ALTER TABLE " + tableName
                        + "ADD " +columnName
                        + " " + dataType; //data type can be attained through user choice.

                statement.execute(createColumn);
                System.out.println("Table " +tableName+" created");
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Column " +columnName+ " already exist in" +tableName+ " table");
        }
    }

     //allows for column to be deleted
    public void deleteColumn(String tableName, String columnName) throws SQLException{

        if(columnExist(tableName, columnName)){//if column does not exist
            try{
                Statement statement = connection.createStatement();
                String deleteColumn = "ALTER TABLE " + tableName
                        + "DROP " +columnName; //data type can be attained through user choice.
                statement.execute(deleteColumn);
                System.out.println("Column " +columnName+" has been deleted.");
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Column " +columnName+ " does not exist in" +tableName+ " table");
        }

    }

}
