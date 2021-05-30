package com.example.jdata6_1.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Set;


public class CustomizedUserDetails implements UserDetails {

    UserCredentials userCredentials;

    public CustomizedUserDetails(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<? extends GrantedAuthority> authorities = userCredentials.getRole().getOperations();
        // List<GrantedAuthority> list = List.of(new SimpleGrantedAuthority(userCredentials.getRole()));
        //  List<GrantedAuthority> list = List.of(new SimpleGrantedAuthority("Yeah"));
        System.out.println(authorities);
        return authorities;
    }

    @Override
    public String getPassword() {
        return userCredentials.getPassword();
    }

    @Override
    public String getUsername() {
        return userCredentials.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userCredentials.isIsAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userCredentials.isIsAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userCredentials.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return userCredentials.isEnabled();
    }
}
