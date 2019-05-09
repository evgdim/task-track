package com.github.evgdim.tasktrack.controller;

import com.github.evgdim.tasktrack.model.User;
import com.github.evgdim.tasktrack.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
