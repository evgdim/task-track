package com.github.evgdim.tasktrack.project;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class Backlog {
    @Id
    private Long id;
    private Long projectId;

    public Backlog(Long projectId) {
        this.projectId = projectId;
    }
}
