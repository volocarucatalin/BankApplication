package model;

public class Account {
    private String name;
    private long cardNumber;
    private long accountNumber;
    private int securityCode;
    private int sortCode;
    private double balance;

    public Account() {
    }

    public Account(String name, long cardNumber, long accountNumber, int securityCode, int sortCode, double balance ) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.securityCode = securityCode;
        this.sortCode = sortCode;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
