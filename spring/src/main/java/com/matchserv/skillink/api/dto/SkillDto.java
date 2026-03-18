package com.matchserv.skillink.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class SkillDto {
    private Long id;
    private String name;
    private String category;
    private List<Long> userIds;
    private List<Long> projectIds;
}
