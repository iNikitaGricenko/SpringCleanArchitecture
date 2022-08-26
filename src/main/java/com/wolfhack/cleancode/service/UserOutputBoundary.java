package com.wolfhack.cleancode.service;

import com.wolfhack.cleancode.dto.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserOutputBoundary {

    UserResponseDto find(Long id);

    Page<UserResponseDto> findAll(Pageable pageable);
}
