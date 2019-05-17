package com.github.evgdim.tasktrack.project;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomBacklogRepository {
    Mono<Backlog> findBacklogWithTasksById(Long backlogId);
}
