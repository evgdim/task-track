package com.github.evgdim.tasktrack;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.github.evgdim.tasktrack.security.CustomSecurityContextRepository;

@EnableWebFluxSecurity
public class SecurityConfiguration {
	
    @Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) {
        return http
            .authorizeExchange()
            .pathMatchers("/token").permitAll()
            .anyExchange().authenticated()
            .and()
            .securityContextRepository(new CustomSecurityContextRepository())
            .httpBasic().disable()
            .formLogin().disable()
            .csrf().disable()
            .build();
    }
   
}
