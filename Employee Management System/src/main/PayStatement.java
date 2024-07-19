import java.util.Date;

public class PayStatement {
    private int payStatementId;
    private int empId;
    private Date payDate;
    private double amount;

    // Getters and Setters

    public int getPayStatementId() {
        return payStatementId;
    }

    public void setPayStatementId(int payStatementId) {
        this.payStatementId = payStatementId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
