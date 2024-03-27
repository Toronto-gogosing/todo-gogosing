package com.benchmark.todo._core.auth.provider;

import com.benchmark.todo._core.secret.TokenSecret;
import com.benchmark.todo.user.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Date;

// Ref: https://github.com/jwtk/jjwt
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public abstract class TokenProvider {

  public String create(User user) {
    TokenSecret secret = getSecret();
    Date now = new Date();
    return Jwts.builder()
        .subject(user.getId().toString())
        .claim("username", user.getUsername())
        .issuedAt(now)
        .expiration(new Date(now.getTime() + secret.getDuration() * 1000L))
        .signWith(Keys.hmacShaKeyFor(secret.getSigningKey().getBytes()))
        .compact();
  }

  // TODO: Implement this method(Jerry)
  public Jws<Claims> parse(String token) {
    try {
      TokenSecret secret = getSecret();
      return Jwts.parser()
          .verifyWith(Keys.hmacShaKeyFor(secret.getSigningKey().getBytes()))
          .build()
          .parseSignedClaims(token);
    } catch (Exception e) {
      throw new AccessDeniedException("filed to validate the token");
    }
  }

  public Authentication loadAuthentication(String token) {
    try {
      TokenSecret secret = getSecret();
      Jws<Claims> claims = Jwts.parser()
          .verifyWith(Keys.hmacShaKeyFor(secret.getSigningKey().getBytes())).build()
          .parseSignedClaims(token);

      UserDetails userDetails = getUserDetailsService().loadUserByUsername(
          claims.getPayload().getSubject());
      return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    } catch (Exception e) {
      return null;
    }
  }

  protected abstract TokenSecret getSecret();

  protected abstract UserDetailsService getUserDetailsService();
}
