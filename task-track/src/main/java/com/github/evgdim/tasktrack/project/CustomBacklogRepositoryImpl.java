package com.github.evgdim.tasktrack.project;

import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.core.FetchSpec;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.function.BiFunction;

public class CustomBacklogRepositoryImpl implements CustomBacklogRepository {
    private final DatabaseClient databaseClient;

    public CustomBacklogRepositoryImpl(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @Override
    public Mono<Backlog> findBacklogWithTasksById(Long projectId) {
        String sql = "select * from BACKLOG b" +
                " join PROJECT p on(b.project_id = p.id) " +
                " where p.id = $1";

        BiFunction<Row, RowMetadata, Backlog> backlogMapper = (r, rm) -> {
            return new Backlog(projectId);
        };
        Mono<Backlog> backlog = null;
        Flux<Map<String, Object>> fetch = databaseClient.execute()
                .sql(sql)
                .bind("$1", projectId)
                .fetch()
                .all();

        return backlog;
    }
}
