package com.github.evgdim.tasktrack.project;

import com.github.evgdim.tasktrack.task.Task;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.List;


@Data
public class Backlog {
    @Id
    private Long id;
    private Long projectId;
    @Transient
    private List<Task> tasks;
    public Backlog(Long projectId) {
        this.projectId = projectId;
    }
}
