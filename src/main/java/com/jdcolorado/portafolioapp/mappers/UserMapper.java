package com.jdcolorado.portafolioapp.mappers;

import com.jdcolorado.portafolioapp.dto.UserDto;
import com.jdcolorado.portafolioapp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user){
        UserDto userDto = new UserDto();

        userDto.setUsername(user.getUsername());

        return userDto;
    }

    public User toEntity(UserDto userDto){

        User user = new User();

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        return user;
    }
}
