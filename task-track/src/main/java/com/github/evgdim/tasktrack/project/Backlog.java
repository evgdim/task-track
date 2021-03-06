package com.github.evgdim.tasktrack.project;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Backlog {
    @GeneratedValue
    @Id
    private Long id;
    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
