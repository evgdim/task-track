package com.github.evgdim.tasktrack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.evgdim.tasktrack.model.Task;
import com.github.evgdim.tasktrack.repository.TaskRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
	private final TaskRepository taskRepo;
	@PostMapping
	public Mono<Integer> save(@RequestBody Task task) {
		return this.taskRepo.save(task);
	}
	
	@GetMapping
	public Mono<Task> get(@RequestParam String name) {
		return this.taskRepo.findByName(name);
	}
}
