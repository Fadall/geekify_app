package com.matchserv.skillink.api.controllers;

import com.matchserv.skillink.api.dto.WalletDto;
import com.matchserv.skillink.api.mappers.WalletMapper;
import com.matchserv.skillink.data.models.Wallet;
import com.matchserv.skillink.data.repositories.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;

    @GetMapping
    public List<WalletDto> getAll() {
        return walletRepository.findAll().stream()
                .map(walletMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WalletDto> getById(@PathVariable Long id) {
        return walletRepository.findById(id)
                .map(walletMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<WalletDto> create(@RequestBody WalletDto dto) {
        Wallet wallet = walletMapper.toEntity(dto);
        Wallet saved = walletRepository.save(wallet);
        return ResponseEntity.ok(walletMapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WalletDto> update(@PathVariable Long id, @RequestBody WalletDto dto) {
        return walletRepository.findById(id)
                .map(existing -> {
                    existing.setBalance(dto.getBalance());
                    Wallet updated = walletRepository.save(existing);
                    return ResponseEntity.ok(walletMapper.toDto(updated));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!walletRepository.existsById(id)) return ResponseEntity.notFound().build();
        walletRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
