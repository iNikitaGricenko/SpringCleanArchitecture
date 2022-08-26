package com.wolfhack.cleancode.gateway;

import com.wolfhack.cleancode.model.User;
import com.wolfhack.cleancode.gateway.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserGateway implements UserRepositoryGateway {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User save(User user) {
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Page<User> findByAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
