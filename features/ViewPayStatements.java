private static void viewPayStatements() {
        System.out.print("Enter Employee ID to view pay statements: ");
        int empId = scanner.nextInt();
        try {
            List<PayStatement> payStatements = payStatementDAO.getPayStatementsByEmployeeId(empId);
            if (payStatements.isEmpty()) {
                System.out.println("No pay statements found.");
                return;
            }
            for (PayStatement ps : payStatements) {
                System.out.println(ps);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to view pay statements.");
        }
    }