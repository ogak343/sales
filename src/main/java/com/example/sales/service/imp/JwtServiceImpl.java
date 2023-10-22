package com.example.sales.service.imp;

import com.example.sales.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.function.Function;


@Component
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private static String SECRET_KEY;
    @Override
    public String extractUsername(String token) {
        return extractCredentials(token, Claims::getSubject);
    }

    private <T> T extractCredentials(String token, Function<Claims, T> resolver) {
        return resolver.apply(
                Jwts.parserBuilder()
                        .setSigningKey(getSignInKey())
                        .build()
                        .parseClaimsJwt(token)
                        .getBody());
    }

    private Key getSignInKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

}
