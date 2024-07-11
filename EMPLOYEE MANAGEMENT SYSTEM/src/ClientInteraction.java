/*
 * The purpose of this class is to be called by the main method
 * This call will serve as the medium between the client and the database
 * The client's input would allow them to navigate through various features of the database
 */
import java.sql.SQLException;
import java.util.Scanner;
public class ClientInteraction {

    public static void commenceProgram() throws SQLException {

        DatabaseConnection connection = new DatabaseConnection();//database connection obj
        connection.createConnection();//creates connection

        DatabaseTable employeeTable = new DatabaseTable();//object can be used to create new table

        Scanner scanner = new Scanner(System.in);

        System.out.println( "Welcome to the company's Employee Database\n" +
                            "What feature would you like to access (enter number)?");

        System.out.println( "   1. View Employee Database\n" +
                            "   2. Update Table Contents\n" +
                            "   3. Search table\n" +
                            "   4. Update Employee Info.\n" +
                            "   5. Update Employee Pay");

        System.out.print("> ");
        int userInput = scanner.nextInt();

        if(userInput < 1 || userInput > 5){
            System.out.println("Not a valid option");
            System.out.print("Would you like to try again?(Y/N)\n>");
            String choice = scanner.next().toUpperCase();

            if (choice.equals("Y")){
                userInput = scanner.nextInt();
                menuOptions(userInput);
            } else if (choice.equals("N")) {
                System.out.println("Database Access Terminated");
                System.exit(0);
            }else{
                System.out.println("Invalid Option.");
                System.exit(0);
            }
        }else{
            menuOptions(userInput);
        }

    }

     static void menuOptions(int userInput){
        switch(userInput){
            case 1:
                System.out.println("This will call the displayTable()");//placeholder
                System.out.println("Here are all the contents of the table");
                break;
            case 2:
                System.out.println("This will call an update function");//placeholder
                break;
            case 3:
                System.out.println("This will call the searchTable()");//placeholder
                break;
            case 4:
                System.out.println("This will call the updateEmployee()"); //from EmployeeDOA, placeholder
                break;
            case 5:
                System.out.println("This will call the updateSalary()");//from EmployeeDOA, placeholder
                break;
        }
    }

}
