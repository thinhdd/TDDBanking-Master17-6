import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Calendar;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 6/17/13
 * Time: 8:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestTransaction {
    public BankAccountDAO mockDao = mock(BankAccountDAO.class);
    public TransactionDAO mockTDAO = mock(TransactionDAO.class);
    public Calendar calendar = mock(Calendar.class);
    String accountNumber = "12345678";
    @Before
    public void setUp()
    {
        reset(mockDao);
        reset(mockTDAO);
        BankAccount.setBankAccountDAO(mockDao);
        Transaction.setTransactionDAO(mockTDAO);
    }
    @Test
    public void doDepositTest()
    {
        ArgumentCaptor<BankAccountDTO> ac = ArgumentCaptor.forClass(BankAccountDTO.class);
        BankAccountDTO account = BankAccount.openAccount(accountNumber);
        when(mockDao.getAccount(accountNumber)).thenReturn(account);
        BankAccount.doDeposit(accountNumber, 100.0, "Them 100k");
        verify(mockDao, times(2)).save(ac.capture());
        List<BankAccountDTO> list = ac.getAllValues();
        assertEquals(list.get(1).getAccountNumber(), accountNumber);
        assertEquals(list.get(1).getBalance(), 200.0);
    }
    @Test
    public void saveDepositDB()
    {
        BankAccountDTO account = BankAccount.openAccount(accountNumber);
        ArgumentCaptor<TransactionDTO> act = ArgumentCaptor.forClass(TransactionDTO.class);
        TransactionDTO.setCalendar(calendar);
        when(mockDao.getAccount(accountNumber)).thenReturn(account);
        when(calendar.getTimeInMillis()).thenReturn(1000l);
        BankAccount.doDeposit(accountNumber,100.0, "Them 100k");
        verify(mockTDAO).save(act.capture());
        assertEquals(act.getValue().getAccountNumber(), accountNumber );
        assertEquals(act.getValue().getAmount(), 100.0);
        assertEquals(act.getValue().getDes(), "Them 100k");
        assertEquals(act.getValue().getTimeStamp(), 1000l);
    }
}
