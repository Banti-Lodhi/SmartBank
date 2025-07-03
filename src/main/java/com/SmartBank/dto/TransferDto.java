package com.SmartBank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDto {
    private String fromAccountNumber;
    private String toAccountNumber;
    private double amount;
    private String transerType;
}
