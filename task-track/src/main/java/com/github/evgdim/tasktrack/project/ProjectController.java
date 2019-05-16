package com.github.evgdim.tasktrack.project;

import io.vavr.control.Try;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Flux<Project> getAll() {
        return this.projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Project> getById(@PathVariable Long id) {
        return this.projectRepository.findById(id);
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