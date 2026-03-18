package com.matchserv.skillink.api.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EventDto {
    private Long id;
    private String title;
    private String description;
    private int points;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Long> participantIds;
}
