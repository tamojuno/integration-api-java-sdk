package br.com.juno.integration.api.services.request;


public abstract class BaseResourceRequestForPix extends BaseRequestForPix {

	private static final long serialVersionUID = 2976351948624501926L;
	
	public BaseResourceRequestForPix(String idempotencyKey) {
		setIdempotencyKey(idempotencyKey);
	}
}
