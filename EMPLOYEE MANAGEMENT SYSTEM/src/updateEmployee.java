public String updateEmployee(String fname, String lname, int ssn, int empid) {
    return "UPDATE employee SET fname = '" + fname + "' AND  lname = '" + lname + "' AND ssn ='" + ssn + "' WHERE empid = '" + empid + "';"
}
