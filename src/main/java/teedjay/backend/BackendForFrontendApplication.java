package teedjay.backend;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeIn;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.security.SecuritySchemes;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/backend")
@OpenAPIDefinition(
    info = @Info(title = "EVRY-SREST API", description = "EVRY implementation of DIFI's VEFA-SREST API", version = "1.0.0"),
    security = @SecurityRequirement(name = "bearerAuth")
)
@SecuritySchemes(value = {
    @SecurityScheme(securitySchemeName = "bearerAuth", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER, scheme = "bearer", bearerFormat = "JWT"),
})
public class BackendForFrontendApplication extends Application {

    // You can delete the getClasses() method if you only have one "api" in your application
    // I need it for this demo only because I want to explicitly add one resources to this path

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(TheBackendApi.class);
        return resources;
    }

}
