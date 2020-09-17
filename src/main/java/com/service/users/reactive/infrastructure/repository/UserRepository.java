package com.service.users.reactive.infrastructure.repository;

import com.service.users.reactive.infrastructure.converter.UserConverter;
import com.service.users.reactive.domain.User;
import com.service.users.reactive.infrastructure.data.UserData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class UserRepository {

    private final UserReactiveRepository userReactiveRepository;

    public UserRepository(UserReactiveRepository userReactiveRepository) {
        this.userReactiveRepository = userReactiveRepository;
    }

    public Mono<User> saveUser(User user) {
        UserData userData = UserConverter.fromDomainToData(user);
        return userReactiveRepository.save(userData)
                .map(UserConverter::fromDataToDomain);
    }

    public Mono<User> getUser(long userId) {
        log.info("getUser - Started... {}", userId);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Mono<User> just = Mono.just(User.builder().id(userId).build());
        log.info("getUser - ended... {}", userId);
        return just;
    }


    public Mono<User> fetchUserById(long userId) {
        return userReactiveRepository.findById(userId)
                .map(UserConverter::fromDataToDomain);
    }

    public Flux<User> fetchAllUsers() {
        return userReactiveRepository.findAll()
                .map(UserConverter::fromDataToDomain);
    }
}
