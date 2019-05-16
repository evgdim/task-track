package com.github.evgdim.tasktrack.task;

import com.github.evgdim.tasktrack.task.Task;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

public interface TaskRepository extends ReactiveCrudRepository<Task, Long> {

}
