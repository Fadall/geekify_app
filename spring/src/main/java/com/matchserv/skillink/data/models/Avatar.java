package com.matchserv.skillink.data.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private int points;

    @Column(nullable = false)
    private boolean isDefault;
}
