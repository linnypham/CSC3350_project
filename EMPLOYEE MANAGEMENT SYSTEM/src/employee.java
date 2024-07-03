public class employee implements table{
    @Override
    public String addColumn(String column, String datatype){
        return  "ALTER TABLE employee ADD " + column + ' ' + datatype ";";
    }

    @Override
    public String searchTable(String fname, String lname, INT ssn, INT empid){
        return "SELECT * FROM employee WHERE fname = '"+fname+"', lname = '"+lname+"', ssn = "+ssn+", empid = "+empid+";";
    }

    @Override
    public  String updateTable(INT empid, String column, String value, INT empid ){
        return "UPDATE employee SET column = '"+value+"' WHERE empid = "+empid+";";
    }
}
