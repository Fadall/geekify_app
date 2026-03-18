package com.matchserv.skillink.api.mappers;

import com.matchserv.skillink.api.dto.TransactionDto;
import com.matchserv.skillink.data.models.Transaction;

public class TransactionMapper {

    public static TransactionDto toDto(Transaction transaction) {
        TransactionDto dto = new TransactionDto();
        dto.setId(transaction.getId());
        dto.setAmount(transaction.getAmount());
        dto.setDate(transaction.getDate());
        dto.setType(transaction.getType());
        dto.setUserId(transaction.getUser() != null ? transaction.getUser().getId() : null);
        return dto;
    }

    public static Transaction toEntity(TransactionDto dto) {
        Transaction transaction = new Transaction();
        transaction.setId(dto.getId());
        transaction.setAmount(dto.getAmount());
        transaction.setDate(dto.getDate());
        transaction.setType(dto.getType());
        return transaction;
    }
}
