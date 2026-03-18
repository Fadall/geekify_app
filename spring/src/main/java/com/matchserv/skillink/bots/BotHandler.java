package com.matchserv.skillink.bots;

import com.matchserv.skillink.bots.services.BotService;
import com.matchserv.skillink.bots.data.models.Bot;
import com.matchserv.skillink.data.models.User;
import com.matchserv.skillink.messaging.models.ChatMessage;
import com.matchserv.skillink.messaging.models.enums.ChatType;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class BotHandler {

    private final BotService botService;
    private final SimpMessagingTemplate messagingTemplate;

    public void handleMessage(ChatMessage chatMessage) {
        chatMessage.setTimestamp(LocalDateTime.now());

        User receiver = chatMessage.getReceiver();
        if (receiver != null) {
            Bot bot = botService.getBotByAdminEmail(receiver.getEmail());
            if (bot != null) {
                ChatMessage botReply = new ChatMessage();
                botReply.setSender(null); // ou un User représentant le Bot
                botReply.setReceiver(receiver);
                botReply.setMessage(generateBotMessage(chatMessage.getMessage(), bot));
                botReply.setType(ChatType.BOT);
                botReply.setTimestamp(LocalDateTime.now());

                messagingTemplate.convertAndSendToUser(
                        receiver.getEmail(),
                        "/queue/messages",
                        botReply
                );
            }
        }
    }

    private String generateBotMessage(String userMessage, Bot bot) {
        return "Réponse de " + bot.getName() + ": " + userMessage;
    }
}
