package com.github.evgdim.tasktrack.project;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class Backlog {
    @Id
    private Long id;
    private Project project;
}
