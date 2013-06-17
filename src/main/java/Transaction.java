/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 6/17/13
 * Time: 8:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    static TransactionDAO transactionDAO;
    public static void setTransactionDAO(TransactionDAO mockTDAO) {
        transactionDAO = mockTDAO;
        //To change body of created methods use File | Settings | File Templates.
    }

    public static void createTransactionDTO(String accountNumber, double amount, String des) {
        TransactionDTO transaction = new TransactionDTO(accountNumber, amount, des);
        //To change body of created methods use File | Settings | File Templates.
    }
}
