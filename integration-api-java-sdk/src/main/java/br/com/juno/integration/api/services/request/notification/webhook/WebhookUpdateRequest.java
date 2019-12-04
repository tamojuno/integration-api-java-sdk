package br.com.juno.integration.api.services.request.notification.webhook;

import java.util.ArrayList;
import java.util.List;

import br.com.juno.integration.api.model.Webhook.WebhookStatusEnum;
import br.com.juno.integration.api.services.request.BaseTemplatedRequest;

public final class WebhookUpdateRequest extends BaseTemplatedRequest<String> {

    private static final long serialVersionUID = 2955775000707665606L;

    private WebhookStatusEnum status;
    private final List<String> eventTypes = new ArrayList<>();

    public WebhookUpdateRequest(String resourceToken, String id) {
        super(resourceToken, id);
    }

    public WebhookUpdateRequest(String id) {
        super(id);
    }

    public List<String> getEventTypes() {
        return eventTypes;
    }

    public WebhookStatusEnum getStatus() {
        return status;
    }

    public void setStatus(WebhookStatusEnum status) {
        this.status = status;
    }

}
