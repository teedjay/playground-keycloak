package teedjay.restapi;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/")
@ApplicationScoped
public class TheRestApi {

    private List<String> names = new ArrayList<>();

    @PostConstruct
    public void addSomeInitialNames() {
        names.add("TeeDjay");
        names.add("Victoria");
    }

    @GET
    public NameList getNames() {
        return new NameList(names);
    }

    @POST
    @Path("{name}")
    public Response addName(@PathParam("name") String name) {
        names.add(name);
        return Response.ok().build();
    }

}
