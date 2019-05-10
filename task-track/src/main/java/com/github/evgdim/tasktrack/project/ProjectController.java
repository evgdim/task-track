package com.github.evgdim.tasktrack.project;

import io.vavr.control.Try;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/projects")
class ProjectController {
    private final ProjectRepository projectRepository;
    private final ProjectService projectService;

    public ProjectController(ProjectRepository projectRepository, ProjectService projectService) {
        this.projectRepository = projectRepository;
        this.projectService = projectService;
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
    public ResponseEntity<?> post(@RequestBody CreateProjectRequest project) {
        Try<Project> createProject = this.projectService.createProject(project.name, project.leadUserId);
        return null;
//        return createProject
//                .map(p -> ResponseEntity.ok(p))
//                .getOrElseGet(t -> ResponseEntity.status(500).body(t));
    }
}

class CreateProjectRequest {
    String name;
    Long leadUserId;
}