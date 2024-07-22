import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public void payByJob(Connection conn, Scanner inputScanner) throws SQLException {
    System.out.println("Enter pay month:");
    int month = inputScanner.nextInt();
    try(PreparedStatement stmt = conn.prepareStatement("SELECT e.jobTitle, SUM(ps.amount) AS totalPay FROM PayStatement ps JOIN Employee e ON ps.empId = e.empId WHERE MONTH(ps.payDate) = ? GROUP BY e.jobTitle ORDER BY e.jobTitle")){
        stmt.setInt(1,month);
    }
}

public void payByDivision(Connection conn, Scanner inputScanner) throws SQLException {
    System.out.println("Enter pay month:");
    int month = inputScanner.nextInt();
    try(PreparedStatement stmt = conn.prepareStatement("SELECT e.Division, SUM(ps.amount) AS totalPay FROM PayStatement ps JOIN Employee e ON ps.empId = e.empId WHERE MONTH(ps.payDate) = ? GROUP BY e.Division ORDER BY e.Division")){
    stmt.setInt(1,month);
    }
}

public void searchEmployee(Connection conn, Scanner inputScanner) throws SQLException {
    System.out.println("Enter employee first name:");
    String firstName = inputScanner.nextLine();
    System.out.println("Enter employee last name:");
    String lastName = inputScanner.nextLine();
    System.out.println("Enter employee SSN:");
    int SSN = inputScanner.nextInt();
    System.out.println("Enter employee ID:");
    int empId = inputScanner.nextInt();
    try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employee WHERE firstName = " + firstName + " AND lastName = " + lastName + " AND ssn = ? AND empId = ?" )){
    stmt.setInt(1, SSN);
    stmt.setInt(2,empId);
    }
}

public void payStatementHistory(Connection conn, Scanner inputScanner) throws SQLException {
    System.out.println("Enter employee ID:");
    int empId = inputScanner.nextInt();
    try(PreparedStatement stmt = conn.prepareStatement("SELECT e.firstName, e.lastName, e.empId, ps.payDate, ps.amount FROM PayStatement ps JOIN Employee e on ps.empId = e.empId WHERE e.empId = ?")){
    stmt.setInt(1,empId);
    }
}
