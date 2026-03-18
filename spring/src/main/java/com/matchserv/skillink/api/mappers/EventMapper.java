package com.matchserv.skillink.api.mappers;

import com.matchserv.skillink.api.dto.EventDto;
import com.matchserv.skillink.data.models.Event;
import com.matchserv.skillink.data.models.User;

import java.util.stream.Collectors;

public class EventMapper {

    public static EventDto toDto(Event event) {
        EventDto dto = new EventDto();
        dto.setId(event.getId());
        dto.setTitle(event.getTitle());
        dto.setDescription(event.getDescription());
        dto.setStartDate(event.getStartDate());
        dto.setEndDate(event.getEndDate());
        dto.setPoints(event.getPoints());

        dto.setParticipantIds(event.getParticipants() != null ?
                event.getParticipants().stream().map(User::getId).collect(Collectors.toList()) : null);

        return dto;
    }

    public static Event toEntity(EventDto eventDto) {
        Event event = new Event();
        event.setId(eventDto.getId());
        event.setTitle(eventDto.getTitle());
        event.setDescription(eventDto.getDescription());
        event.setStartDate(eventDto.getStartDate());
        event.setEndDate(eventDto.getEndDate());
        event.setPoints(eventDto.getPoints());
        return event;
    }
}
