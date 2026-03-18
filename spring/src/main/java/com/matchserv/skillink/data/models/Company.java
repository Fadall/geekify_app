package com.matchserv.skillink.data.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Company {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String contactMail;

    //Relations
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Wallet wallet;
}