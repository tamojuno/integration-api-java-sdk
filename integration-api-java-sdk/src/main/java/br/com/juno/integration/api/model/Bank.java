package br.com.juno.integration.api.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class Bank extends BaseModel {

    private static final long serialVersionUID = -3918516666752671116L;

    private String number;
    private String name;

    protected Bank() {
        // NTD
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    protected void setNumber(String number) {
        this.number = number;
    }

    protected void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(number);
        builder.append(name);
        return builder.toString();
    }
}