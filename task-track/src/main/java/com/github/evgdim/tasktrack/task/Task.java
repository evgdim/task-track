package com.github.evgdim.tasktrack.task;

import com.github.evgdim.tasktrack.project.Backlog;
import com.github.evgdim.tasktrack.project.Sprint;
import com.github.evgdim.tasktrack.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
	@Id
	private Long id;
	private String name;
	private String description;
	private LocalDateTime creationTime;
	private User creator;
	private User assignee;
	private Backlog backlog;
	private Sprint spring;
	//private Set<Tag> tags;
}
