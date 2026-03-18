package com.matchserv.skillink.messaging.services;

import com.matchserv.skillink.messaging.models.ChatMessage;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class ChatService {
    private final List<ChatMessage> history = new ArrayList<>();

    public void saveMessage(ChatMessage message) {
        history.add(message);
    }

    public List<ChatMessage> getHistory() {
        return new ArrayList<>(history);
    }
}
