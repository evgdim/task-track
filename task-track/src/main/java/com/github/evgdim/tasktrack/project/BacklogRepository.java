package com.github.evgdim.tasktrack.project;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface BacklogRepository extends ReactiveCrudRepository<Backlog, Long> {

}
