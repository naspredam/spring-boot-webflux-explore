package com.service.users.reactive.infrastructure.repository;

import com.service.users.reactive.domain.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ItemRepository {

    public Mono<Item> getItem(String itemName) {
        log.info("getItem - Started... {}", itemName);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Mono<Item> just = Mono.just(Item.builder().name(itemName).build());
        log.info("getItem - ended... {}", itemName);
        return just;
    }
}
