package com.wolfhack.cleancode.service;

import com.wolfhack.cleancode.dto.UserRequestDto;
import com.wolfhack.cleancode.dto.UserResponseDto;

public interface UserInputBoundary {

    UserResponseDto create(UserRequestDto requestDto);

}
