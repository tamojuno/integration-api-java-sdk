package br.com.juno.integration.api.model;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class Transfer extends BaseModel {

	private static final long serialVersionUID = -2887521733291703660L;

	private String digitalAccountId;
	private String creationDate;
	private String transferDate;
	private BigDecimal amount;
	private String status;
	private Recipient recipient;
	
	protected Transfer() {
		// NTD
	}

	public String getDigitalAccountId() {
		return digitalAccountId;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public String getTransferDate() {
		return transferDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getStatus() {
		return status;
	}

	public Recipient getRecipient() {
		return recipient;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
		builder.append("id", getId());
		builder.append("digitalAccountId", getDigitalAccountId());
		builder.append("creationDate", getCreationDate());
		builder.append("transferDate", getTransferDate());
		builder.append("amount", getAmount());
		builder.append("status", getStatus());
		builder.append("recipient", getRecipient());
		return builder.toString();
	}
}
