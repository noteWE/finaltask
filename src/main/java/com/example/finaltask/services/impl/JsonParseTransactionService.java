package com.example.finaltask.services.impl;

import com.example.dto.Amount;
import com.example.dto.SwiftTransfer;
import com.example.dto.Transaction;
import com.example.dto.Transactions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JsonParseTransactionService {

    public final ObjectMapper objectMapper;

    public LocalDateTime parseLocalDateTime(String customDateTimeFormat) {
        String[] dateAndTime = customDateTimeFormat.split(" ");
        if (dateAndTime.length == 2) {
            String[] tempDate = dateAndTime[0].split("-");
            tempDate[0] = "20" + tempDate[0];
            LocalDate date = LocalDate.parse(Arrays.stream(tempDate).reduce((x, y) -> x + "-" + y).orElse(""));
            LocalTime time = LocalTime.parse(dateAndTime[1]);
            return LocalDateTime.of(date, time);
        }
        return LocalDateTime.MIN;
    }

    public SwiftTransfer parseSwiftTransfer(JsonNode jsonNode) {
        JsonNode swiftTransferNode = jsonNode.get("swiftTransfer");
        return new SwiftTransfer()
                .bankOperationCode(
                        swiftTransferNode
                                .hasNonNull("bankOperationCode") ?
                                swiftTransferNode.get("bankOperationCode").asText() : null)
                .beneficiaryBankAccount(
                        swiftTransferNode
                                .hasNonNull("beneficiaryBankAccount") ?
                                swiftTransferNode.get("beneficiaryBankAccount").asText() : null)
                .beneficiaryBankName(
                        swiftTransferNode
                                .hasNonNull("beneficiaryBankName") ?
                                swiftTransferNode.get("beneficiaryBankName").asText() : null)
                .beneficiaryBankOption(
                        swiftTransferNode
                                .hasNonNull("beneficiaryBankOption") ?
                                swiftTransferNode.get("beneficiaryBankOption").asText() : null)
                .beneficiaryCustomerAccount(
                        swiftTransferNode
                                .hasNonNull("beneficiaryCustomerAccount") ?
                                swiftTransferNode.get("beneficiaryCustomerAccount").asText() : null)
                .beneficiaryCustomerName(
                        swiftTransferNode
                                .hasNonNull("beneficiaryCustomerName") ?
                                swiftTransferNode.get("beneficiaryCustomerName").asText() : null)
                .detailsOfCharges(
                        swiftTransferNode
                                .hasNonNull("detailsOfCharges") ?
                                swiftTransferNode.get("detailsOfCharges").asText() : null)
                .exchangeRate(
                        swiftTransferNode
                                .hasNonNull("exchangeRate") ?
                                swiftTransferNode.get("exchangeRate").asText() : null)
                .instructedAmount(
                        swiftTransferNode
                                .hasNonNull("instructedAmount") ?
                                swiftTransferNode.get("instructedAmount").asText() : null)
                .instructionCode(
                        swiftTransferNode
                                .hasNonNull("instructionCode") ?
                                swiftTransferNode.get("instructionCode").asText() : null)
                .intermediaryBankAccount(
                        swiftTransferNode
                                .hasNonNull("intermediaryBankAccount") ?
                                swiftTransferNode.get("intermediaryBankAccount").asText() : null)
                .intermediaryBankName(
                        swiftTransferNode
                                .hasNonNull("intermediaryBankName") ?
                                swiftTransferNode.get("intermediaryBankName").asText() : null)
                .intermediaryBankOption(
                        swiftTransferNode
                                .hasNonNull("intermediaryBankOption") ?
                                swiftTransferNode.get("intermediaryBankOption").asText() : null)
                .messageDestinator(
                        swiftTransferNode
                                .hasNonNull("messageDestinator") ?
                                swiftTransferNode.get("messageDestinator").asText() : null)
                .messageIdentifier(
                        swiftTransferNode
                                .hasNonNull("messageIdentifier") ?
                                swiftTransferNode.get("messageIdentifier").asText() : null)
                .messageOriginator(
                        swiftTransferNode
                                .hasNonNull("messageOriginator") ?
                                swiftTransferNode.get("messageOriginator").asText() : null)
                .messageReceiveTime(
                        swiftTransferNode
                                .hasNonNull("messageReceiveTime") ?
                                parseLocalDateTime(swiftTransferNode.get("messageReceiveTime").asText()) : null)
                .messageSendTime(
                        swiftTransferNode
                                .hasNonNull("messageSendTime") ?
                                parseLocalDateTime(swiftTransferNode.get("messageSendTime").asText()) : null)
                .messageType(
                        swiftTransferNode
                                .hasNonNull("messageType") ?
                                swiftTransferNode.get("messageType").asText() : null)
                .orderingCustomerAccount(
                        swiftTransferNode
                                .hasNonNull("orderingCustomerAccount") ?
                                swiftTransferNode.get("orderingCustomerAccount").asText() : null)
                .orderingCustomerName(
                        swiftTransferNode
                                .hasNonNull("orderingCustomerName") ?
                                swiftTransferNode.get("orderingCustomerName").asText() : null)
                .orderingCustomerOption(
                        swiftTransferNode
                                .hasNonNull("orderingCustomerOption") ?
                                swiftTransferNode.get("orderingCustomerOption").asText() : null)
                .orderingInstitutionAccount(
                        swiftTransferNode
                                .hasNonNull("orderingInstitutionAccount") ?
                                swiftTransferNode.get("orderingInstitutionAccount").asText() : null)
                .orderingInstitutionName(
                        swiftTransferNode
                                .hasNonNull("orderingInstitutionName") ?
                                swiftTransferNode.get("orderingInstitutionName").asText() : null)
                .orderingInstitutionOption(
                        swiftTransferNode
                                .hasNonNull("orderingInstitutionOption") ?
                                swiftTransferNode.get("orderingInstitutionOption").asText() : null)
                .receiverCharges(
                        swiftTransferNode
                                .hasNonNull("receiverCharges") ?
                                swiftTransferNode.get("receiverCharges").asText() : null)
                .receiverCorrespondentAccount(
                        swiftTransferNode
                                .hasNonNull("receiverCorrespondentAccount") ?
                                swiftTransferNode.get("receiverCorrespondentAccount").asText() : null)
                .receiverCorrespondentOption(
                        swiftTransferNode
                                .hasNonNull("receiverCorrespondentOption") ?
                                swiftTransferNode.get("receiverCorrespondentOption").asText() : null)
                .regulatoryReporting(
                        swiftTransferNode
                                .hasNonNull("regulatoryReporting") ?
                                swiftTransferNode.get("regulatoryReporting").asText() : null)
                .remittanceInformation(
                        swiftTransferNode
                                .hasNonNull("remittanceInformation") ?
                                swiftTransferNode.get("remittanceInformation").asText() : null)
                .senderCharges(
                        swiftTransferNode
                                .hasNonNull("senderCharges") ?
                                swiftTransferNode.get("senderCharges").asText() : null)
                .senderCorrespondentAccount(
                        swiftTransferNode
                                .hasNonNull("senderCorrespondentAccount") ?
                                swiftTransferNode.get("senderCorrespondentAccount").asText() : null)
                .senderCorrespondentName(
                        swiftTransferNode
                                .hasNonNull("senderCorrespondentName") ?
                                swiftTransferNode.get("senderCorrespondentName").asText() : null)
                .senderCorrespondentOption(
                        swiftTransferNode
                                .hasNonNull("senderCorrespondentOption") ?
                                swiftTransferNode.get("senderCorrespondentOption").asText() : null)
                .senderToReceiverInformation(
                        swiftTransferNode
                                .hasNonNull("senderToReceiverInformation") ?
                                swiftTransferNode.get("senderToReceiverInformation").asText() : null)
                .valueDataCurrencyInterbankSettledAmount(
                        swiftTransferNode
                                .hasNonNull("") ?
                                swiftTransferNode.get("valueDataCurrencyInterbankSettledAmount").asText() : null)
                .transactionReferenceNumber(
                        swiftTransferNode
                                .hasNonNull("valueDataCurrencyInterbankSettledAmount") ?
                                swiftTransferNode.get("transactionReferenceNumber").asText() : null)
                .transactionRelatedReference(
                        swiftTransferNode
                                .hasNonNull("transactionRelatedReference") ?
                                swiftTransferNode.get("transactionRelatedReference").asText() : null)
                .transactionTypeCode(
                        swiftTransferNode
                                .hasNonNull("transactionTypeCode") ?
                                swiftTransferNode.get("transactionTypeCode").asText() : null)
                .urgent(
                        swiftTransferNode
                                .hasNonNull("urgent") ?
                                swiftTransferNode.get("urgent").asText() : null);
    }

    public Amount parseAmount(JsonNode jsonNode) {
        JsonNode amountNode = jsonNode.get("amount");
        return new Amount()
                .amount(amountNode.get("amount").decimalValue())
                .currencyName(amountNode.get("currencyName").asText());
    }

    public Transaction parseTransaction(JsonNode jsonNode) {
        Amount amount = parseAmount(jsonNode);
        String correspondingAccount = jsonNode.get("correspondingAccount").asText();
        UUID uuidTransaction = UUID.fromString(jsonNode.get("uuid").asText());
        Integer transactionId = jsonNode.get("transactionId").asInt();
        SwiftTransfer swiftTransfer = parseSwiftTransfer(jsonNode);
        return new Transaction()
                .swiftTransfer(swiftTransfer)
                .amount(amount)
                .correspondingAccount(correspondingAccount)
                .uuid(uuidTransaction)
                .transactionId(transactionId);
    }

    public Transactions parseTransactions(String jsonString) throws JsonProcessingException {
        JsonNode root = objectMapper.readTree(jsonString);
        Transactions transactions = new Transactions().transactions(new ArrayList<>());
        if (root.isArray()) {
            for (JsonNode jsonNode : root) {
                transactions.getTransactions().add(parseTransaction(jsonNode));
            }
        }
        return transactions;
    }
}
