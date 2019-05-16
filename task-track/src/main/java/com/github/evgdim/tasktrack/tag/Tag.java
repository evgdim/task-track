package com.github.evgdim.tasktrack.tag;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Tag {
    @Id
    private Long id;
    private String name;
    private String description;
}
