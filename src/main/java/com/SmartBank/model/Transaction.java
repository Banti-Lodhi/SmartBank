package com.SmartBank.model;

import com.SmartBank.enums.TransactionType;
import jakarta.persistence.EnumType;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private LocalDateTime localDateTime;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @ManyToOne
    private Account sourceAccount;
    @ManyToOne
    private Account destinateionAccount;
}
