package com.example.jdata6_1.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @Column(columnDefinition = "boolean default true")
    boolean IsAccountNonExpired;

    @Column(columnDefinition = "boolean default true")
    boolean IsAccountNonLocked;

    @Column(columnDefinition = "boolean default true")
    boolean isCredentialsNonExpired;

    @Column(columnDefinition = "boolean default true")
    boolean isEnabled;


}
