package com.github.evgdim.tasktrack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Check(constraints = "(backlog_id IS NOT NULL AND spring_id IS NULL) OR (backlog_id IS NULL AND spring_id IS NOT NULL)")
public class Task {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	private LocalDateTime creationTime;
	@ManyToOne
	@JoinColumn(name = "creator_id")
	private User creator;
	@ManyToOne
	@JoinColumn(name = "assignee_id")
	private User assignee;
	@ManyToOne
	@JoinColumn(name = "backlog_id")
	private Backlog backlog;
	@ManyToOne
	@JoinColumn(name = "spring_id")
	private Sprint spring;
	//private Set<Tag> tags;
}
