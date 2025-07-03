package com.SmartBank.observer;
import com.SmartBank.model.User;
import org.springframework.stereotype.Component;

@Component
public class EmailObserver implements TransactionObserver {
    @Override
    public void notify(User user, String message) {
        System.out.println("📧 Sending Email to " + user.getEmail() + ": " + message);
    }
}


