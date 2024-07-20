public String updateEmployeeSalary(int empid, double percentageIncrease, double minSalary, double maxSalary){

    double multiplier = 1 + (percentageIncrease / 100);

    return "UPDATE employee SET salary = salary * '" + multiplier + "' WHERE empid = '" + empid + "' AND salary BETWEEN '" + minSalary + "' AND '" + maxSalary + "'";

}