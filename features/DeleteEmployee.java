private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int empId = scanner.nextInt();
        try {
            employeeDAO.deleteEmployee(empId);
            System.out.println("Employee deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to delete employee.");
        }
    }