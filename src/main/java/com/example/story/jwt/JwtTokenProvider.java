package com.example.story.jwt;

import java.util.Date;

import com.example.story.payload.CustomUserDetails;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import static com.sun.activation.registries.LogSupport.log;


@Component
@Slf4j
public class JwtTokenProvider {
    private final String JWT_SECRET = "KyTheMc";
    private final long JWT_EXPIRATION = 604800000L;

    public String generateToken(CustomUserDetails customUserDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

        return Jwts.builder()
                .setSubject(customUserDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }
    public String generateTokenFromUsername(String username) {
        return Jwts.builder().setSubject(username).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + JWT_EXPIRATION)).signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }
    public String getUsernameFromJwt(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            log("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log("JWT claims string is empty.");
        }
        return false;
    }
}
