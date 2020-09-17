package com.service.users.reactive.application;

import com.service.users.reactive.domain.Item;
import com.service.users.reactive.domain.User;
import com.service.users.reactive.domain.UserWithItem;
import com.service.users.reactive.infrastructure.repository.ItemRepository;
import com.service.users.reactive.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final ItemRepository itemRepository;

    public UserService(UserRepository userRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    public Mono<UserWithItem> fetchUserAndItem(long userId, String itemName) {
        Mono<User> user = userRepository.getUser(userId).subscribeOn(Schedulers.elastic());
        Mono<Item> item = itemRepository.getItem(itemName).subscribeOn(Schedulers.elastic());

        return Mono.zip(user, item, UserWithItem::of);
    }

    public Mono<User> createUser(User user) {
        return userRepository.saveUser(user);
    }

    public Mono<User> fetchUserById(long userId) {
        return userRepository.fetchUserById(userId);
    }

    public Flux<User> fetchAllUsers() {
        return userRepository.fetchAllUsers();
    }
}