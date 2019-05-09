package com.github.evgdim.tasktrack.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Sprint {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    private LocalDate start;
    private LocalDate end;
}
