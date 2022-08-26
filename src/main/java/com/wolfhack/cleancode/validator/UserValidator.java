package com.wolfhack.cleancode.validator;

import com.wolfhack.cleancode.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserValidator implements UserValidatorInterface {
    @Override
    public void throwIfNotValid(Validator validator) {
        if (validator.isValid()) {
            throw new RuntimeException("Not valid");
        }
    }

    @Override
    public User throwIfNotValidOrGet(Optional<User> user) {
        return user.orElseThrow(RuntimeException::new);
    }
}
