package com.matchserv.skillink.messaging.controllers;

import com.matchserv.skillink.bots.BotHandler;
import com.matchserv.skillink.bots.data.models.Bot;
import com.matchserv.skillink.bots.services.BotService;
import com.matchserv.skillink.data.models.User;
import com.matchserv.skillink.integration.ai.BotIntegrationService;
import com.matchserv.skillink.messaging.models.ChatMessage;
import com.matchserv.skillink.messaging.models.enums.ChatType;
import com.matchserv.skillink.messaging.services.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final BotHandler botHandler;
    private final ChatService chatService;
    private final BotService botService;
    private final BotIntegrationService botIntegrationService;

    // Réception de message
    @MessageMapping("/chat.send")
    public void sendMessage(@Payload ChatMessage message) {
        message.setTimestamp(LocalDateTime.now());
        chatService.saveMessage(message);
        if(message.getReceiver() == null)
        {
            // broadcast public
            messagingTemplate.convertAndSend("/topic/public", message);
        } else {
            // envoi privé
            // envoi direct au destinataire
            messagingTemplate.convertAndSendToUser(
                    message.getReceiver().getEmail(),
                    "/queue/messages",
                    message
            );
        }
        botHandler.handleMessage(message);
    }


    // Notification de connexion
    @MessageMapping("/chat.addUser")
    public void addUser(@Payload ChatMessage message) {
        message.setTimestamp(LocalDateTime.now());
        message.setType(ChatType.JOIN);

        chatService.saveMessage(message);
        messagingTemplate.convertAndSend("/topic/public", message);
    }

    @PostMapping("/sendBotMessage")
    public void handleBot(ChatMessage message) {
        User modo = message.getReceiver();
        Bot bot = botService.getBotByAdmin(modo);
        User botUser = bot.getAdmin();
        String botName = bot.getName();
        String botReply = botIntegrationService.getBotResponse(message, botName);

        ChatMessage botMessage = new ChatMessage();
        botMessage.setSender(botUser);
        botMessage.setReceiver(message.getSender());
        botMessage.setMessage(botReply);

        chatService.saveMessage(botMessage);
        messagingTemplate.convertAndSendToUser(
                message.getSender().getEmail(),
                "/queue/messages",
                botMessage
        );
    }
}
