package com.SmartBank.strategy;

import com.SmartBank.model.Account;
@FunctionalInterface
public interface TransactionStrategy {
    String transfer(Account from, Account to, double amount);
}
