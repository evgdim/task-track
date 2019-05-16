package com.github.evgdim.tasktrack;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
@Slf4j
public class TaskTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskTrackApplication.class, args).addApplicationListener((ApplicationListener<ApplicationPreparedEvent>) applicationPreparedEvent -> {
			//DatabaseClient databaseClient = applicationPreparedEvent.getApplicationContext().getBean(DatabaseClient.class);
			log.info("Started...");
		});
	}

}

