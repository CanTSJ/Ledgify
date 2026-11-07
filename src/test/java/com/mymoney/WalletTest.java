package com.mymoney;

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
}
