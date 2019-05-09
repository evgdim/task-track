package com.github.evgdim.tasktrack.controller;

import com.github.evgdim.tasktrack.model.Project;
import com.github.evgdim.tasktrack.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public Iterable<Project> getAll() {
        return this.projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Project> getById(@PathVariable Long id) {
        return this.projectRepository.findById(id);
    }

    @PostMapping
    public Project post(@RequestBody Project project) {
        return this.projectRepository.save(project);
    }
}
