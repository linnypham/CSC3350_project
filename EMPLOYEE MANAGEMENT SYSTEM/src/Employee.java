import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class Employee {
    private int empId;
    private String name;
    private String division;
    private String jobTitle;
    private double salary;
    private String ssn;

    public Employee() {}

    public Employee(int empId, String name, String division, String jobTitle, double salary, String ssn)
    {
        this.empId = empId;
        this.name = name;
        this.division = division;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.ssn = ssn;
    }

    // Getters and Setters
    public int getEmpId()
    {
        return empId;
    }

    public void setEmpId(int empId)
    {
        this.empId = empId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    public String getDivision()
    {
        return division;
    }

    public void setDivision(String division)
    {
        this.division = division;
    }

    public String getJobTitle()
    {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public String getSSN()
    {
        return ssn;
    }

    public void setSSN(String ssn)
    {
        this.ssn = ssn;
    }

}