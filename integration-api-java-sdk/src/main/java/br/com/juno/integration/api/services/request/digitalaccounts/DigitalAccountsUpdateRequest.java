package br.com.juno.integration.api.services.request.digitalaccounts;

import java.io.Serializable;

import br.com.juno.integration.api.model.Address;
import br.com.juno.integration.api.model.BankAccount;
import br.com.juno.integration.api.model.BankAccountHolder;
import br.com.juno.integration.api.model.LegalRepresentative;
import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseResourceRequest;

public class DigitalAccountsUpdateRequest extends BaseResourceRequest {

	private static final long serialVersionUID = 4533250838051097619L;
	
	private String name; 
	private String email;
	private String birthDate;
	private String phone;
	private Long businessArea;
	private String linesOfBusiness;
	private String companyType;
	private String tradingName;
	private LegalRepresentative legalRepresentative;
	private Address address;
	private BankAccount bankAccount;
	
	public DigitalAccountsUpdateRequest(String name, String birthDate, String phone, Long businessArea, String linesOfBusiness, String companyType, String tradingName, LegalRepresentative legalRepresentative, Address address, BankAccount bankAccount) {
		this(JunoApiManager.config().getResourceToken(), name, birthDate, phone, businessArea, linesOfBusiness, companyType, tradingName, legalRepresentative, address, bankAccount);
	}
	public DigitalAccountsUpdateRequest(String resourceToken, String name, String birthDate, String phone, Long businessArea, String linesOfBusiness, String companyType, String tradingName, LegalRepresentative legalRepresentative, Address address, BankAccount bankAccount) {
		super(resourceToken);
		this.name = name;
		this.birthDate = birthDate;
		this.phone = phone;
		this.businessArea = businessArea;
		this.companyType = companyType;
		this.linesOfBusiness = linesOfBusiness;
		this.tradingName = tradingName;
		this.legalRepresentative = legalRepresentative;
		this.address = address;
		this.bankAccount = bankAccount;
	}
	
	public static class LegalRepresentative implements Serializable {
		
		private static final long serialVersionUID = 2866955003064976592L;

		private String name;
		private String document;
		private String birthDate;
		
		public LegalRepresentative(String name, String document, String birthDate) {
			this.name = name;
			this.document = document;
			this.birthDate = birthDate;
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

	}
	
	public static class Address implements Serializable {
		
		private static final long serialVersionUID = -8540060367048891146L;

		private String street;
        private String number;
        private String city;
        private String state;
        private String postCode;

        private String complement;
        private String neighborhood;

        public Address(String street, String number, String city, String state, String postCode) {
            this.street = street;
            this.number = number;
            this.city = city;
            this.state = state;
            this.postCode = postCode;
        }

        public String getStreet() {
            return street;
        }

        public String getNumber() {
            return number;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getPostCode() {
            return postCode;
        }

        public String getComplement() {
            return complement;
        }

        public String getNeighborhood() {
            return neighborhood;
        }

    }

	public static class BankAccount implements Serializable {

		private static final long serialVersionUID = 478211196443175560L;
		
		private String bankNumber;
	    private String agencyNumber;
	    private String accountNumber;
	    private String accountType;
	    
	    private String accountComplementNumber;
	    private BankAccountHolder accountHolder;
	    
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
	    
		public BankAccount(String bankNumber, String agencyNumber, String accountNumber, String accountType,
				String accountComplementNumber, BankAccountHolder accountHolder) {
			this.bankNumber = bankNumber;
			this.agencyNumber = agencyNumber;
			this.accountNumber = accountNumber;
			this.accountType = accountType;
			this.accountComplementNumber = accountComplementNumber;
			this.accountHolder = accountHolder;
		}
		
		public BankAccount(String bankNumber, String agencyNumber, String accountNumber, String accountType, BankAccountHolder accountHolder) {
			this.bankNumber = bankNumber;
			this.agencyNumber = agencyNumber;
			this.accountNumber = accountNumber;
			this.accountType = accountType;
			this.accountHolder = accountHolder;
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
		public BankAccountHolder getAccountHolder() {
			return accountHolder;
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
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public void setAccountComplementNumber(String accountComplementNumber) {
			this.accountComplementNumber = accountComplementNumber;
		}
		public void setBankAccountHolder(BankAccountHolder accountHolder) {
			this.accountHolder = accountHolder;
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Long getBusinessArea() {
		return businessArea;
	}
	
	public String getLinesOfBusiness() {
		return linesOfBusiness;
	}
	
	public void setBusinessArea(Long businessArea) {
		this.businessArea = businessArea;
	}
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getTradingName() {
		return tradingName;
	}
	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}
	
	
}
