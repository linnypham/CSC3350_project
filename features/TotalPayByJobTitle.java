private static void totalPayByJobTitle() {
        System.out.print("Enter Job Title: ");
        String jobTitle = scanner.nextLine();
        try {
            double totalPay = payStatementDAO.getTotalPayByJobTitle(jobTitle);
            System.out.println("Total Pay for " + jobTitle + ": " + totalPay);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to calculate total pay.");
        }
    }