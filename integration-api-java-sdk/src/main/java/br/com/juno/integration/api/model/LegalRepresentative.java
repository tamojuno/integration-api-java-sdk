package br.com.juno.integration.api.model;

import java.util.Calendar;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class LegalRepresentative extends BaseModel {

	private static final long serialVersionUID = 1740806097555664158L;

	private String name;
	private String document;
	private Calendar birthDate;
	
	protected LegalRepresentative() {
		// NTD
	}
	
	public LegalRepresentative(String name, String document, Calendar birthDate) {
		this.name = name;
		this.document = name;
		this.birthDate = birthDate;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDocument() {
		return document;
	}
	
	public Calendar getBirthDate() {
		return birthDate;
	}
	
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
		builder.append(getName());
		builder.append(getDocument());
		builder.append(getBirthDate());
		return builder.toString();
	}
}
