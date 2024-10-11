package org.bojan.sample.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.Collection;
import java.util.Map;

@AllArgsConstructor
public class CustomOidcUserPrincipal implements OidcUser {

    private String id;
    private String username;
    private OidcIdToken oidcIdToken;
    private Map<String, Object> attributes;
    private OidcUserInfo userInfo;
    private String sessionId;

    @Override
    public Map<String, Object> getClaims() {
        return userInfo.getClaims();
    }

    @Override
    public OidcUserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override
    public OidcIdToken getIdToken() {
        return this.oidcIdToken;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getName() {
        return this.username;
    }

    public String getUserId(){
        return this.id;
    }

    public String getSessionId() {
        return sessionId;
    }
}
