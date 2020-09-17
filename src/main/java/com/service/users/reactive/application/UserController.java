package com.service.users.reactive.application;

import com.service.users.reactive.application.dto.UserDto;
import com.service.users.reactive.infrastructure.converter.UserConverter;
import com.service.users.reactive.domain.UserWithItem;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Flux<UserDto> getAllUsers() {
        return userService.fetchAllUsers()
                .map(UserConverter::fromDomainToDto);
    }

    @GetMapping("/{user_id}/items/{item_name}")
    public Mono<UserDto> getUserById(@PathVariable("user_id") Long userId,
                                     @PathVariable("item_name") String itemName) {
        return userService.fetchUserAndItem(userId, itemName)
                .map(UserWithItem::getUser)
                .map(UserConverter::fromDomainToDto);
    }

    @GetMapping("/{user_id}")
    public Mono<UserDto> getUserById(@PathVariable("user_id") Long userId) {
        return userService.fetchUserById(userId)
                .map(UserConverter::fromDomainToDto);
    }

    @PostMapping
    public Mono<UserDto> getUserById(@RequestBody UserDto userDto) {
        return userService.createUser(UserConverter.froDtoToDomain(userDto))
                .map(UserConverter::fromDomainToDto);
    }
}
