package teedjay.restapi;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotAuthorizedException;

@RequestScoped
public class TheTokenProducer {

    @Inject
    private HttpServletRequest httpServletRequest;

    @Produces
    public TheToken getAccessToken() {

        // Principal principal = httpServletRequest.getUserPrincipal();
        // if (principal instanceof KeycloakPrincipal) return ((KeycloakPrincipal) httpServletRequest.getUserPrincipal()).getKeycloakSecurityContext().getToken();
        // https://github.com/dasniko/keycloak-javaee-demo

        String authzHeader = httpServletRequest.getHeader("Authorization");
        if (authzHeader != null) return new TheToken(authzHeader);
        throw new NotAuthorizedException("Missing proper access token");

    }

}
