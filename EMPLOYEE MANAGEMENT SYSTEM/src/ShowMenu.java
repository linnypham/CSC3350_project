import java.util.Scanner;

public class EmployeeManager {

    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Update Salary");
            System.out.println("6. View Pay Statements");
            System.out.println("7. Total Pay by Job Title");
            System.out.println("8. Total Pay by Division");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    AddEmployee();
                    break;
                case 2:
                    UpdateEmployee();
                    break;
                case 3:
                    DeleteEmployee();
                    break;
                case 4:
                    SearchEmployee();
                    break;
                case 5:
                    UpdateSalary();
                    break;
                case 6:
                    ViewPayStatements();
                    break;
                case 7:
                    TotalPayByJobTitle();
                    break;
                case 8:
                    TotalPayByDivision();
                    break;
                case 9:
                    System.out.println("Exiting Employee Management System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Methods like AddEmployee(), UpdateEmployee(), etc. should be defined here

    public static void main(String[] args) {
        showMenu();
    }
}
