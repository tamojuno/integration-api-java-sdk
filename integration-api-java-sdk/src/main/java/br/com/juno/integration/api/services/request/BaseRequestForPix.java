package br.com.juno.integration.api.services.request;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BaseRequestForPix extends BaseRequest {

	private static final long serialVersionUID = -3671014345041619558L;
	
	@JsonIgnore
	protected String idempotencyKey;

	public String getIdempotencyKey() {
		return idempotencyKey;
	}

	protected void setIdempotencyKey(String idempotencyKey) {
		Assert.notNull(idempotencyKey, "Idempotency cannot be null or empty");
		this.idempotencyKey = idempotencyKey;
	}
}
