package com.wolfhack.cleancode.validator;

import com.wolfhack.cleancode.model.User;

import java.util.Optional;

public interface UserValidatorInterface {

    void throwIfNotValid(Validator validator);

    User throwIfNotValidOrGet(Optional<User> user);
}
