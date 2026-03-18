package com.matchserv.skillink.application.impl;

import com.matchserv.skillink.application.TransactionService;
import com.matchserv.skillink.data.models.Transaction;
import com.matchserv.skillink.data.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServImpl implements TransactionService {

    private final TransactionRepository transactionRepo;

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepo.save(transaction);
    }

    @Override
    public void delete(Transaction transaction) {
        transactionRepo.delete(transaction);
    }

    @Override
    public Transaction findById(Long id) {
        return transactionRepo.findById(id).orElse(null);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepo.findAll();
    }
}
