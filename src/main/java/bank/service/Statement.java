package bank.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class Statement {
    StringBuilder statement=new StringBuilder();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static final String STATEMENT_HEADER = "Date       || Amount || Balance";
    public void print(List<Transaction> transactions){
            statement.append(STATEMENT_HEADER);
            statement.append("\n");
            int balance= transactions.stream()
                    .map(Transaction::amount)
                    .mapToInt(Integer::intValue)
                    .sum();
            for(int i=transactions.size()-1; i>=0 ; i--){
                statement.append(transactions.get(i).date().format(formatter))
                        .append(" || ")
                        .append(transactions.get(i).amount())
                        .append("   || ")
                        .append(balance).append('\n');
                balance-=transactions.get(i).amount();
            }
    }
    private void clearStatement(){
        statement=new StringBuilder();
    }
    public String toString(){
        return statement.toString();
    }
}
