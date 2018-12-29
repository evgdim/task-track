package com.github.evgdim.tasktrack.repository;

import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.stereotype.Repository;

import com.github.evgdim.tasktrack.model.Task;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class TaskRepository {
	private final DatabaseClient db;
	
	public Mono<Integer> save(Task task) {
		return db.execute()
				.sql("insert into PUBLIC.TASK (name) values($1)")
				.bind("$1", task.getName())
				.fetch().rowsUpdated();
	}
	
	public Mono<Task> findByName(String name) {
		return db.execute()
				.sql("select * from TASK where name = $1")
				.bind("$1", name)
				.map((r, rm) -> new Task(r.get("name", String.class))).one();
	}
}
