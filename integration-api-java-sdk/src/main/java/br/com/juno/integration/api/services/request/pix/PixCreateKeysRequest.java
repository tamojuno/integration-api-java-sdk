package br.com.juno.integration.api.services.request.pix;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseRequestForPix;

public class PixCreateKeysRequest extends BaseRequestForPix {

	private static final long serialVersionUID = 5238805922316045363L;
	
	private String type;
	private String key;
	
	public PixCreateKeysRequest(String idempotencyKey, String type, String key) {
		this(idempotencyKey, JunoApiManager.config().getResourceToken(), type, key);
	}
	
	
	public PixCreateKeysRequest(String idempotencyKey, String resourceToken, String type, String key) {
		this.type = type;
		this.key = key;
		setIdempotencyKey(idempotencyKey);
		setResourceToken(resourceToken);
	}

	public String getType() {
		return type;
	}
	
	public String getKey() {
		return key;
	}
	
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
		
		builder.append("type", getType());
		builder.append("key", getKey());

		return builder.toString();
	}

}
