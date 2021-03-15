package br.com.juno.integration.api.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.juno.integration.api.utils.CalendarUtils;

public final class LegalRepresentative extends BaseModel {

    private static final long serialVersionUID = 1740806097555664158L;

    private String name;
    private String document;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CalendarUtils.API_DATE_FORMAT)
    private LocalDate birthDate;

    private String motherName;
    private String type;

    protected LegalRepresentative() {
        // NTD
    }

    public LegalRepresentative(String name, String document, LocalDate birthDate, String motherName, String type) {
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
        this.motherName = motherName;
        this.type = type;
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

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
        builder.append("name", getName());
        builder.append("document", getDocument());
        builder.append("birthDate", getBirthDate());
        builder.append("motherName", getMotherName());
        builder.append("type", getType());
        return builder.toString();
    }
}
