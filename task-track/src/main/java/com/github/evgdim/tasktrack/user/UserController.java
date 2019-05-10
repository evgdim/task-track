package com.github.evgdim.tasktrack.user;

import com.github.evgdim.tasktrack.user.User;
import com.github.evgdim.tasktrack.user.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Iterable<User> getAll() {
        return this.userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return this.userRepository.findById(id);
    }

    @PostMapping
    public User post(@RequestBody User project) {
        return this.userRepository.save(project);
    }
}
