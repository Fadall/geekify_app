package com.matchserv.skillink.messaging.models;

import com.matchserv.skillink.data.models.User;
import com.matchserv.skillink.messaging.models.enums.ChatType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2000)
    private String message;

    @Enumerated(EnumType.STRING)
    private ChatType type;

    private LocalDateTime timestamp;

    private boolean isBot = false;

    private String botName; // nom du bot si isBot = true

    //Relations
    @ManyToOne(fetch = FetchType.LAZY)
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    private User receiver;
}
