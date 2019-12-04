package br.com.juno.integration.api.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.juno.integration.api.base.Clock;
import br.com.juno.integration.api.base.exception.Assert;

public final class AuthorizationToken implements Serializable {

    private static final long serialVersionUID = -8061124453931068922L;

    private final Long timestamp;

    private String accessToken;
    private String tokenType;
    private Long expiresIn;
    private String scope;
    private String userName;
    private String jti;

    protected AuthorizationToken() {
        timestamp = Clock.getTimeInMillis();
    }

    public boolean isExpired() {
        return isExpired(0L);
    }

    public boolean isExpired(Long minTimeAmount) {
        Assert.notNull(expiresIn, "expiredIn was not initialized");
        return Clock.getTimeInMillis() - timestamp > getExpiresInMillis() - minTimeAmount;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public Long getExpiresInMillis() {
        return expiresIn == null ? null : expiresIn * 1000;
    }

    public String getScope() {
        return scope;
    }

    public String getUserName() {
        return userName;
    }

    public String getJti() {
        return jti;
    }

    @JsonProperty("access_token")
    void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @JsonProperty("token_type")
    void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @JsonProperty("expires_in")
    void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    @JsonProperty("scope")
    void setScope(String scope) {
        this.scope = scope;
    }

    @JsonProperty("user_name")
    void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("jti")
    void setJti(String jti) {
        this.jti = jti;
    }
}