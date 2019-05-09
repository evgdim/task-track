package com.github.evgdim.tasktrack.model;

import javax.persistence.*;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "lead_id")
    private User lead;
    @OneToOne(mappedBy = "project")
    private Backlog backlog;
}
