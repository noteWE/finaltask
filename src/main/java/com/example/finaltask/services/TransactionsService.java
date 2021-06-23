package com.example.finaltask.services;

import com.example.dto.Transactions;

import java.time.LocalDateTime;

public interface TransactionsService {
    Transactions getTransactions(String accountNumber, LocalDateTime statementDate);
}
