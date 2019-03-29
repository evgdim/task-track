package com.github.evgdim.tasktrack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private LocalDateTime creationTime;
	@ManyToOne
	@JoinColumn(name = "creator_id")
	private User creator;
}
