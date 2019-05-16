package com.github.evgdim.tasktrack.user;

import reactor.core.publisher.Mono;

import java.util.Optional;

public interface UserService {
    Mono<User> findById(Long userId);
}
