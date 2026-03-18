package com.matchserv.skillink.api.mappers;

import com.matchserv.skillink.api.dto.TradeDto;
import com.matchserv.skillink.data.models.Trade;

public class TradeMapper {

    public static TradeDto toDto(Trade trade) {
        TradeDto dto = new TradeDto();
        dto.setId(trade.getId());
        dto.setPoints(trade.getPoints());
        dto.setStatus(trade.getStatus());
        dto.setProviderId(trade.getProvider() != null ? trade.getProvider().getId() : null);
        dto.setRequesterId(trade.getRequester() != null ? trade.getRequester().getId() : null);
        return dto;
    }

    public static Trade toEntity(TradeDto tradeDto) {
        Trade trade = new Trade();
        trade.setId(tradeDto.getId());
        trade.setPoints(tradeDto.getPoints());
        trade.setStatus(tradeDto.getStatus());

        return trade;
    }
}
