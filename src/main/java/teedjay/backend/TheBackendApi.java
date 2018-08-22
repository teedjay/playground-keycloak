package teedjay.backend;

import io.jsonwebtoken.Claims;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Path;

@Path("/")
@RequestScoped
public class TheBackendApi {

    @Inject
    JwtDecoder jwtDecoder;

    @GET
    public InfoStructure getSomeInfo(@HeaderParam("Authorization") String authorization) {
        if ((authorization == null) || !authorization.startsWith("Bearer ")) throw new NotAuthorizedException("Missing bearer token");
        String token = authorization.substring(7); // remove "Bearer " prefix
        Claims claimsFromToken = jwtDecoder.getClaimsFromToken(token);
        return new InfoStructure(claimsFromToken);
    }

}