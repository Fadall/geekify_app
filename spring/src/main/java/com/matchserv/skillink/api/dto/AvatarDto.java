package com.matchserv.skillink.api.dto;

import jakarta.persistence.Column;

public class AvatarDto {
    private Long id;
    private String name;
    private String imageUrl;
    private int points;
    private boolean isDefault;
}
