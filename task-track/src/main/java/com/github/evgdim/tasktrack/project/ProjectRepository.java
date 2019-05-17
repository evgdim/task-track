package com.github.evgdim.tasktrack.project;

import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

interface ProjectRepository extends ReactiveCrudRepository<Project, Long> {

}
