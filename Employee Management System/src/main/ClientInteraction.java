/*
 * The purpose of this class is to be called by the main method
 * This call will serve as the medium between the client and the database
 * The client's input would allow them to navigate through various features of the database
 * Based on the client's input, they will be able to perform various CRUD functions
 */
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

public class ClientInteraction {

    //a while loop with a flag can be used to keep the user in the menu section
    //the switch cases can either leave the flag on or turn it off based on what the user wants to do next

    public static void commenceProgram(String tableName) throws SQLException {

        DatabaseConnection connection = new DatabaseConnection();//database connection obj
        connection.createConnection();//creates connection

        DatabaseTable employeeTable = new DatabaseTable();//object can be used to create new table

        Scanner inputScanner = new Scanner(System.in);

        System.out.println( "Welcome to the company's Employee Database\n");

        boolean loopFlag = true;

        while(loopFlag){

            System.out.println(  "What feature would you like to access (enter number)? \n"+
                    "   1. View Employee Database\n" + //performs "SELECT * FROM"
                    "   2. Add New Employee\n" + //Create function would fall under this (C)
                    "   3. Update Employee Info\n" + //read functions would fall under this (R)
                    "   4. Search Employee Table\n" + //update fuctions would fall under this (U)
                    "   5. Delete Data"); //delete data would fall under this (D)
            System.out.print("> ");
            int userInput = inputScanner.nextInt();


            if(userInput < 1 || userInput > 5){ //checks if user input is not within range of numbers
                System.out.println("Not a valid option");
                System.out.print("Would you like to try again?(Y/N)\n> ");
                String choice = inputScanner.next().toLowerCase();

                if (choice.equals("y") || choice.equals("yes")){
                    System.out.print("Please enter a menu option > ");
                    userInput = inputScanner.nextInt();
                    menuOptions(userInput, tableName.toUpperCase());
                } else if (choice.equals("n")) {
                    System.out.println("Database Access Terminated");
                    System.exit(0);
                }else{
                    System.out.println("Invalid Option. Database Access Terminated.");
                    System.exit(0);
                }
            }else{
                menuOptions(userInput, tableName.toUpperCase());
            }
        }
    }

    //this function would accept the user's input and navigate through the menu based on that option

     static void menuOptions(int userInput, String tableName) throws SQLException {

         DatabaseTable employeeTable = new DatabaseTable();

        switch(userInput){
            case 1: //allows user to view everything in the table
                employeeTable.displayTable(tableName.toUpperCase());
                System.out.println("Here are all the contents of the table");
                break;
            case 2:
                System.out.println("This will call an update function");//placeholder for method call
                break;
            case 3:
                System.out.println("This will call the searchTable()");//placeholder for method call
                break;
            case 4:
                System.out.println("This will call the updateEmployee()");//placeholder for method call
                break;
            case 5:
                System.out.println("This will call the updateSalary()");//placeholder for method call
                break;
            default:
                System.out.println("None of the menu options were selected");
                break;    
        }
    }

}
