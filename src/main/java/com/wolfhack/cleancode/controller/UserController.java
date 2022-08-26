package com.wolfhack.cleancode.controller;

import com.wolfhack.cleancode.dto.UserRequestDto;
import com.wolfhack.cleancode.dto.UserResponseDto;
import com.wolfhack.cleancode.service.UserInputBoundary;
import com.wolfhack.cleancode.service.UserOutputBoundary;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "User API")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserInputBoundary userInputBoundary;
    private final UserOutputBoundary userOutputBoundary;

    @GetMapping
    @PageableAsQueryParam
    @Parameter(name = "pageable", hidden = true)
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "500", content = @Content)
    public Page<UserResponseDto> findAll(Pageable pageable) {
        return userOutputBoundary.findAll(pageable);
    }

    @GetMapping("/{id}")
    @Parameter(name = "id", example = "1")
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = UserResponseDto.class)))
    @ApiResponse(responseCode = "500", content = @Content)
    public UserResponseDto findById(@PathVariable Long id) {
        return userOutputBoundary.find(id);
    }

    @PostMapping
    @ApiResponse(responseCode = "200", content = @Content)
    public void save(@RequestBody @Valid UserRequestDto requestDto) {
        userInputBoundary.create(requestDto);
    }

}
