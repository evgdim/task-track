package com.github.evgdim.tasktrack.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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
