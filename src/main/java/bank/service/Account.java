package bank.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account implements AccountService {
    private int balance;
    private final Statement statement;
    private final List<Transaction> transactions =new ArrayList<Transaction>();
    public Account(Statement statement) {
        this.statement = statement;
    }
    @Override
    public void deposit(int amount ) {
        if (amount <= 0) { throw new IllegalArgumentException("Amount must be greater than 0"); }
        balance += amount;
        transactions.add(new Transaction(amount, LocalDate.now()));
    }

    @Override
    public void withdraw(int amount) {

        if (amount <= 0) { throw new IllegalArgumentException("Amount must be greater than 0"); }
        if (amount > balance) { throw new IllegalArgumentException("Amount must be less than balance"); }
        balance -= amount;
        transactions.add(new Transaction(-amount,LocalDate.now()));
    }

    @Override
    public void printStatement() {
        statement.print(transactions);
    }
}

