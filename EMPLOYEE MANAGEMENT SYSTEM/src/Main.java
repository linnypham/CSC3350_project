import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root","password123456");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from employee;");

            while (resultSet.next()){
                System.out.println(resultSet.getString("fname"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}