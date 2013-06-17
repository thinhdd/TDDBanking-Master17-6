import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;

/**
 * Created with IntelliJ IDEA.
 * User: thinhdd
 * Date: 6/17/13
 * Time: 1:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestAccount {
    BankAccountDAO mockDao= mock(BankAccountDAO.class);
    public String accountNumber = "12345678";
    @Before
    public void SetUp(){
        reset(mockDao);
        BankAccount.setBankAccountDAO(mockDao);
    }
    @Test
    public void openAccount()
    {
        ArgumentCaptor<BankAccountDTO> ac = ArgumentCaptor.forClass(BankAccountDTO.class);
        BankAccountDTO account = BankAccount.openAccount(accountNumber);
        verify(mockDao).save(ac.capture());
        assertEquals( ac.getValue().getAccountNumber(), accountNumber);
        assertEquals(ac.getValue().getBalance(), 100.0, 0.01 );
    }
}
