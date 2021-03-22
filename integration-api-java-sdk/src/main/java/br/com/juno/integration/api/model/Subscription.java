package br.com.juno.integration.api.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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

    public Subscription(String createdOn, String dueDay, String status, String startsOn, String lastBillingDate, String nextBillingDate) {
        this.createdOn = createdOn;
        this.dueDay = dueDay;
        this.status = status;
        this.startsOn = startsOn;
        this.lastBillingDate = lastBillingDate;
        this.nextBillingDate = nextBillingDate;
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
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);

        builder.append(getId());
        builder.append(getCreatedOn());
        builder.append(getDueDay());
        builder.append(getStatus());
        builder.append(getStartsOn());
        builder.append(getLastBillingDate());
        builder.append(getNextBillingDate());
        return builder.toString();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(getId());
        builder.append(getCreatedOn());
        builder.append(getDueDay());
        builder.append(getStatus());
        builder.append(getStartsOn());
        builder.append(getLastBillingDate());
        builder.append(getNextBillingDate());
        return builder.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Subscription other = (Subscription)obj;
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(this.getCreatedOn(), other.getCreatedOn());
        builder.append(this.getDueDay(), other.getDueDay());
        builder.append(this.getStatus(), other.getStatus());
        builder.append(this.getStartsOn(), other.getStartsOn());
        builder.append(this.getLastBillingDate(), other.getLastBillingDate());
        builder.append(this.getNextBillingDate(), other.getNextBillingDate());
        return super.equals(obj);
    }
}
