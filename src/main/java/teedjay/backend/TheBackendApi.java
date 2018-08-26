package teedjay.backend;

import io.jsonwebtoken.Claims;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

@Path("/")
@RequestScoped
public class TheBackendApi {

    @Inject
    JwtDecoder jwtDecoder;

    @Context
    HttpHeaders httpHeaders;

    @GET
    public InfoStructure getSomeInfo() {
        String authorization = httpHeaders.getHeaderString(HttpHeaders.AUTHORIZATION);
        if ((authorization == null) || !authorization.startsWith("Bearer ")) throw new NotAuthorizedException("Missing bearer token");
        String token = authorization.substring(7); // remove "Bearer " prefix
        Claims claimsFromToken = jwtDecoder.getClaimsFromToken(token);
        return new InfoStructure(claimsFromToken);
    }

}