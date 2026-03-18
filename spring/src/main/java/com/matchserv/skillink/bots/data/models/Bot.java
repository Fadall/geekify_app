package com.matchserv.skillink.bots.data.models;

import com.matchserv.skillink.data.models.Avatar;
import com.matchserv.skillink.data.models.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Bot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String style;

    @Column(nullable = false, length = 2000)
    private String histoire;


    //Relations
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User admin;

    @OneToOne
    private Avatar avatar;
}
