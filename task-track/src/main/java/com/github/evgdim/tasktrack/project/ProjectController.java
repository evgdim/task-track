package com.github.evgdim.tasktrack.project;

import io.vavr.control.Try;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/projects")
@Slf4j
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
        Try<Project> createProject = this.projectService.createProject(project.getName(), project.getLeadUserId());
        createProject.onSuccess(p -> log.info("POST {}", p));
        createProject.onFailure(e -> log.error("POST ERROR", e));
        if(createProject.isSuccess()) {
            return ResponseEntity.ok(createProject.get());
        } else {
            Throwable cause = createProject.getCause();
            return ResponseEntity.status(500).body(cause);
        }
    }
}
@Data
class CreateProjectRequest {
    private String name;
    private Long leadUserId;
}