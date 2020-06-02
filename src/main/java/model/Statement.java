package model;

public class Statement {
    private String name;
    private String receiverName;
    private int sortCode;
    private double amount;
    private String status;
    private String date;

    public Statement(String name, int sortCode, double amount,String receiverName, String status, String date) {
        this.name = name;
        this.sortCode = sortCode;
        this.amount = amount;
        this.receiverName = receiverName;
        this.status = status;
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getSortCode() {
        return sortCode;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "name='" + name + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", sortCode=" + sortCode +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
