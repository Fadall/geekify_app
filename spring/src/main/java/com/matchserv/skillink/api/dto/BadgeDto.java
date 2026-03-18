package com.matchserv.skillink.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class BadgeDto {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private int durationDays;
    private List<Long> userIds; // on renvoie uniquement les ids des utilisateurs
}
