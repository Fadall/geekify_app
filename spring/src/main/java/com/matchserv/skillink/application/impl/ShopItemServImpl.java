package com.matchserv.skillink.application.impl;

import com.matchserv.skillink.application.ShopItemService;
import com.matchserv.skillink.data.models.ShopItem;
import com.matchserv.skillink.data.repositories.ShopItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopItemServImpl implements ShopItemService {

    private final ShopItemRepository shopItemRepo;

    @Override
    public ShopItem save(ShopItem shopItem) {
        return shopItemRepo.save(shopItem);
    }

    @Override
    public void delete(ShopItem shopItem) {
        shopItemRepo.delete(shopItem);
    }

    @Override
    public ShopItem findById(Long id) {
        return shopItemRepo.findById(id).orElse(null);
    }

    @Override
    public List<ShopItem> findAll() {
        return shopItemRepo.findAll();
    }
}
