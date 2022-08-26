package com.wolfhack.cleancode.gateway;

import com.wolfhack.cleancode.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserRepositoryGateway {
    Optional<User> findByLogin(String login);

    User save(User user);

    Optional<User> findById(Long id);

    Page<User> findByAll(Pageable pageable);
}
