package com.matchserv.skillink.api.dto;

import lombok.Data;
import java.util.List;

@Data
public class LoungeDto {
    private Long id;
    private List<Long> messageIds;
    private List<Long> memberIds;
    private Long assistantId; // Bot
}
