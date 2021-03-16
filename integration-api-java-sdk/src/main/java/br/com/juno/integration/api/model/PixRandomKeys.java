package br.com.juno.integration.api.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PixRandomKeys extends BaseModel {

    private static final long serialVersionUID = 7060693572283711869L;

    private String key;
    private String creationDateTime;
    private String ownershipDateTime;
    private String claimRequestDateTime;

    protected PixRandomKeys() {
        // NTD
    }

    public String getKey() {
        return key;
    }

    public String getCreationDateTime() {
        return creationDateTime;
    }

    public String getOwnershipDateTime() {
        return ownershipDateTime;
    }

    public String getClaimRequestDateTime() {
        return claimRequestDateTime;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setCreationDateTime(String creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public void setOwnershipDateTime(String ownershipDateTime) {
        this.ownershipDateTime = ownershipDateTime;
    }

    public void setClaimRequestDateTime(String claimRequestDateTime) {
        this.claimRequestDateTime = claimRequestDateTime;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);

        builder.append(getId());
        builder.append(getKey());
        builder.append(getCreationDateTime());
        builder.append(getOwnershipDateTime());
        builder.append(getClaimRequestDateTime());

        return builder.toString();
    }
}
