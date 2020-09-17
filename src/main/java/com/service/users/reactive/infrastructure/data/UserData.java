package com.service.users.reactive.infrastructure.data;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("users")
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserData {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private String phone;
}

