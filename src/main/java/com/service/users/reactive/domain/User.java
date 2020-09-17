package com.service.users.reactive.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {

    private final Long id;

    private final String firstName;

    private final String lastName;

    private final String phone;

}
