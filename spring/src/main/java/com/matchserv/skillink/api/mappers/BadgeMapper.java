package com.matchserv.skillink.api.mappers;

import com.matchserv.skillink.api.dto.BadgeDto;
import com.matchserv.skillink.data.models.Badge;
import com.matchserv.skillink.data.models.User;

import java.util.stream.Collectors;

public class BadgeMapper {

    public static BadgeDto toDto(Badge badge) {
        if (badge == null) return null;
        BadgeDto dto = new BadgeDto();
        dto.setId(badge.getId());
        dto.setName(badge.getName());
        dto.setDescription(badge.getDescription());
        dto.setImageUrl(badge.getImageUrl());
        dto.setDurationDays(badge.getDurationDays());

        if (badge.getUsers() != null) {
            dto.setUserIds(badge.getUsers()
                    .stream()
                    .map(User::getId)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public static Badge toEntity(BadgeDto dto) {
        if (dto == null) return null;
        Badge badge = new Badge();
        badge.setId(dto.getId());
        badge.setName(dto.getName());
        badge.setDescription(dto.getDescription());
        badge.setImageUrl(dto.getImageUrl());
        badge.setDurationDays(dto.getDurationDays());
        return badge;
    }
}
