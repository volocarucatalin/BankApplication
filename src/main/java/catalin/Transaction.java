package catalin;

public class Transaction {
    private String transactionName;
    private String bankName;
    private String transactionAmount;

    public Transaction(String transactionName, String bankName, String transactionAmount) {
        this.transactionName = transactionName;
        this.bankName = bankName;
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public String getBankName() {
        return bankName;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }
}
