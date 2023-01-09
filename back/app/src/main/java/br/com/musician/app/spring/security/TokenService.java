package br.com.musician.app.spring.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class TokenService {

	@Value("${musician.jwt.expiration}")
	private String expiration;

	@Value("${musician.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authentication) {
		UsuarioAutenticado logado = (UsuarioAutenticado) authentication.getPrincipal();
		long nowMillis = System.currentTimeMillis();

		Date dataExpiracao = new Date(nowMillis + Long.valueOf(expiration));
		
//		secret = RandomStringUtils.randomAlphanumeric(120);
		Key key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

		return Jwts.builder().setSubject(logado.getUsername()).setIssuedAt(new Date())
				.setExpiration(dataExpiracao).signWith(key).compact();
	}

	public String getUserNameFromJwtToken(String token) {
		return parseClaims(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			parseClaims(authToken);
			return true;
		} catch (ExpiredJwtException e) {
			return false;
		}
	}

	private Jws<Claims> parseClaims(String authToken) {
		Key key = Keys.hmacShaKeyFor(secret.getBytes());
		JwtParser signingKey = Jwts.parserBuilder().setSigningKey(key).build();
		return signingKey.parseClaimsJws(authToken);
	}
}
