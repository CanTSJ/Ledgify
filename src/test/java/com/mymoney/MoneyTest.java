package com.mymoney;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void createNegativeMoney_throws() {
        assertThrows(IllegalArgumentException.class, () -> new Money(-1));
    }

    @Test
    void toString_5satang() {
        Money m = new Money(5);
        assertEquals("0.05 baht", m.toString());
    }

    @Test
    void MinusResultsInNegative() {
        Money a = new Money(100);
        Money b = new Money(500);
        assertThrows(IllegalArgumentException.class, () -> a.minus(b));
    }

    @Test
    void plusOverflow_throws() {
        Money big = new Money(Long.MAX_VALUE);
        assertThrows(ArithmeticException.class, () -> big.plus(new Money(1)));
    }
}