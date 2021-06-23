package com.example.finaltask.controllers.rest;

import com.example.api.TransactionsApi;
import com.example.dto.Transactions;
import com.example.finaltask.services.TransactionsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/statement")
@Slf4j
@RequiredArgsConstructor
public class ServiceController implements TransactionsApi {

    private final TransactionsService service;

    @Override
    public ResponseEntity<Transactions> getStatementTransactions(String accountNumber, LocalDateTime statementDate, String curFormat) {
        return ResponseEntity.ok(service.getTransactions(accountNumber, statementDate));
    }
}
