package com.github.evgdim.tasktrack.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.evgdim.tasktrack.security.TokenUtils;
import com.github.evgdim.tasktrack.security.UserLogin;
import com.github.evgdim.tasktrack.security.UserToken;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/token")
public class TokenController {
	@PostMapping
	public Mono<UserToken> login(@RequestBody UserLogin login) {
		String token = TokenUtils.generateToken(login);//TODO check credentials
		return Mono.just(new UserToken(token));
	}
}
