package com.github.evgdim.tasktrack.repository;

import com.github.evgdim.tasktrack.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
