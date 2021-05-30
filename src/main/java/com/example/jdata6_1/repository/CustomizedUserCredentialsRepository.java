package com.example.jdata6_1.repository;

import com.example.jdata6_1.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository

public interface CustomizedUserCredentialsRepository extends JpaRepository<UserCredentials, Long> {

    Optional<UserCredentials> findByLoginEquals(String login);

}
