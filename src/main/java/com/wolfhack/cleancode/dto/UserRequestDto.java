package com.wolfhack.cleancode.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserRequestDto implements Serializable {
    @NotNull
    @Schema(example = "test@domain.com")
    private final String login;
    @NotNull
    @Schema(example = "password")
    private final String password;
}
