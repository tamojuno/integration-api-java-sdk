package br.com.juno.integration.api.services.request.charge;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseResourceRequest;
import br.com.juno.integration.api.utils.CalendarUtils;

public final class ChargeCreateRequest extends BaseResourceRequest {

    private static final long serialVersionUID = 7287757661166353769L;

    private final Charge charge;
    private final Billing billing;

    public ChargeCreateRequest(Charge charge, Billing billing) {
        this(JunoApiManager.config().getResourceToken(), charge, billing);
    }

    public ChargeCreateRequest(String resourceToken, Charge charge, Billing billing) {
        super(resourceToken);
        this.charge = charge;
        this.billing = billing;
    }

    public Charge getCharge() {
        return charge;
    }

    public Billing getBilling() {
        return billing;
    }

    public static class Charge implements Serializable {

        private static final long serialVersionUID = 209164858682596232L;

        private String description;
        private Integer installments;
        private Integer maxOverdueDays;
        private Integer discountDays;
        private BigDecimal totalAmount;
        private BigDecimal amount;
        private BigDecimal fine;
        private BigDecimal interest;
        private BigDecimal discountAmount;
        private Boolean paymentAdvance;

        private List<String> references = new LinkedList<>();
        private Set<PaymentType> paymentTypes = new HashSet<>();

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CalendarUtils.API_DATE_FORMAT)
        private LocalDate dueDate;

        public enum PaymentType {
            BOLETO,
            CREDIT_CARD;
        }

        public Charge(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public List<String> getReferences() {
            return references;
        }

        public BigDecimal getTotalAmount() {
            return totalAmount;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public LocalDate getDueDate() {
            return dueDate;
        }

        public Integer getInstallments() {
            return installments;
        }

        public Integer getMaxOverdueDays() {
            return maxOverdueDays;
        }

        public BigDecimal getFine() {
            return fine;
        }

        public BigDecimal getInterest() {
            return interest;
        }

        public BigDecimal getDiscountAmount() {
            return discountAmount;
        }

        public Integer getDiscountDays() {
            return discountDays;
        }

        public Set<PaymentType> getPaymentTypes() {
            return paymentTypes;
        }

        public Boolean getPaymentAdvance() {
            return paymentAdvance;
        }

        public void setInstallments(Integer installments) {
            this.installments = installments;
        }

        public void setMaxOverdueDays(Integer maxOverdueDays) {
            this.maxOverdueDays = maxOverdueDays;
        }

        public void setDiscountDays(Integer discountDays) {
            this.discountDays = discountDays;
        }

        public void setTotalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public void setFine(BigDecimal fine) {
            this.fine = fine;
        }

        public void setInterest(BigDecimal interest) {
            this.interest = interest;
        }

        public void setDiscountAmount(BigDecimal discountAmount) {
            this.discountAmount = discountAmount;
        }

        public void setPaymentAdvance(Boolean paymentAdvance) {
            this.paymentAdvance = paymentAdvance;
        }

        public void setDueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
        }

    }

    public static class Billing implements Serializable {

        private static final long serialVersionUID = -399033998073996520L;

        private String name;
        private String document;
        private String email;
        private Address address;
        private String secondaryEmail;
        private String phone;
        private Boolean notify;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CalendarUtils.API_DATE_FORMAT)
        private LocalDate birthDate;

        public static class Address implements Serializable {

            private static final long serialVersionUID = -399033998073996520L;

            private String street;
            private String number;
            private String complement;
            private String neighborhood;
            private String city;
            private String state;
            private String postCode;

            public String getStreet() {
                return street;
            }

            public String getNumber() {
                return number;
            }

            public String getComplement() {
                return complement;
            }

            public String getNeighborhood() {
                return neighborhood;
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

            public void setStreet(String street) {
                this.street = street;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public void setComplement(String complement) {
                this.complement = complement;
            }

            public void setNeighborhood(String neighborhood) {
                this.neighborhood = neighborhood;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public void setState(String state) {
                this.state = state;
            }

            public void setPostCode(String postCode) {
                this.postCode = postCode;
            }

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDocument() {
            return document;
        }

        public void setDocument(String document) {
            this.document = document;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public String getSecondaryEmail() {
            return secondaryEmail;
        }

        public void setSecondaryEmail(String secondaryEmail) {
            this.secondaryEmail = secondaryEmail;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
        }

        public Boolean getNotify() {
            return notify;
        }

        public void setNotify(Boolean notify) {
            this.notify = notify;
        }

    }
}
