package com.matchserv.skillink.integration.ai;

import com.matchserv.skillink.messaging.models.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BotIntegrationService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String getBotResponse(ChatMessage message, String botName) {
        String url = "http://localhost:8000/bots/reply";

        Map<String, Object> body = new HashMap<>();
        body.put("sender", message.getSender().getUsername());
        body.put("receiver", message.getReceiver().getUsername());
        body.put("content", message.getMessage());
        body.put("bot_name", botName);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return (String) Objects.requireNonNull(response.getBody()).get("content");
        }
        return "Le bot est indisponible pour le moment.";
    }
}
