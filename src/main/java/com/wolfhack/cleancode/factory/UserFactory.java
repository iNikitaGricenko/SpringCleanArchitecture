package com.wolfhack.cleancode.factory;

import com.wolfhack.cleancode.dto.UserRequestDto;
import com.wolfhack.cleancode.dto.UserResponseDto;
import com.wolfhack.cleancode.factory.mapper.UserMapper;
import com.wolfhack.cleancode.model.Role;
import com.wolfhack.cleancode.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserFactory implements UserFactoryInterface {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User create(UserRequestDto request) {
        User user = userMapper.convertRequestToUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        return user;
    }

    @Override
    public UserResponseDto create(User user) {
        return userMapper.convertUserToResponse(user);
    }

    @Override
    public Page<User> createUserList(Page<UserRequestDto> request) {
        return request.map(userMapper::convertRequestToUser).map(user -> {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return user;
        });
    }

    @Override
    public Page<UserResponseDto> createResponseList(Page<User> user) {
        return user.map(userMapper::convertUserToResponse);
    }
}
