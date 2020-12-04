package br.com.juno.integration.api.services.request.picpay;

import br.com.juno.integration.api.services.request.BaseTemplatedRequest;

public class PicpayCancelRequest extends BaseTemplatedRequest<String> {

	private static final long serialVersionUID = -2869006120057352364L;

	public PicpayCancelRequest(String resourceToken, String referenceId) {
		super(resourceToken, referenceId);
	}
	
	public PicpayCancelRequest(String referenceId) {
		super(referenceId);
	}
}
