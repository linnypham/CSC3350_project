import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Database db = new Database("jdbc:mysql://localhost:3306/employeedb", "root", "password123456");

            Employee emp1 = new Employee(1, "John Doe", "123456789", "Engineer", "IT", 60000);
            Employee emp2 = new Employee(2, "Jane Smith", "987654321", "Manager", "HR", 90000);

            db.addEmployee(emp1);
            db.addEmployee(emp2);

            emp1.addPayStatement(new PayStatement("January", 5000));
            emp1.addPayStatement(new PayStatement("February", 5000));

            emp2.addPayStatement(new PayStatement("January", 7500));
            emp2.addPayStatement(new PayStatement("February", 7500));

            Report report = new Report(db);
            report.generateEmployeePayHistory();
            report.generateTotalPayByJobTitle("January");
            report.generateTotalPayByDivision("January");

            db.updateEmployeeSalary(3.2, 58000, 105000);

            System.out.println("After Salary Update:");
            report.generateEmployeePayHistory();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
