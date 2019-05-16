package com.github.evgdim.tasktrack.user;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> findById(Long userId) {
        return this.userRepository.findById(userId);
    }
}
