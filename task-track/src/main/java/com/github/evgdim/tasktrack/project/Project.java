package com.github.evgdim.tasktrack.project;

import com.github.evgdim.tasktrack.user.User;
import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
class Project {
    @Id
    private Long id;
    private String name;
    private Long leadId;
    private Long backlogId;
}
