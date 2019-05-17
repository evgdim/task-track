package com.github.evgdim.tasktrack.project;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/projects")
@Slf4j
class ProjectController {
    private final ProjectRepository projectRepository;
    private final ProjectService projectService;
    private final BacklogRepository backlogRepository;

    public ProjectController(ProjectRepository projectRepository, ProjectService projectService, BacklogRepository backlogRepository) {
        this.projectRepository = projectRepository;
        this.projectService = projectService;
        this.backlogRepository = backlogRepository;
    }

    @GetMapping
    public Flux<Project> getAll() {
        return this.projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Project> getById(@PathVariable Long id) {
        return this.projectRepository.findById(id);
    }

    @GetMapping("/{id}/backlog")
    public Mono<Backlog> getBacklogByProjectId(@PathVariable Long id) {
        return this.backlogRepository.findBacklogWithTasksById(id);
    }

    @PostMapping
    public Mono<?> post(@RequestBody CreateProjectRequest project) {
        return this.projectService.createProject(project.getName(), project.getLeadUserId())
                .doOnSuccess(p -> log.info("POST {}", p))
                .doOnError(e -> log.error("POST ERROR", e))
                .map(p -> ResponseEntity.ok(p));
                //.onErrorMap(t -> t);
    }
}
@Data
class CreateProjectRequest {
    private String name;
    private Long leadUserId;
}