package com.matchserv.skillink.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectDto {
    private Long id;
    private String title;
    private String description;
    private int points;
    private Long ownerId;
    private Long categoryId;
    private List<Long> participantIds;
}
