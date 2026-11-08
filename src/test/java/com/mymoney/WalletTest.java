package com.mymoney;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    @Test
    void topUpZero_throws() {
        Wallet w = new Wallet();
        assertThrows(IllegalArgumentException.class, () -> w.topUp(new Money(0)));
    }

    @Test
    void payZero_throws() {
        Wallet w = new Wallet();
        assertThrows(IllegalArgumentException.class, () -> w.pay(new Money(0)));
    }

    @Test
    void Happy_path_getSum() {
        Wallet w = new Wallet();
        w.topUp(new Money(100));
        w.pay(new Money(40));
        Map<TransactionType,Money> sum = w.getSummary();
        assertEquals(new Money(100),sum.get(TransactionType.TOPUP));
        assertEquals(new Money(40),sum.get(TransactionType.PAYMENT));
    }

    @Test
    void Bad_path_getSum() {
        Wallet w = new Wallet();
        w.topUp(new Money(100));
        assertThrows(InsufficientFundsException.class, () -> w.pay(new Money(400)));
        Map<TransactionType,Money> sum = w.getSummary();
        assertEquals(new Money(100),sum.get(TransactionType.TOPUP));
        assertEquals(new Money(0),sum.get(TransactionType.PAYMENT));
    }

}
