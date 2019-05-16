package com.github.evgdim.tasktrack.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {

}
