package br.com.juno.integration.api.services.request.notification.webhook;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseRequest;

public final class WebhookListRequest extends BaseRequest {

    private static final long serialVersionUID = 2955775000707665606L;

    public WebhookListRequest() {
        this(JunoApiManager.config().getResourceToken());
    }

    public WebhookListRequest(String resourceToken) {
        setResourceToken(resourceToken);
    }

}
