package br.com.juno.integration.api.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class EventType extends BaseModel {

    private static final long serialVersionUID = -3789611368817329584L;

    private String name;
    private String label;
    private EventStatus status;

    protected EventType() {
        // NTD
    }

    public enum EventStatus {
        ENABLED,
        DEPRECATED;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public EventStatus getStatus() {
        return status;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setLabel(String label) {
        this.label = label;
    }

    protected void setStatus(EventStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(getId());
        builder.append(name);
        builder.append(label);
        builder.append(status);
        return builder.toString();
    }
}
