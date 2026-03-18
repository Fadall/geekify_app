package com.matchserv.skillink.api.mappers;

import com.matchserv.skillink.api.dto.UserDto;
import com.matchserv.skillink.data.models.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        if (user == null) return null;

        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPoints(user.getPoints());
        dto.setPrivate(user.isPrivate());
        dto.setAuthProvider(user.getAuthProvider());
        dto.setRole(user.getRole());
        dto.setCreatedAt(user.getCreatedAt());

        dto.setAvatarId(user.getAvatar() != null ? user.getAvatar().getId() : null);
        dto.setProjectIds(user.getProjects() != null ?
                user.getProjects().stream().map(Project::getId).collect(Collectors.toList()) : null);

        dto.setSkillIds(user.getSkills() != null ?
                user.getSkills().stream().map(Skill::getId).collect(Collectors.toList()) : null);

        dto.setBadgeIds(user.getBadges() != null ?
                user.getBadges().stream().map(Badge::getId).collect(Collectors.toList()) : null);

        dto.setEventIds(user.getEvents() != null ?
                user.getEvents().stream().map(Event::getId).collect(Collectors.toList()) : null);

        return dto;
    }

    public User toEntity(UserDto dto) {
        if (dto == null) return null;

        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPoints(dto.getPoints());
        user.setPrivate(dto.isPrivate());
        user.setAuthProvider(dto.getAuthProvider());
        user.setRole(dto.getRole());
        user.setCreatedAt(dto.getCreatedAt());

        return user;
    }
}
