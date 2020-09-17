package com.service.users.reactive.infrastructure.converter;

import com.service.users.reactive.application.dto.UserDto;
import com.service.users.reactive.domain.User;
import com.service.users.reactive.infrastructure.data.UserData;

public class UserConverter {

    private UserConverter() {
        super();
    }

    public static User fromDataToDomain(UserData userData) {
        return User.builder()
                .id(userData.getId())
                .firstName(userData.getFirstName())
                .lastName(userData.getLastName())
                .phone(userData.getPhone())
                .build();
    }

    public static UserData fromDomainToData(User user) {
        return UserData.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .build();
    }

    public static UserDto fromDomainToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .build();
    }

    public static User froDtoToDomain(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .phone(userDto.getPhone())
                .build();
    }

}
