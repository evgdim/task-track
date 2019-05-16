package com.github.evgdim.tasktrack.user;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {
    @Id
    private Long id;
    private String name;
    private String password;

}
