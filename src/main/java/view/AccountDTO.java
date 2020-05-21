package view;

import java.util.Objects;

public class AccountDTO {
    private String name;
    private long accountNumber;
    private int sortCode;

    public AccountDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAccountNumber(), getSortCode());
    }

    @Override
    public String toString() {
        return "AccountDTO:" +
                "name='" + name + '\'' +
                ", accountNumber=" + accountNumber +
                ", sortCode=" + sortCode ;
    }
}
