package payara.certrealm;

import fish.payara.security.annotations.CertificateAuthenticationMechanismDefinition;
import fish.payara.security.annotations.CertificateIdentityStoreDefinition;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures JAX-RS for the application.
 *
 * @author Juneau
 */
@ApplicationPath("resources")
@DeclareRoles("admin")
@CertificateAuthenticationMechanismDefinition
@CertificateIdentityStoreDefinition
public class JAXRSConfiguration extends Application {

}
