/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 6/17/13
 * Time: 1:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    static BankAccountDAO bankAccountDAO;
    public static void setBankAccountDAO(BankAccountDAO mockDao) {
        bankAccountDAO = mockDao;
        //To change body of created methods use File | Settings | File Templates.
    }

    public static BankAccountDTO openAccount(String accountNumber) {
        BankAccountDTO account = new BankAccountDTO(accountNumber);
        bankAccountDAO.save(account);
        return account;  //To change body of created methods use File | Settings | File Templates.
    }

    public static BankAccountDTO getAccount(String accountNumber) {
        BankAccountDTO account = bankAccountDAO.getAccount(accountNumber);
        return account;  //To change body of created methods use File | Settings | File Templates.
    }
}
