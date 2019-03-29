package com.github.evgdim.tasktrack.repository;

import com.github.evgdim.tasktrack.model.Task;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

}
