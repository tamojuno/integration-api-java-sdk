package br.com.juno.integration.api.services.request.notification.webhook;

import br.com.juno.integration.api.services.request.BaseTemplatedRequest;

public final class WebhookDeleteRequest extends BaseTemplatedRequest<String> {

    private static final long serialVersionUID = 2955775000707665606L;

    public WebhookDeleteRequest(String resourceToken, String id) {
        super(resourceToken, id);
    }

    public WebhookDeleteRequest(String id) {
        super(id);
    }

}
