package com.example.finaltask.services.impl;

import com.example.dto.Transactions;
import com.example.finaltask.exceptions.NotFoundServiceException;
import com.example.finaltask.exceptions.NotValidResponseException;
import com.example.finaltask.exceptions.ServiceBadRequestException;
import com.example.finaltask.services.TransactionsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionsServiceImpl implements TransactionsService {

    private final RestTemplate restTemplate;
    private final JsonParseTransactionService parseTransactionService;
    @Value("${a_iDa_012.url}")
    private String serviceUrl;

    @Override
    public Transactions getTransactions(String accountNumber, LocalDateTime statementDate) {
        ResponseEntity<String> responseEntity;
        responseEntity = restTemplate
                .getForEntity(String.format("%s/account/%s/transactions?statementDate=%s",
                        serviceUrl,
                        accountNumber,
                        statementDate.format(DateTimeFormatter.ISO_DATE_TIME)),
                        String.class);
        log.info(String.format("Response from service. Status: %s, body: %s",responseEntity.getStatusCode(), responseEntity.getBody()));
        switch (responseEntity.getStatusCode()) {
            case OK: {
                try {
                    return parseTransactionService.parseTransactions(responseEntity.getBody());
                } catch (JsonProcessingException e) {
                    throw new NotValidResponseException("Response of service isn`t valid", e);
                }
            }
            case NOT_FOUND:
                throw new NotFoundServiceException(String.format("Transactions by account: %s and date: %s not found",
                        accountNumber, statementDate.format(DateTimeFormatter.ISO_DATE_TIME)));
            case BAD_REQUEST:
                throw new ServiceBadRequestException(String.format("Bad request by account: %s and date: %s",
                        accountNumber, statementDate.format(DateTimeFormatter.ISO_DATE_TIME)));
            default:
                return new Transactions();
        }
    }
}
