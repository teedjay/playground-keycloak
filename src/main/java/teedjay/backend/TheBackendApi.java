package teedjay.backend;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
@RequestScoped
public class TheBackendApi {

    @GET
    public InfoStructure getSomeInfo() {
        return new InfoStructure();
    }

}