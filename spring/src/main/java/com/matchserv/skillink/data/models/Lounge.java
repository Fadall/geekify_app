package com.matchserv.skillink.data.models;

import com.matchserv.skillink.bots.data.models.Bot;
import com.matchserv.skillink.messaging.models.ChatMessage;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Lounge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Relations
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChatMessage> messages;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> members;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Bot assistant;
}
