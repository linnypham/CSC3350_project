private static void totalPayByDivision() {
        System.out.print("Enter Division: ");
        String division = scanner.nextLine();
        try {
            double totalPay = payStatementDAO.getTotalPayByDivision(division);
            System.out.println("Total Pay for " + division + ": " + totalPay);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to calculate total pay.");
        }
    }