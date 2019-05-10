package com.github.evgdim.tasktrack.task;

import com.github.evgdim.tasktrack.task.Task;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

}
