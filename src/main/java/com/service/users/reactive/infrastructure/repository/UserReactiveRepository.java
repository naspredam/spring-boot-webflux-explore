package com.service.users.reactive.infrastructure.repository;

import com.service.users.reactive.infrastructure.data.UserData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserReactiveRepository extends ReactiveCrudRepository<UserData, Long> {
}
