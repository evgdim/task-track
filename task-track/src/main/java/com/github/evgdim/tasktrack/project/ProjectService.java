package com.github.evgdim.tasktrack.project;

import io.vavr.control.Try;
import reactor.core.publisher.Mono;

interface ProjectService {
    Mono<Project> createProject(String name, Long leadUserId);
}
