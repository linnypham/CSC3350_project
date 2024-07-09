import java.util.Scanner;

public class Main {
    private static EmployeeDAO employeeDAO = new EmployeeDAO();
    private static PayStatementDAO payStatementDAO = new PayStatementDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ShowMenu();
    }

}
