package br.com.juno.integration.api.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class LegalRepresentative extends BaseModel {

    private static final long serialVersionUID = 1740806097555664158L;

    private String name;
    private String document;
    private String birthDate;
    private String motherName;
    private String type;

    protected LegalRepresentative() {
        // NTD
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getType() {
        return type;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setDocument(String document) {
        this.document = document;
    }

    protected void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    protected void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    protected void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(getName());
        builder.append(getDocument());
        builder.append(getBirthDate());
        builder.append(getMotherName());
        builder.append(getType());
        return builder.toString();
    }
}
