package com.SmartBank.model;

import com.SmartBank.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double balance;
    private String accountNumber;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @ManyToOne
    private User user;


}
