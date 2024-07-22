public void updateEmployeeSalary(Connection conn, Scanner inputScanner)throws SQLException{

        System.out.print("Enter employee ID to update employee's salary : ");
        int empId = inputScanner.nextInt();
        System.out.print("Enter salary increase % (EX: 3.2): ");
        double percentageIncrease = inputScanner.nextDouble();
        System.out.print("Enter minimal salary: ");
        int minSalary = inputScanner.nextInt();
        System.out.print("Enter max  salary: ");
        int maxSalary = inputScanner.nextInt();

        double multiplier = 1 + (percentageIncrease / 100);

        String sql = String.format("UPDATE employee SET salary = salary * '" + multiplier + "' WHERE empid = '" + empId + "' AND salary BETWEEN '" + minSalary + "' AND '" + maxSalary + "'")
        try (PreparedStatement updateStatement = conn.prepareStatement(sql)) {
            updateStatement.setDouble(1,multiplier);
            updateStatement.setInt(2,empId);
            updateStatement.setInt(3,minSalary);
            updateStatement.setInt(4,maxSalary);
            updateStatement.executeUpdate();
        }
}
