package catalin;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\voloc\\OneDrive\\Desktop\\transaction.TXT");
        Transaction transaction = new Transaction("05-05-2020", "Lloyd's", 200.34);
        String add = BankTransactions.addInAllCollections(transaction);
        String remove = BankTransactions.removeFromAllCollection(transaction);

        WriteTimeInFile.writeTimeToMakeTransaction(file,add + remove);

    }
}
