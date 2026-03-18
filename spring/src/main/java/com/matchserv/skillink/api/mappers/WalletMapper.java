package com.matchserv.skillink.api.mappers;

import com.matchserv.skillink.api.dto.WalletDto;
import com.matchserv.skillink.data.models.Wallet;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    public WalletDto toDto(Wallet wallet) {
        if (wallet == null) return null;
        WalletDto dto = new WalletDto();
        dto.setId(wallet.getId());
        dto.setBalance(wallet.getBalance());
        return dto;
    }

    public Wallet toEntity(WalletDto dto) {
        if (dto == null) return null;
        Wallet wallet = new Wallet();
        wallet.setId(dto.getId());
        wallet.setBalance(dto.getBalance());
        return wallet;
    }
}
