package com.wolfhack.cleancode.factory.mapper;

import com.wolfhack.cleancode.dto.UserRequestDto;
import com.wolfhack.cleancode.dto.UserResponseDto;
import com.wolfhack.cleancode.model.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    UserResponseDto convertUserToResponse(User user);

    User convertRequestToUser(UserRequestDto userRequestDto);

}
