package catalin;


import java.util.*;

public class BankTransaction {


    public static void addInAllCollections(Transaction transaction){
        List<Transaction> transactionList = new ArrayList<>();
        List<Transaction> transactionList1 = new LinkedList<>();
        Map<Integer,Transaction> transactionMap = new HashMap<>();
        Set <Transaction> transactionSet = new HashSet<>();
        Vector<Transaction> transactionVector =new Vector<>();

        transactionList.add(transaction);
        transactionList1.add(transaction);
        transactionMap.put(1,transaction);
        transactionSet.add(transaction);
        transactionVector.add(transaction);


    }

}
