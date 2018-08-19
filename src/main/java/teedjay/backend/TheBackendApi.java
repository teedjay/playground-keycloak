package teedjay.backend;

import org.eclipse.microprofile.auth.LoginConfig;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.DenyAll;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
@DenyAll
@LoginConfig(authMethod = "MP-JWT", realmName = "GRAS")
@RequestScoped
public class TheBackendApi {

    @Inject
    private JsonWebToken callerPrincipal;

    // https://github.com/javaee-samples/microprofile1.2-samples/tree/master/jwt-auth
    // https://docs.payara.fish/documentation/microprofile/jwt.html

    @Inject
    @Claim(standard = Claims.preferred_username)
    private String username;

    @GET
    public InfoStructure getSomeInfo() {
        System.out.println(callerPrincipal.getRawToken());
        return new InfoStructure("caller = " + username);
    }

}