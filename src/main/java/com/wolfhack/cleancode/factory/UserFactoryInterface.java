package com.wolfhack.cleancode.factory;

import com.wolfhack.cleancode.dto.UserRequestDto;
import com.wolfhack.cleancode.dto.UserResponseDto;
import com.wolfhack.cleancode.model.User;
import org.springframework.data.domain.Page;

public interface UserFactoryInterface {

    User create(UserRequestDto request);

    UserResponseDto create(User user);

    Page<User> createUserList(Page<UserRequestDto> request);

    Page<UserResponseDto> createResponseList(Page<User> user);
}
