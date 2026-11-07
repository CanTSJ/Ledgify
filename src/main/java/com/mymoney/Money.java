package com.mymoney;

public record Money(long satang) {

    public Money {
        if (satang < 0) {
            throw new IllegalArgumentException("Money can't be negative!");
        }
    }

    public Money plus(Money other) {
        long total = Math.addExact(this.satang, other.satang());
        return new Money(total);
    }

    public Money minus(Money other) {
        long dif = Math.subtractExact(this.satang, other.satang());
        return new Money(dif);
    }

    @Override
    public String toString() {
        long baht = this.satang / 100;
        long remainder = this.satang % 100;

        return String.format("%d.%02d baht", baht, remainder);
    }
}
