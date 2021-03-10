package br.com.juno.integration.api.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Recipient extends BaseModel {

	private static final long serialVersionUID = 2713548342303665977L;

	private String name;
	private String document; 
	private BankAccount bankAccount;
	
	
	protected Recipient() {
		// NTD
	}
	
	protected Recipient(String name, String document, String accountNumber, String bankNumber, String agencyNumber, String accountComplementNumber, String accountType) {
		this.name = name;
		this.document = document;
		this.bankAccount = new BankAccount(bankNumber, agencyNumber, accountNumber, accountComplementNumber, BankAccountType.valueOf(accountType));
	}
	
	public String getName() {
		return name;
	}
	
	public String getDocument() {
		return document;
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	
	@Override
	  public String toString() {
	      ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
	      builder.append("name", name);
	      builder.append("document", document);
	      builder.append("bankAccount", bankAccount);
	      return builder.toString();
	  }
}
