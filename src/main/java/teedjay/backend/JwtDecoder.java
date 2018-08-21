package teedjay.backend;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.security.Key;

public class JwtDecoder {

    private Key publicKey;

    public JwtDecoder(Key publicKey) {
        this.publicKey = publicKey;
    }

    public Claims getClaimsFromToken(String jwt) {
        return Jwts.parser().setSigningKey(publicKey).parseClaimsJws(jwt).getBody();
    }

}
