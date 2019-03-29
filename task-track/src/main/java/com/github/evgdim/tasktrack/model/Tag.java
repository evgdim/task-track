package com.github.evgdim.tasktrack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
}
