package br.com.juno.integration.api.services.request.plans;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseRequest;

public class PlanCreateRequest extends BaseRequest {

	private static final long serialVersionUID = 8206864204480020532L;

	private String name;
	private BigDecimal amount;
	
	public PlanCreateRequest(String name, BigDecimal amount) {
		this(JunoApiManager.config().getResourceToken(), name, amount);
	}

	public PlanCreateRequest(String resourceToken, String name, BigDecimal amount) {
		this.name = name;
		this.amount = amount;
		setResourceToken(resourceToken);
	}
	
	public String getName() {
		return name;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
		
		builder.append("name", getName());
		builder.append("amount", getAmount());
		
		return builder.toString();
	}
	
}
