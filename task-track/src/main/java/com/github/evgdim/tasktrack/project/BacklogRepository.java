package com.github.evgdim.tasktrack.project;

import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
interface BacklogRepository extends ReactiveCrudRepository<Backlog, Long> {
    @Query("select * from BACKLOG b join PROJECT p on(b.project_id = p.id) where p.id = :id")
    Mono<Backlog> findBacklogByProjectId(Long id);
}
