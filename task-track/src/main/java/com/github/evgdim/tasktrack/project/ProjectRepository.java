package com.github.evgdim.tasktrack.project;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

interface ProjectRepository extends ReactiveCrudRepository<Project, Long> {

}
