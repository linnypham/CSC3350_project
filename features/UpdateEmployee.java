private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int empId = scanner.nextInt();
        scanner.nextLine();  // consume newline
        try {
            Employee emp = employeeDAO.getEmployeeById(empId);
            if (emp == null) {
                System.out.println("Employee not found.");
                return;
            }

            System.out.print("Enter Name (" + emp.getName() + "): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) emp.setName(name);
            System.out.print("Enter Division (" + emp.getDivision() + "): ");
            String division = scanner.nextLine();
            if (!division.isEmpty()) emp.setDivision(division);
            System.out.print("Enter Job Title (" + emp.getJobTitle() + "): ");
            String jobTitle = scanner.nextLine();
            if (!jobTitle.isEmpty()) emp.setJobTitle(jobTitle);
            System.out.print("Enter Salary (" + emp.getSalary() + "): ");
            double salary = scanner.nextDouble();
            if (salary > 0) emp.setSalary(salary);
            scanner.nextLine();  // consume newline
            System.out.print("Enter SSN (" + emp.getSsn() + "): ");
            String ssn = scanner.nextLine();
            if (!ssn.isEmpty()) emp.setSsn(ssn);

            employeeDAO.updateEmployee(emp);
            System.out.println("Employee updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update employee.");
        }
    }