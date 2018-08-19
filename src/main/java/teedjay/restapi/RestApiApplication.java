package teedjay.restapi;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/restapi")
public class RestApiApplication extends Application {

    // You can delete the getClasses() method if you only have one "api" in your application
    // I need it for this demo only because I want to explicitly add one resources to this path

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(TheRestApi.class);
        return resources;
    }

}
