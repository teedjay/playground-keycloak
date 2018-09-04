package teedjay.backend;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
public class AccessTokenProducer {

    private AccessToken accessToken;

    @Produces
    public AccessToken getValidAccessToken() {
        if (accessToken == null) accessToken = fetchNewAccessToken();
        // TODO make sure accessToken is still valid, if not request a new using the refresh token
        return  accessToken;
    }

    private AccessToken fetchNewAccessToken() {
        String url = "http://ectrade.ec.evry.com/auth/realms/GRAS/protocol/openid-connect/token";
        Form form = new Form();
        form.param("grant_type", "client_credentials");
        form.param("client_id", "gras-innsyn-backend");
        form.param("client_secret", "xxxx-xxxx-xxxx-xxx"); // TODO add the secret client id here
        return ClientBuilder.newClient().target(url).request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), AccessToken.class);
    }

}
