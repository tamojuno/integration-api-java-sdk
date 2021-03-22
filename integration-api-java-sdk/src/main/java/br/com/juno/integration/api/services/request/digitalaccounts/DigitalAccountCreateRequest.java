package br.com.juno.integration.api.services.request.digitalaccounts;

import java.math.BigDecimal;

import br.com.juno.integration.api.model.Address;
import br.com.juno.integration.api.model.BankAccount;
import br.com.juno.integration.api.model.LegalRepresentative;
import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseResourceRequest;

public class DigitalAccountCreateRequest extends BaseResourceRequest {

    private static final long serialVersionUID = -7908892259603342475L;

    private final String type;
    private final String name;
    private final String document;
    private final String email;
    private final String birthDate;
    private final String phone;
    private final Long businessArea;
    private final String linesOfBusiness;
    private final String motherName;
    private final BigDecimal monthlyIncomeOrRevenue;
    private final String companyType;
    private final LegalRepresentative legalRepresentative;
    private final Address address;
    private final BankAccount bankAccount;

    public DigitalAccountCreateRequest(String type, String name, String document, String email, String birthDate, String phone, Long businessArea,
            String linesOfBusiness, String motherName, BigDecimal monthlyIncomeOrRevenue, String companyType, LegalRepresentative legalRepresentative,
            Address address, BankAccount bankAccount) {
        this(JunoApiManager.config().getResourceToken(), type, name, document, email, birthDate, phone, businessArea, linesOfBusiness, motherName,
                monthlyIncomeOrRevenue, companyType, legalRepresentative, address, bankAccount);
    }

    public DigitalAccountCreateRequest(String resourceToken, String type, String name, String document, String email, String birthDate, String phone,
            Long businessArea, String linesOfBusiness, String motherName, BigDecimal monthlyIncomeOrRevenue, String companyType,
            LegalRepresentative legalRepresentative, Address address, BankAccount bankAccount) {
        super(resourceToken);
        this.type = type;
        this.name = name;
        this.document = document;
        this.email = email;
        this.birthDate = birthDate;
        this.phone = phone;
        this.businessArea = businessArea;
        this.linesOfBusiness = linesOfBusiness;
        this.motherName = motherName;
        this.monthlyIncomeOrRevenue = monthlyIncomeOrRevenue;
        this.companyType = companyType;
        this.legalRepresentative = legalRepresentative;
        this.address = address;
        this.bankAccount = bankAccount;
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

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public Long getBusinessArea() {
        return businessArea;
    }

    public String getMotherName() {
        return motherName;
    }

    public BigDecimal getMonthlyIncomeOrRevenue() {
        return monthlyIncomeOrRevenue;
    }

    public String getLinesOfBusiness() {
        return linesOfBusiness;
    }

    public String getCompanyType() {
        return companyType;
    }

    public LegalRepresentative getLegalRepresentative() {
        return legalRepresentative;
    }

    public Address getAddress() {
        return address;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

}
