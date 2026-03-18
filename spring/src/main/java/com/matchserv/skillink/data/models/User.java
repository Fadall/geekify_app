package com.matchserv.skillink.data.models;

import com.matchserv.skillink.data.enums.*;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String passwordHash;

    @Column(nullable = false)
    private int points = 0;

    private boolean isPrivate = false;

    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @CreationTimestamp
    private LocalDate createdAt;

    //Relations
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Project> projects;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Skill> skills;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Badge> badges;

    @ManyToMany(mappedBy = "participants")
    private List<Event> events;

    @ManyToOne
    private Avatar avatar;
}