package com.github.evgdim.tasktrack.security;

import java.util.List;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class CustomSecurityContextRepository implements ServerSecurityContextRepository{
	@Override
	public Mono<Void> save(ServerWebExchange exchange, SecurityContext context) {
		return Mono.empty();
	}

	@Override
	public Mono<SecurityContext> load(ServerWebExchange exchange) {
		List<String> authHeaders = exchange.getRequest().getHeaders().get(TokenUtils.AUTH_HEADER);
		log.info("[CustomSecurityContextRepository] headers: {}", authHeaders);
		if(authHeaders == null) return Mono.empty();
		return authHeaders.stream()
				   .filter(h -> h.startsWith("Bearer "))
				   .findFirst()
				   .map(h -> authorize(h))
				   .orElse(Mono.empty());
	}

	private Mono<SecurityContext> authorize(String h) {
		try {
			JwtPrincipal token = TokenUtils.parseToken(h);
			return Mono.just(new SecurityContextImpl(token));
		} catch (Exception e) {
			log.warn("Unable to parse token", e);
			return Mono.empty();
		}
	}

}
