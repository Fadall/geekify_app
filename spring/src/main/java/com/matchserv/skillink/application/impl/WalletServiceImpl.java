package com.matchserv.skillink.application.impl;

import com.matchserv.skillink.application.WalletService;
import com.matchserv.skillink.data.models.Wallet;
import com.matchserv.skillink.data.repositories.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepo;

    @Override
    public Wallet save(Wallet wallet) {
        return walletRepo.save(wallet);
    }

    @Override
    public void delete(Wallet wallet) {
        walletRepo.delete(wallet);
    }

    @Override
    public Wallet findById(Long id) {
        return walletRepo.findById(id).orElse(null);
    }

    @Override
    public List<Wallet> findAll() {
        return walletRepo.findAll();
    }
}
