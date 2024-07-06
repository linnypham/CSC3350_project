public interface Table {
    String addColumn(String column, String datatype);
    String searchTable(String fname, String lname, int ssn, int empid);
    String updateTable(int empid, String column, String value);
    // Other methods can be added here if necessary
}
