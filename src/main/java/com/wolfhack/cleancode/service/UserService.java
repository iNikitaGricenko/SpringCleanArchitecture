package com.wolfhack.cleancode.service;

import com.wolfhack.cleancode.dto.UserRequestDto;
import com.wolfhack.cleancode.dto.UserResponseDto;
import com.wolfhack.cleancode.factory.UserFactoryInterface;
import com.wolfhack.cleancode.gateway.UserRepositoryGateway;
import com.wolfhack.cleancode.model.User;
import com.wolfhack.cleancode.validator.UserValidatorInterface;
import com.wolfhack.cleancode.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserInputBoundary, UserOutputBoundary {

    private final UserFactoryInterface userFactory;
    private final UserRepositoryGateway userGateway;
    private final UserValidatorInterface userValidator;

    @Override
    public UserResponseDto create(UserRequestDto requestDto) {
        userValidator.throwIfNotValid(isPresentByLogin(requestDto));
        userValidator.throwIfNotValid(isPasswordIsValid(requestDto));
        return userFactory.create(
                userGateway.save(
                        userFactory.create(requestDto)));
    }

    @Override
    public UserResponseDto find(Long id) {
        return userFactory.create(userValidator.throwIfNotValidOrGet(userGateway.findById(id)));
    }

    @Override
    public Page<UserResponseDto> findAll(Pageable pageable) {
        return userFactory.createResponseList(userGateway.findByAll(pageable));
    }

    private Validator isPasswordIsValid(UserRequestDto requestDto) {
        return () -> requestDto.getPassword().length() < 5;
    }

    private Validator isPresentByLogin(UserRequestDto requestDto) {
        return () -> userGateway.findByLogin(requestDto.getLogin()).isPresent();
    }
}
