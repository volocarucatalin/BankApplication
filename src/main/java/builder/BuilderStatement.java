package builder;

import model.Account;
import model.Statement;

public class BuilderStatement {


    public BuilderStatement() {
    }

    public static Statement build(String firstName, String lastName, int sortCode, double amount,String status , String date) {
        String name = firstName + " " + lastName;
        Statement result = new Statement(name, sortCode, amount,status, date);

        return result;
    }
}
