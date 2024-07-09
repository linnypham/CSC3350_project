private static void searchEmployee() {
        System.out.print("Enter search keyword (name, SSN, or empId): ");
        String keyword = scanner.nextLine();
        try {
            List<Employee> employees = employeeDAO.searchEmployee(keyword);
            if (employees.isEmpty()) {
                System.out.println("No employees found.");
                return;
            }
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to search employees.");
        }
    }