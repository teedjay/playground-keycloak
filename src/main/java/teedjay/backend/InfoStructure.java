package teedjay.backend;

import io.jsonwebtoken.Claims;

import java.time.LocalDateTime;
import java.util.UUID;

public class InfoStructure {

    public String uuid;
    public String timestamp;
    public String tokentype;
    public String username;
    public String expiration;
    public String issuer;
    public String audience;

    public InfoStructure(Claims claims) {
        uuid = UUID.randomUUID().toString();
        timestamp = LocalDateTime.now().toString();
        tokentype = claims.get("typ", String.class);
        username = claims.get("preferred_username", String.class);
        expiration = claims.getExpiration().toString();
        issuer = claims.getIssuer();
        audience = claims.getAudience();
    }

}