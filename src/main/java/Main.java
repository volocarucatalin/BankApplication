
import service.InputReceiver;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("Press 0 to close the program");
        System.out.println("Press 1 if you what to show all of teh accounts");
        System.out.println("Press 2 if you want to find out id the account exist");
        System.out.println("Press 3 if you want to make a transfer");
        System.out.println("Press 4 if you want to see your statement");

       new  InputReceiver().result();

    }
}
