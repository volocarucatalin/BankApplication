package model;

public class Account {
    private String name;
    private long cardNumber;
    private long accountNumber;
    private int securityCode;
    private int sortCode;

    public Account(String name, long cardNumber, long accountNumber, int securityCode, int sortCode) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.securityCode = securityCode;
        this.sortCode = sortCode;
    }

    @Override
    public String toString() {
        return "Account:" +
                "name='" + name + '\'' +
                ", cardNumber=" + cardNumber +
                ", accountNumber=" + accountNumber +
                ", securityCode=" + securityCode +
                ", sortCode=" + sortCode;
    }
}
