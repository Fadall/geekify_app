package com.matchserv.skillink.api.dto;

import com.matchserv.skillink.data.enums.TransacType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionDto {
    private Long id;
    private int amount;
    private TransacType type;
    private LocalDate date;
    private Long userId;
}
