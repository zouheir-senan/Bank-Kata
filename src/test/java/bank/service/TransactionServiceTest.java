package bank.service;



import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class TransactionServiceTest {
    @Test
    public void testFixedDateWithClock() {

        LocalDate fixedDate1 = LocalDate.of(2012, 1, 10);
        LocalDate fixedDate2 = LocalDate.of(2012, 1, 13);
        LocalDate fixedDate3 = LocalDate.of(2012, 1, 14);

        try (MockedStatic<LocalDate> mockedLocalDate = Mockito.mockStatic(LocalDate.class)) {
            mockedLocalDate.when(LocalDate::now).thenReturn(fixedDate1, fixedDate2, fixedDate3);
            var statement = new Statement();
            var account = new Account(statement);
            account.deposit(1000);
            account.deposit(2000);
            account.withdraw(500);
            account.printStatement();

            System.out.println(statement);
        }

    }
}
