private static void ShowMenu() {
        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Update Salary");
            System.out.println("6. View Pay Statements");
            System.out.println("7. Total Pay by Job Title");
            System.out.println("8. Total Pay by Division");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    searchEmployee();
                    break;
                case 5:
                    updateSalary();
                    break;
                case 6:
                    viewPayStatements();
                    break;
                case 7:
                    totalPayByJobTitle();
                    break;
                case 8:
                    totalPayByDivision();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }