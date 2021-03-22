package br.com.juno.integration.api.model;

import java.time.LocalDate;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class LegalRepresentative extends BaseModel {

    private static final long serialVersionUID = 1740806097555664158L;

    private String name;
    private String document;
    private LocalDate birthDate;
    private String motherName;
    private String type;

    public LegalRepresentative() {
        // NTD
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public void setType(String type) {
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
