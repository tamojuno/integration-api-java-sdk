package br.com.juno.integration.api.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class Subscription extends BaseModel {

	private static final long serialVersionUID = -8162032860883214323L;

	private String createdOn;
	private String dueDay;
	private String status;
	private String startsOn;
	private String lastBillingDate;
	private String nextBillingDate;
	
	protected Subscription() {
		// NTD
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public String getDueDay() {
		return dueDay;
	}

	public String getStatus() {
		return status;
	}

	public String getStartsOn() {
		return startsOn;
	}

	public String getLastBillingDate() {
		return lastBillingDate;
	}

	public String getNextBillingDate() {
		return nextBillingDate;
	}
	
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
		
		builder.append("id", getId());
		builder.append("createdOn", getCreatedOn());
		builder.append("dueDay", getDueDay());
		builder.append("status", getStatus());
		builder.append("startsOn", getStartsOn());
		if (StringUtils.contains(getLastBillingDate(), lastBillingDate)) {
			builder.append("lastBillingDate", lastBillingDate);
		}
		builder.append("nextBillingDate", getNextBillingDate());
		return builder.toString();
	}
}
