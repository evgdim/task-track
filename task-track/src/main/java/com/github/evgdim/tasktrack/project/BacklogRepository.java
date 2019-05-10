package com.github.evgdim.tasktrack.project;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
interface BacklogRepository extends PagingAndSortingRepository<Sprint, Long> {

}
