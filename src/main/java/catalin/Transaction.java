package catalin;

import java.util.Date;

public class Transaction {
    private static  int nr_transaction;
    private String date;
    private String destination;
    private Double amount;
    private int id ;

    public Transaction(String date, String destination, Double amount) {
        nr_transaction ++;
        this.date = date;
        this.destination = destination;
        this.amount = amount;
        this.id = nr_transaction;
    }

    public static int getNr_transaction() {
        return nr_transaction;
    }

    public String getDate() {
        return date;
    }

    public String getDestination() {
        return destination;
    }

    public Double getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }
}
