package com.github.evgdim.tasktrack.project;

import com.github.evgdim.tasktrack.user.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
class Project {
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
