package builder;

import model.Account;

public class BuilderAccount {

    public BuilderAccount() {

    }

    public static Account build(String firstName, String lastName, long cardNumber, long accountNumber, int sortCode, int securityCode) {
        String name = firstName + " " + lastName;

        Account result = new Account(name, cardNumber, accountNumber, securityCode, sortCode);


        return result;
    }
}
