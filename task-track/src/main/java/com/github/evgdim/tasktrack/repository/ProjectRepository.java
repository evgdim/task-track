package com.github.evgdim.tasktrack.repository;

import com.github.evgdim.tasktrack.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

}
