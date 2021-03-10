package br.com.juno.integration.api.services.request.subscriptions;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseResourceRequest;

public class SubscriptionCreateRequest extends BaseResourceRequest {

    private static final long serialVersionUID = -4614712130882760456L;

    private Integer dueDay;
    private String planId;
    private String chargeDescription;
    private CreditCardDetails creditCardDetails;
    private Billing billing;

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

        private static final long serialVersionUID = -399033998073996520L;

        private final String name;
        private final String document;
        private final String email;
        private final Address address;

        public Billing(String name, String email, String document, Address address) {
            this.name = name;
            this.email = email;
            this.document = document;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getDocument() {
            return document;
        }

        public Address getAddress() {
            return address;
        }

        public static class Address implements Serializable {

            private static final long serialVersionUID = 6736479782279626278L;

            private final String street;
            private final String number;
            private final String city;
            private final String state;
            private final String postCode;

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

            public void setComplement(String complement) {
                this.complement = complement;
            }

            public void setNeighborhood(String neighborhood) {
                this.neighborhood = neighborhood;
            }

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

    public CreditCardDetails getCreditCardDetails() {
        return creditCardDetails;
    }

    public Billing getBilling() {
        return billing;
    }

    public List<Split> getSplit() {
        return split;
    }

}
