import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 6/17/13
 * Time: 9:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDTO {
    String accountNumber;
    double  amount;
    String des;
    long timeStamp;
    Calendar calendar = Calendar.getInstance();
    public TransactionDTO(String accountNumber, double amount, String des) {
        this.accountNumber=accountNumber;
        this.amount =amount;
        this.des=des;
        timeStamp = calendar.getTimeInMillis();
        //To change body of created methods use File | Settings | File Templates.
    }

    public String getAccount() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public double getAmount() {
        return 0;  //To change body of created methods use File | Settings | File Templates.
    }

    public String getDes() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public long getTimeStamp() {
        return 0;  //To change body of created methods use File | Settings | File Templates.
    }
}
