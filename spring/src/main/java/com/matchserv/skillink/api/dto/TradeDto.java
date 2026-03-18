package com.matchserv.skillink.api.dto;

import com.matchserv.skillink.data.enums.TradeStatus;
import lombok.Data;

@Data
public class TradeDto {
    private Long id;
    private int points;
    private TradeStatus status;
    private Long providerId;
    private Long requesterId;
}
