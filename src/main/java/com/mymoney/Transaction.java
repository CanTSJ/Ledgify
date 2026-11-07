package com.mymoney;

public record Transaction(TransactionType type, Money amount) {}
