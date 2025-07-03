package com.SmartBank.service;

import com.SmartBank.dto.TransferDto;
import com.SmartBank.model.Account;
import com.SmartBank.repository.AccountRepository;
import com.SmartBank.repository.TransactionalRepository;
import com.SmartBank.strategy.TransactionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionalRepository transactionalRepository;
    @Autowired
    private List<TransactionStrategy> strategies;

public String transfer(TransferDto dto) {
    Account from = accountRepository.findByAccountNumber(dto.getFromAccountNumber()).orElseThrow();
    Account to = accountRepository.findByAccountNumber(dto.getToAccountNumber()).orElseThrow();

    TransactionStrategy strategy = strategies.stream().filter(s -> s.getClass().getSimpleName()
                    .startsWith(dto.getTranserType()))
            .findFirst().orElseThrow();
    return strategy.transfer(from, to, dto.getAmount());
}

}
