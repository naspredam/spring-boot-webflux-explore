package com.service.users.reactive.application.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {

    private final Long id;

    private final String firstName;

    private final String lastName;

    private final String phone;

}
