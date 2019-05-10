package com.github.evgdim.tasktrack.project;

import com.github.evgdim.tasktrack.project.Project;
import com.github.evgdim.tasktrack.project.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/projects")
class ProjectController {
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
