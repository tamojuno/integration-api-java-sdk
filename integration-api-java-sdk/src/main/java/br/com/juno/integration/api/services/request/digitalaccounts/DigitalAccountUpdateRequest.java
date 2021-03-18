package br.com.juno.integration.api.services.request.digitalaccounts;

import br.com.juno.integration.api.model.Address;
import br.com.juno.integration.api.model.BankAccount;
import br.com.juno.integration.api.model.LegalRepresentative;
import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseResourceRequest;

public class DigitalAccountUpdateRequest extends BaseResourceRequest {

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

    public LegalRepresentative getLegalRepresentative() {
        return legalRepresentative;
    }

    public Address getAddress() {
        return address;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public DigitalAccountUpdateRequest(String name, String birthDate, String phone, Long businessArea, String linesOfBusiness, String companyType,
            String tradingName, LegalRepresentative legalRepresentative, Address address, BankAccount bankAccount) {
        this(JunoApiManager.config().getResourceToken(), name, birthDate, phone, businessArea, linesOfBusiness, companyType, tradingName,
                legalRepresentative, address, bankAccount);
    }

    public DigitalAccountUpdateRequest(String resourceToken, String name, String birthDate, String phone, Long businessArea, String linesOfBusiness,
            String companyType, String tradingName, LegalRepresentative legalRepresentative, Address address, BankAccount bankAccount) {
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
