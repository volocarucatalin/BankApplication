package view;

public class StatementDTO {
    private String name;
    private double amount;
    private String receiverName;
    private String status;
    private String date;

    public StatementDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "StatementDTO:" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", receiverName='" + receiverName + '\'' +
                ", status='" + status + '\'' +
                ", date='" + date ;
    }
}
