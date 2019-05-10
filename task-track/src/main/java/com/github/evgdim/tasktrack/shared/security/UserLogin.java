package com.github.evgdim.tasktrack.shared.security;

import lombok.Data;

@Data
public class UserLogin {
	private String username;
	private String password;
}
