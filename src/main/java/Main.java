import bank.service.Account;
import bank.service.Statement;

public class Main {
    public static void main(String[] args) {
        var statement =  new Statement();
        var account = new Account(statement);
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.printStatement();
        System.out.println(statement);
    }
}
