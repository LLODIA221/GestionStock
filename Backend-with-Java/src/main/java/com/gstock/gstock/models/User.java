package com.gstock.gstock.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Journal> journaux;

    public User() {
    }

    public User(String userName, String userPassword, Role role) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.role = role;
    }

    // Énumération Role
    public enum Role {
        ADMINISTRATEUR,
        UTILISATEUR
    }
}