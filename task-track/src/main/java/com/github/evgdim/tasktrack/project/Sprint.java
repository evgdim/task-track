package com.github.evgdim.tasktrack.project;

import lombok.Data;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;

@Data
public class Sprint {
    @Id
    private Long id;
    private String name;
    private Project project;
    private LocalDate start;
    private LocalDate end;
}
