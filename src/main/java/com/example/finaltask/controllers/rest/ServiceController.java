package com.example.finaltask.controllers.rest;

import com.example.api.TransactionsApi;
import com.example.dto.Amount;
import com.example.dto.SwiftTransfer;
import com.example.dto.Transaction;
import com.example.dto.Transactions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/statement")
@Slf4j
public class ServiceController implements TransactionsApi {

    @Override
    public ResponseEntity<Transactions> getStatementTransactions(String accountNumber, LocalDateTime statementDate, String curFormat) {
        Transactions transactions = new Transactions().transactions(new ArrayList<>());
        Transaction transaction = new Transaction()
                .transactionId(1)
                .amount(
                        new Amount()
                                .amount(BigDecimal.valueOf(1.01))
                                .currencyName("USD"))
                .swiftTransfer(new SwiftTransfer()
                        .bankOperationCode("CRED"))
                .transactionId(1)
                .uuid(UUID.randomUUID());
        transactions.getTransactions().add(transaction);
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }
}
