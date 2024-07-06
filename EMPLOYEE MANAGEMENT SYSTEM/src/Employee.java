public class Employee implements Table {

    @Override
    public String addColumn(String column, String datatype) {
        return "ALTER TABLE employee ADD " + column + " " + datatype + ";";
    }

    @Override
    public String searchTable(String fname, String lname, int ssn, int empid) {
        return "SELECT * FROM employee WHERE fname = '" + fname + "' AND lname = '" + lname + "' AND ssn = " + ssn + " AND empid = " + empid + ";";
    }

    @Override
    public String updateTable(int empid, String column, String value) {
        return "UPDATE employee SET " + column + " = '" + value + "' WHERE empid = " + empid + ";";
    }

    // Ensure all methods from the Table interface are implemented
}
