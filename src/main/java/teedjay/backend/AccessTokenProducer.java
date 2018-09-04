package teedjay.backend;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
public class AccessTokenProducer {

    @Inject
    @ConfigProperty(name = "teedjay.oauth2.url")
    String url;

    @Inject
    @ConfigProperty(name = "teedjay.oauth2.client_id")
    String clientId;

    @Inject
    @ConfigProperty(name = "teedjay.oauth2.client_secret")
    String clientSecret;

    private AccessToken accessToken;

    @Produces
    public AccessToken getValidAccessToken() {
        if (accessToken == null) accessToken = fetchNewAccessToken();
        // TODO make sure accessToken is still valid, if not request a new using the refresh token
        return  accessToken;
    }

    private AccessToken fetchNewAccessToken() {
        Form form = new Form();
        form.param("grant_type", "client_credentials");
        form.param("client_id", clientId);
        form.param("client_secret", clientSecret);
        return ClientBuilder.newClient().target(url).request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), AccessToken.class);
    }

}
