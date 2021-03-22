package br.com.juno.integration.api.model;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Webhook extends BaseModel {

    private static final long serialVersionUID = 1245836625507686345L;

    private String url;
    private String secret;
    private WebhookStatusEnum status;
    private Set<EventType> eventTypes = new HashSet<>();

    protected Webhook() {
        // NTD
    }

    public enum WebhookStatusEnum {
        ACTIVE,
        INACTIVE;
    }

    public String getUrl() {
        return url;
    }

    public String getSecret() {
        return secret;
    }

    public WebhookStatusEnum getStatus() {
        return status;
    }

    public Set<EventType> getEventTypes() {
        return eventTypes;
    }

    protected void setUrl(String url) {
        this.url = url;
    }

    protected void setSecret(String secret) {
        this.secret = secret;
    }

    protected void setStatus(WebhookStatusEnum status) {
        this.status = status;
    }

    protected void setEventTypes(Set<EventType> eventTypes) {
        this.eventTypes = eventTypes;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(getId());
        builder.append(url);
        builder.append(secret);
        builder.append(status);
        builder.append(eventTypes);
        return builder.toString();
    }

}
