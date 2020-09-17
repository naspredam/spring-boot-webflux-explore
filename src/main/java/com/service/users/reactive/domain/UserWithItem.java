package com.service.users.reactive.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class UserWithItem {

    User user;

    Item item;

}
