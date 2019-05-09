package com.github.evgdim.tasktrack.repository;

import com.github.evgdim.tasktrack.model.Sprint;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends PagingAndSortingRepository<Sprint, Long> {

}
