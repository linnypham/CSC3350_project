private static void updateSalary() {
        System.out.print("Enter percentage increase: ");
        double percentage = scanner.nextDouble();
        System.out.print("Enter minimum salary: ");
        double minSalary = scanner.nextDouble();
        System.out.print("Enter maximum salary: ");
        double maxSalary = scanner.nextDouble();
        try {
            employeeDAO.updateSalary(percentage, minSalary, maxSalary);
            System.out.println("Salaries updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update salaries.");
        }
    }