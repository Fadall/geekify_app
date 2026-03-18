package com.matchserv.skillink.api.mappers;

import com.matchserv.skillink.api.dto.LoungeDto;
import com.matchserv.skillink.data.models.*;
import com.matchserv.skillink.messaging.models.ChatMessage;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class LoungeMapper {

    public LoungeDto toDto(Lounge lounge) {
        if (lounge == null) return null;
        LoungeDto dto = new LoungeDto();
        dto.setId(lounge.getId());

        dto.setMessageIds(lounge.getMessages() != null ?
                lounge.getMessages().stream().map(ChatMessage::getId).collect(Collectors.toList()) : null);

        dto.setMemberIds(lounge.getMembers() != null ?
                lounge.getMembers().stream().map(User::getId).collect(Collectors.toList()) : null);

        dto.setAssistantId(lounge.getAssistant() != null ? lounge.getAssistant().getId() : null);
        return dto;
    }

    public Lounge toEntity(LoungeDto dto) {
        if (dto == null) return null;
        Lounge lounge = new Lounge();
        lounge.setId(dto.getId());
        return lounge;
    }
}
