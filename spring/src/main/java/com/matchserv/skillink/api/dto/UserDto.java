package com.matchserv.skillink.api.dto;

import com.matchserv.skillink.data.enums.AuthProvider;
import com.matchserv.skillink.data.enums.UserRole;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private int points;
    private boolean isPrivate;
    private AuthProvider authProvider;
    private UserRole role;
    private LocalDate createdAt;
    private Long avatarId;
    private List<Long> projectIds;
    private List<Long> skillIds;
    private List<Long> badgeIds;
    private List<Long> eventIds;
}
