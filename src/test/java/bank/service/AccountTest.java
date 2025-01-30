package bank.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDate;


public class AccountTest  {
    Account account;
    Statement statement;

    @BeforeEach
    public void setUp() throws Exception {
        statement = new Statement();
        account = new Account(statement);
    }

    @Test
    public void acceptanceTest(){
        LocalDate fixedDate1 = LocalDate.of(2012, 1, 10);
        LocalDate fixedDate2 = LocalDate.of(2012, 1, 13);
        LocalDate fixedDate3 = LocalDate.of(2012, 1, 14);

        try (MockedStatic<LocalDate> mockedLocalDate = Mockito.mockStatic(LocalDate.class)) {
            mockedLocalDate.when(LocalDate::now)
                    .thenReturn(fixedDate1)
                    .thenReturn(fixedDate2)
                    .thenReturn(fixedDate3);

            // Perform operations
            account.deposit(1000);
            account.deposit(2000);
            account.withdraw(500);
            account.printStatement();

            var expectedOutput ="Date       || Amount || Balance\n" +
                    "14/01/2012 || -500   || 2500\n" +
                    "13/01/2012 || 2000   || 3000\n" +
                    "10/01/2012 || 1000   || 1000\n";
            Assertions.assertEquals(expectedOutput,  statement.toString(), "failure - strings are not equal");
        }
    }
}