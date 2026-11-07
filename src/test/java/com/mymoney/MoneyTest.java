package com.mymoney;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void createNegative_throws() {
        assertThrows(IllegalArgumentException.class, () -> new Money(-1));
    }

    @Test
    void toString_5satang() {
        Money m = new Money(5000);
        assertEquals("50.00 baht", m.toString());
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