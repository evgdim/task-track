package com.github.evgdim.tasktrack.user;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long userId);
}
