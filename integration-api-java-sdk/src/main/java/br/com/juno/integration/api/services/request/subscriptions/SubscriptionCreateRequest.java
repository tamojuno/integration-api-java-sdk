package br.com.juno.integration.api.services.request.subscriptions;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseResourceRequest;
import br.com.juno.integration.api.utils.CalendarUtils;

public class SubscriptionCreateRequest extends BaseResourceRequest {

    private static final long serialVersionUID = -4614712130882760456L;

    private Integer dueDay;
    private String planId;
    private String chargeDescription;
    private final CreditCardDetails creditCardDetails;
    private final Billing billing;

    private List<Split> split = new LinkedList<>();

    public SubscriptionCreateRequest(Integer dueDay, String planId, String chargeDescription, CreditCardDetails creditCardDetails, Billing billing,
            List<Split> split) {
        this(JunoApiManager.config().getResourceToken(), dueDay, planId, chargeDescription, creditCardDetails, billing, split);
    }

    public SubscriptionCreateRequest(String resourceToken, Integer dueDay, String planId, String chargeDescription,
            CreditCardDetails creditCardDetails, Billing billing, List<Split> split) {
        super(resourceToken);
        this.dueDay = dueDay;
        this.planId = planId;
        this.chargeDescription = chargeDescription;
        this.creditCardDetails = creditCardDetails;
        this.billing = billing;
        this.split = split;
    }

    public CreditCardDetails getCreditCardDetails() {
        return creditCardDetails;
    }

    public Billing getBilling() {
        return billing;
    }

    public static class CreditCardDetails implements Serializable {

        private static final long serialVersionUID = -8367973883572221156L;

        private final String creditCardId;
        private String creditCardHash;

        public CreditCardDetails(String creditCardId) {
            this.creditCardId = creditCardId;
        }

        public String getCreditCardId() {
            return creditCardId;
        }

        public String getCreditCardHash() {
            return creditCardHash;
        }

    }

    public static class Billing implements Serializable {

        private static final long serialVersionUID = -6641053350149713609L;

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

            private static final long serialVersionUID = 550674101703674606L;
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

    public static class Split implements Serializable {

        private static final long serialVersionUID = -422616029724650523L;

        private String recipientToken;
        private BigDecimal amount;
        private BigDecimal percentage;
        private boolean amountRemainder;
        private boolean chargeFee;

        public Split(String recipientToken, BigDecimal amount, BigDecimal percentage, boolean amountRemainder, boolean chargeFee) {
            this.recipientToken = recipientToken;
            this.amount = amount;
            this.percentage = percentage;
            this.amountRemainder = amountRemainder;
            this.chargeFee = chargeFee;
        }

        public String getRecipientToken() {
            return recipientToken;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public BigDecimal getPercentage() {
            return percentage;
        }

        public boolean isAmountRemainder() {
            return amountRemainder;
        }

        public boolean isChargeFee() {
            return chargeFee;
        }

        public void setRecipientToken(String recipientToken) {
            this.recipientToken = recipientToken;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public void setPercentage(BigDecimal percentage) {
            this.percentage = percentage;
        }

        public void setAmountRemainder(boolean amountRemainder) {
            this.amountRemainder = amountRemainder;
        }

        public void setChargeFee(boolean chargeFee) {
            this.chargeFee = chargeFee;
        }

    }

    public Integer getDueDay() {
        return dueDay;
    }

    public String getPlanId() {
        return planId;
    }

    public String getChargeDescription() {
        return chargeDescription;
    }

    public List<Split> getSplit() {
        return split;
    }

}
