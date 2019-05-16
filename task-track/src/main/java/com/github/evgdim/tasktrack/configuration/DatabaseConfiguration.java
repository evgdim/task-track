package com.github.evgdim.tasktrack.configuration;

import io.r2dbc.h2.H2ConnectionConfiguration;
import io.r2dbc.h2.H2ConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy;
import org.springframework.data.r2dbc.core.ReactiveDataAccessStrategy;
import org.springframework.data.r2dbc.dialect.Dialect;
import org.springframework.data.r2dbc.dialect.H2Dialect;

@Configuration
public class DatabaseConfiguration {
    @Bean
    public DatabaseClient databaseClient() {
        ConnectionFactory connectionFactory = new H2ConnectionFactory(H2ConnectionConfiguration.builder()
                .inMemory("tasks")
                .build());

        return DatabaseClient.create(connectionFactory);
    }

    @Bean
    public ReactiveDataAccessStrategy reactiveDataAccessStrategy() {
        return new DefaultReactiveDataAccessStrategy(H2Dialect.INSTANCE);
    }
}
