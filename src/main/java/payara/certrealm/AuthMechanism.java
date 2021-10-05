package payara.certrealm;

import javax.inject.Inject;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthMechanism implements javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism {

    @Inject
    private IdentityStoreHandler identityStoreHandler;

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext httpMessageContext) throws AuthenticationException {
        Credential credential = httpMessageContext.getAuthParameters().getCredential();

        if (credential != null) {
            return httpMessageContext.notifyContainerAboutLogin(identityStoreHandler.validate(credential));
        }
        else {
            return httpMessageContext.doNothing();
        }
    }
}
