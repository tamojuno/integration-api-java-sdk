package br.com.juno.integration.api.services.request.notification.webhook;

import java.util.ArrayList;
import java.util.List;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseRequest;

public final class WebhookCreateRequest extends BaseRequest {

    private static final long serialVersionUID = 2955775000707665606L;

    private final String url;
    private final List<String> eventTypes = new ArrayList<>();

    public WebhookCreateRequest(String url) {
        this(JunoApiManager.config().getResourceToken(), url);
    }

    public WebhookCreateRequest(String resourceToken, String url) {
        this.url = url;
        setResourceToken(resourceToken);
    }

    public String getUrl() {
        return url;
    }

    public List<String> getEventTypes() {
        return eventTypes;
    }

}
