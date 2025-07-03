package com.SmartBank.observer;

import com.SmartBank.model.User;

public class EmailNotificationObserver implements TransactionObserver{
    @Override
    public void notify(User user, String message) {
        System.out.println("Email sent to " + user.getEmail() + ": " + message);
    }
}
