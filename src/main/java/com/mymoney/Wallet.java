package com.mymoney;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wallet {
    private Money balance;
    private List<Transaction> history;

    public Wallet() {
        balance = new Money(0);
        history = new ArrayList<>();
    }

    public void topUp(Money amount) {
        if (amount.satang() == 0){
            throw new IllegalArgumentException("Money must be more than 0!");
        }
        balance = balance.plus(amount);
        history.add(new Transaction(TransactionType.TOPUP, amount));
    }

    public void pay(Money amount) {
        if (amount.satang() == 0){
            throw new IllegalArgumentException("Money must be more than 0!");
        }
        if (balance.satang() < amount.satang()) {
            throw new InsufficientFundsException("เงินไม่พอ!");
        } else {
            balance = balance.minus(amount);
            history.add(new Transaction(TransactionType.PAYMENT, amount));
        }
    }

    public Map<TransactionType, Money> getSummary() {
        Map<TransactionType, Money> summary = new HashMap<>();
        summary.put(TransactionType.TOPUP, new Money(0));
        summary.put(TransactionType.PAYMENT, new Money(0));

        for (Transaction t : history) {
            summary.put(t.type(), summary.get(t.type()).plus(t.amount()));
        }

        return summary;
    }

    public Transaction getLargestTransaction() {
        if (history.isEmpty()) {
            return null;
        }

        Transaction largest = history.get(0);
        for (Transaction t : history) {
            if (largest.amount().satang() < t.amount().satang()) {
                largest = t;
            }
        }

        return largest;
    }
}
