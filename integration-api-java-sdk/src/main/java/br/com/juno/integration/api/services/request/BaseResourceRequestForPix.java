package br.com.juno.integration.api.services.request;

import br.com.juno.integration.api.services.JunoApiManager;

public abstract class BaseResourceRequestForPix extends BaseRequestForPix {

	private static final long serialVersionUID = 2976351948624501926L;

	public BaseResourceRequestForPix() {
		this(JunoApiManager.config().getIdempotencyKey());
	}
	
	public BaseResourceRequestForPix(String idempotencyKey) {
		setIdempotencyKey(idempotencyKey);
	}
}
