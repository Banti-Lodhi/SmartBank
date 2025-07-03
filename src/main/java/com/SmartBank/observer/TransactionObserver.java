package com.SmartBank.observer;


import com.SmartBank.model.User;

public interface TransactionObserver {
    void notify(User user, String message);
}

