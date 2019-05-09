package com.github.evgdim.tasktrack.model;

import javax.persistence.*;

@Entity
public class Backlog {
    @GeneratedValue
    @Id
    private Long id;
    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
