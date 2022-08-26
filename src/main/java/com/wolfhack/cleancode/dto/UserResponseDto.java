package com.wolfhack.cleancode.dto;

import com.wolfhack.cleancode.model.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserResponseDto implements Serializable {
    @Schema(example = "1")
    private final Long id;
    @Schema(example = "test@domain.com")
    private final String login;
    @Schema(example = "User")
    private final Role role;
    private final LocalDateTime createdAt;
}
