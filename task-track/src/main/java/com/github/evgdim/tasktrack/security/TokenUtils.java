package com.github.evgdim.tasktrack.security;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public abstract class TokenUtils {
    public static final String AUTH_HEADER = "Authorization";
    public static final String SECRET_KEY = "secretkey";

    private TokenUtils(){}

    public static JwtPrincipal parseToken(final String authHeader){
        final String token = authHeader.substring(7); // The part after "Bearer ";

        final Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();

        JwtPrincipal principal = JwtPrincipal.authenticated(claims.getSubject(), null);
        principal.setClaims(claims);
        return principal;
    }

    public static String generateToken(final UserLogin login){
        String token = Jwts.builder()
                .setSubject(login.getUsername())
                .claim("role", "USER")
                .setIssuedAt(toDate(LocalDateTime.now()))
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(30)))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
        return token;
    }
    
    private static Date toDate(LocalDateTime ldt) {
    	return java.util.Date
    		      .from(ldt.atZone(ZoneId.systemDefault())
    		    	      .toInstant());
    }
}