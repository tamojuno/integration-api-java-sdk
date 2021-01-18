package br.com.juno.integration.api.services.request.picpay;

import java.time.LocalDate;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseResourceRequest;

public class PicpayCreateRequest extends BaseResourceRequest {

	private static final long serialVersionUID = 3019337702390433511L;

		private final String type;
        private final Long chargeCode;
        private final LocalDate expiresAt;
        
        public PicpayCreateRequest(String type, Long chargeCode, LocalDate expiresAt) {
        	this(JunoApiManager.config().getResourceToken(), type, chargeCode, expiresAt);
        }
        
        public PicpayCreateRequest(String resourceToken, String type, Long chargeCode, LocalDate expiresAt) {
        	super(resourceToken);
        	this.type = type;
        	this.chargeCode = chargeCode;
        	this.expiresAt = expiresAt;
        }
        
        public String getType() {
			return type;
		}
		
		public Long getChargeCode() {
			return chargeCode;
		}
		
		public LocalDate getExpiresAt() {
			return expiresAt;
		}
		
		@Override
		public String toString() {
			ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE); 
				builder.append(type);
				builder.append(chargeCode);
				builder.append(expiresAt);
				return builder.toString();
		}
}

