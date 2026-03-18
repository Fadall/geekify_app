package com.matchserv.skillink.api.dto;

import com.matchserv.skillink.data.enums.ItemType;

import java.util.List;

public class ShopItemDto {
    private Long id;
    private String name;
    private ItemType type;
    private int pricePoints;
    private Long avatarId;
    private Long badgeId;
}
