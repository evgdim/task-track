package com.github.evgdim.tasktrack.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Claims;
import lombok.Data;

@Data
public class JwtPrincipal implements Authentication{
	private String username;
	private String password;
	private boolean authenticated;
	private Claims claims;
	
	private JwtPrincipal() {}
	
	public static JwtPrincipal authenticated(String username, String password) {
		JwtPrincipal principal = new JwtPrincipal();
		principal.username = username;
		principal.password = password;
		principal.authenticated = true;
		return principal;
	}
	
	public static JwtPrincipal notAuthenticated() {
		JwtPrincipal principal = new JwtPrincipal();
		principal.authenticated = false;
		return principal;
	}
	
	@Override
	public String getName() {
		return username;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.emptyList();
	}
	@Override
	public Object getCredentials() {
		return password;
	}
	@Override
	public Object getDetails() {
		return null;
	}
	@Override
	public Object getPrincipal() {
		return null;
	}
	@Override
	public boolean isAuthenticated() {
		return authenticated;
	}
	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {		
		this.authenticated = isAuthenticated;
	}
}
