package com.example.jdata6_1.config;

import com.example.jdata6_1.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserCredentialsService userCredentialsService;

    @Autowired
    public WebSecurityConfig(UserCredentialsService userCredentialsService) {
        this.userCredentialsService = userCredentialsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.inMemoryAuthentication().withUser("Denis").password("{noop}123345").roles("READ");

        auth.userDetailsService(userCredentialsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/persons/by-city").permitAll()
                .anyRequest().authenticated();

        http.formLogin();
    }
}
