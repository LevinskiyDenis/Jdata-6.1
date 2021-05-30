package com.example.jdata6_1.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomizedUserDetails implements UserDetails {

    UserCredentials userCredentials;

    public CustomizedUserDetails(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = List.of(new SimpleGrantedAuthority(userCredentials.getRole()));
        System.out.println(list);
        return list;
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
