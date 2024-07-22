    public static void deleteEmployee(Connection conn, Scanner inputScanner)throws SQLException { 

        System.out.print("Enter employee ID to delete: ");
        int empId = inputScanner.nextInt();
        inputScanner.nextLine();

         String sql = String.format("DELETE FROM employee WHERE empId = '" + empId + "'")
         try (PreparedStatement deleteStatement = conn.prepareStatement(sql)) {
            deleteStatement.setInt(1, empId);
            deleteStatement.executeUpdate();
        }
        System.out.println("Employee deleted.");
    
    }
