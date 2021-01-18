package br.com.juno.integration.api.services.request.transfer;

import java.io.Serializable;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseResourceRequest;

public final class TransferRequest extends BaseResourceRequest {

	private static final long serialVersionUID = 4016895458768370638L;

	private final String type;
	private final String name;
	private final String document;
	private final String amount;
	private final BankAccount bankAccount;
	
	public TransferRequest(String type, String name, String document, String amount, BankAccount bankAccount) {
		this(JunoApiManager.config().getResourceToken(), type, name, document, amount, bankAccount);
	}
	
	public TransferRequest(String resourceToken, String type, String name, String document, String amount, BankAccount bankAccount) {
		super(resourceToken);
		this.type = type;
		this.name = name;
		this.document = document;
		this.amount = amount;
		this.bankAccount = bankAccount;
	}

	public static class BankAccount implements Serializable {
		
		private static final long serialVersionUID = -4086674992068745585L;
		
		private String bankNumber;
	    private String agencyNumber;
	    private String accountNumber;
	    private String accountComplementNumber;
	    private String accountType;
	    
	    public BankAccount(String accountNumber) {
			this.accountNumber = accountNumber;
		}
	    
	    public BankAccount(String bankNumber, String agencyNumber, String accountNumber, 
				String accountType) {
			this.bankNumber = bankNumber;
			this.agencyNumber = agencyNumber;
			this.accountNumber = accountNumber;
			this.accountType = accountType;
		}
	    
	    public BankAccount(String bankNumber, String agencyNumber, String accountNumber, String accountComplementNumber,
				String accountType) {
			this.bankNumber = bankNumber;
			this.agencyNumber = agencyNumber;
			this.accountNumber = accountNumber;
			this.accountComplementNumber = accountComplementNumber;
			this.accountType = accountType;
		}

		public String getBankNumber() {
	    	return bankNumber;
	    }
	    
	    public String getAgencyNumber() {
	    	return agencyNumber;
	    }
	    
	    public String getAccountNumber() {
	    	return accountNumber;
	    }
	    
	    public String getAccountComplementNumber() {
	    	return accountComplementNumber;
	    }
	    
	    public String getAccountType() {
	    	return accountType;
	    }

		public void setBankNumber(String bankNumber) {
			this.bankNumber = bankNumber;
		}

		public void setAgencyNumber(String agencyNumber) {
			this.agencyNumber = agencyNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		public void setAccountComplementNumber(String accountComplementNumber) {
			this.accountComplementNumber = accountComplementNumber;
		}

		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
	    
	}
	
	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getDocument() {
		return document;
	}

	public String getAmount() {
		return amount;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}
	
}
