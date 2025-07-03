package com.SmartBank.observer;

import com.SmartBank.model.User;
import org.springframework.stereotype.Component;

@Component
public class SmsObserverx implements TransactionObserver {
    @Override
    public void notify(User user, String message) {
        System.out.println("📱 Sending SMS to " + user.getPhone() + ": " + message);
    }
}
