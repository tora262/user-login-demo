package tech.tora.userlogindemo.common;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import tech.tora.userlogindemo.bus.UserDetailsImpl;

import java.util.Date;

@Component
public class JwtUtils {
    @Value("${tora.app.jwtSecret}")
    private String jwtSecret;

    @Value("${tora.app.jwtExpirationMs}")
    private Long jwtExpirationMs;

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtils.class);

    public String generateJwtToken(Authentication authentication) {
        UserDetailsImpl userDetailsPrinciple = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userDetailsPrinciple.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(authToken);
            return true;
        }catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        return false;
    }
}
