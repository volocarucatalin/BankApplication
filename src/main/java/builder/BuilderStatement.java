package builder;

import model.Account;
import model.Statement;

public class BuilderStatement {


    public BuilderStatement() {
    }

    public static Statement build(String firstName, String lastName, int sortCode, double amount , String receiverFirstName ,String receiverLastName ,String status , String date) {
        String name = firstName + " " + lastName;
        String receiverName = receiverFirstName + " " + receiverLastName;
        Statement result = new Statement(name, sortCode, amount,receiverName ,status, date);

        return result;
    }
}
