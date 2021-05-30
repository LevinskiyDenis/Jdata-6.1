package com.example.jdata6_1.service;

import com.example.jdata6_1.entity.CustomizedUserDetails;
import com.example.jdata6_1.repository.CustomizedUserCredentialsRepository;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Data
@org.springframework.stereotype.Service

public class UserCredentialsService implements UserDetailsService {

    private final CustomizedUserCredentialsRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        CustomizedUserDetails userDetails = new CustomizedUserDetails(repository.findByLoginEquals(s).orElseThrow(() -> new UsernameNotFoundException("Username not found")));
        return userDetails;
    }

}
