package com.matchserv.skillink.data.models;

import jakarta.persistence.*;
import lombok.Data;

import com.matchserv.skillink.data.enums.TransacType;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int amount;

    @Enumerated(EnumType.STRING)
    private TransacType type;

    @CreationTimestamp
    private LocalDate date;

    //Relations
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}