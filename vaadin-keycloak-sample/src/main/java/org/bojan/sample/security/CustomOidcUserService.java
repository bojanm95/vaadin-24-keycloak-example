package org.bojan.sample.security;

import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;

@Component
public class CustomOidcUserService extends OidcUserService {

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser user = super.loadUser(userRequest);

        String username = user.getPreferredUsername();
        OidcIdToken token = user.getIdToken();
        String id = user.getAttribute("user_id");
        String sessionId = user.getAttribute("sid");

        CustomOidcUserPrincipal userPrincipal = new CustomOidcUserPrincipal(id, username, token, user.getAttributes(), user.getUserInfo(), sessionId);
        return userPrincipal;
    }
}
