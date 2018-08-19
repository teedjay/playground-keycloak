package teedjay.restapi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
@RequestScoped
public class TheRestApi {

    @Inject
    TheToken theToken;

    @Inject
    NameRepository nameRepository;

    @GET
    public NameList getNames() {
        String user = theToken == null ? "unknown" : theToken.token;
        return nameRepository.getNameList(user);
    }

    @POST
    public Response addName(String name) {
        nameRepository.addName(name);
        return Response.ok().build();
    }

}
