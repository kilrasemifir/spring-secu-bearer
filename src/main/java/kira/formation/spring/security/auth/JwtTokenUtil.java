package kira.formation.spring.security.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Map;

@Component
public class JwtTokenUtil {

    private final String secret = "jklhfliuyfgliuyfgliugluiyglugluigmugmliuglifgliyfkutdut654esea465ze4az354za63qreyqujtdl";

    public String generateToken(String username, Map<String, Object> claims){
        Key key = Keys.hmacShaKeyFor(secret.getBytes());
        return Jwts.builder()
                .setSubject(username)
                .setClaims(claims)
                .signWith(key)
                .compact();
    }

    public Claims getAllClaimsFromToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
