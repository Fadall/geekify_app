package com.matchserv.skillink.data.models;

import com.matchserv.skillink.data.enums.ItemType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ShopItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private ItemType type; // AVATAR, BADGE, AUTRE

    private int pricePoints;

    @ManyToOne
    private Avatar avatar; // si type = AVATAR

    @ManyToOne
    private Badge badge; // si type = BADGE
}
