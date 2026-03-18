package com.matchserv.skillink.messaging.controllers.rest;

import com.matchserv.skillink.messaging.models.ChatMessage;
import com.matchserv.skillink.messaging.services.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatRestController {

    private final ChatService chatService;

    // Récupérer l'historique complet
    @GetMapping("/history")
    public List<ChatMessage> getHistory() {
        return chatService.getHistory();
    }
}
