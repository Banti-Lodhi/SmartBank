package com.SmartBank.service;

import com.SmartBank.model.User;
import org.hibernate.resource.transaction.spi.TransactionObserver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private List<TransactionObserver> observers;

    public NotificationService(List<TransactionObserver> observers) {
        this.observers = observers;
    }

    public void notifyAllObservers(User user, String message) {
        observers.forEach(observer -> observer.notify());
    }

    }


