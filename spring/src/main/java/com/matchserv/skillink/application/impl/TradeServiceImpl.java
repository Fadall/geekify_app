package com.matchserv.skillink.application.impl;

import com.matchserv.skillink.application.TradeService;
import com.matchserv.skillink.data.models.Trade;
import com.matchserv.skillink.data.repositories.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TradeServiceImpl implements TradeService {

    private final TradeRepository tradeRepo;

    @Override
    public Trade save(Trade trade) {
        return tradeRepo.save(trade);
    }

    @Override
    public void delete(Trade trade) {
        tradeRepo.delete(trade);
    }

    @Override
    public Trade findById(Long id) {
        return tradeRepo.findById(id).orElse(null);
    }

    @Override
    public List<Trade> findAll() {
        return tradeRepo.findAll();
    }
}
