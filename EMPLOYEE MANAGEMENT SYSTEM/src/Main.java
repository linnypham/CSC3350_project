import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize DatabaseConnection and create a connection
            DatabaseConnectionInterface databaseConnection = new DatabaseConnection();
            databaseConnection.createConnection();
            Connection conn = databaseConnection.getConnection();


            DatabaseFunctionalityInterface dbFunctionality = new DatabaseTableFunctionality(conn);

//            Creates the tables Employee and PayStatement, only needs to be run once
//            dbFunctionality.createTable("Employee");
            dbFunctionality.createTable("TestTable");

            // Create an instance of ClientInteraction
            ClientInteraction clientInteraction = new ClientInteraction(databaseConnection, dbFunctionality);

            //commences the program allowing the user access to the Employee table though menu options
            clientInteraction.commenceProgram("Employee","PayStatement",conn);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
