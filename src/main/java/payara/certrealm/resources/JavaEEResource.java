package payara.certrealm.resources;

import fish.payara.security.annotations.CertificateAuthenticationMechanismDefinition;
import fish.payara.security.annotations.CertificateIdentityStoreDefinition;

import java.security.Principal;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author
 */
@RolesAllowed("admin")
@Path("home")
public class JavaEEResource {

    @Context
    SecurityContext securityContext;

    @GET
    public Response ping() {
        final Principal p = securityContext.getUserPrincipal();
        final String name = p != null ? p.getName() : null;
        return Response
                .ok("OK from " + name)
                .build();
    }
}
