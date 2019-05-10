package com.github.evgdim.tasktrack.project;

import io.vavr.control.Try;

public interface ProjectService {
    Try<Project> createProject(String name, Long leadUserId);
}
