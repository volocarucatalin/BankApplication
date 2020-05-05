package catalin;


import java.io.File;
import java.util.*;

public class BankTransactions {

    private static List<Transaction> transactionList = new ArrayList<>();
    private static List<Transaction> transactionList1 = new LinkedList<>();
    private static Map<Integer,Transaction> transactionMap = new HashMap<>();
    private static Set <Transaction> transactionSet = new HashSet<>();
    private static Vector<Transaction> transactionVector =new Vector<>();



    public static String addInAllCollections(Transaction transaction){

        StringBuilder result= new StringBuilder();

        long startTime = System.nanoTime();
        transactionList.add(transaction);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("ArrayList add duration: " +duration);
        result.append("ArrayList add duration:" + duration +"\n");

        long startTime1 = System.nanoTime();
        transactionList1.add(transaction);
        long endTime1 = System.nanoTime();
        long duration1 = (endTime1 - startTime1);
        System.out.println("LinkedList add duration: " +duration1);
        result.append("LinkedList add duration:" + duration1+"\n");

        long startTime2 = System.nanoTime();
        transactionMap.put(transaction.getId(),transaction);
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2);
        System.out.println("Map add duration: " +duration2);
        result.append("Map add duration:" + duration2+"\n");

        long startTime3 = System.nanoTime();
        transactionSet.add(transaction);
        long endTime3 = System.nanoTime();
        long duration3 = (endTime3 - startTime3);
        System.out.println("Set add duration: " +duration3);
        result.append("Set add duration:" + duration3+"\n");

        long startTime4 = System.nanoTime();
        transactionVector.add(transaction);
        long endTime4 = System.nanoTime();
        long duration4 = (endTime4 - startTime4);
        System.out.println("Vector add duration: "+duration4);
        result.append("Vector add duration:" + duration4+"\n");

        return result.toString();
    }
    public static String removeFromAllCollection(Transaction transaction){

        StringBuilder result1 = new StringBuilder();
        long startTime = System.nanoTime();
        transactionList.remove(transaction);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("ArrayList remove duration: " +duration);
        result1.append("ArrayList remove duration: " + duration+"\n");

        long startTime1 = System.nanoTime();
        transactionList1.remove(transaction);
        long endTime1 = System.nanoTime();
        long duration1 = (endTime1 - startTime1);
        System.out.println("LinkedList remove duration: " +duration1);
        result1.append("LinkedList remove duration: " + duration1+"\n");

        long startTime2 = System.nanoTime();
        transactionMap.remove(transaction.getId(),transaction);
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2);
        System.out.println("Remove remove duration: " +duration2);
        result1.append("Map remove duration: " + duration2+"\n");

        long startTime3 = System.nanoTime();
        transactionSet.remove(transaction);
        long endTime3 = System.nanoTime();
        long duration3 = (endTime3 - startTime3);
        System.out.println("Set remove duration: " +duration3);
        result1.append("Set remove duration: " + duration3+"\n");

        long startTime4 = System.nanoTime();
        transactionVector.remove(transaction);
        long endTime4 = System.nanoTime();
        long duration4 = (endTime4 - startTime4);
        System.out.println("Vector remove duration: "+duration4);
        result1.append("Vector remove duration: " + duration4+"\n");

        return result1.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
