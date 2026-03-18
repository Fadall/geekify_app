package com.matchserv.skillink.data.models;

import com.matchserv.skillink.data.enums.TradeStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int points;

    @Enumerated(EnumType.STRING)
    private TradeStatus status;

    //Relations
    @ManyToOne(fetch = FetchType.LAZY)
    private User provider;

    @ManyToOne(fetch = FetchType.LAZY)
    private User requester;
}