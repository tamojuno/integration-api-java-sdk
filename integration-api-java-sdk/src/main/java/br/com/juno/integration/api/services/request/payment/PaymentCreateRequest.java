package br.com.juno.integration.api.services.request.payment;

import java.io.Serializable;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseTemplatedRequest;

public class PaymentCreateRequest extends BaseTemplatedRequest<String> {

    private static final long serialVersionUID = 2955775000707665606L;

    private final Billing billing;
    private final CreditCardDetails creditCardDetails;

    public PaymentCreateRequest(String id, Billing billing, CreditCardDetails creditCardDetails) {
        this(JunoApiManager.config().getResourceToken(), id, billing, creditCardDetails);
    }

    public PaymentCreateRequest(String resourceToken, String id, Billing billing, CreditCardDetails creditCardDetails) {
        super(resourceToken, id);
        this.billing = billing;
        this.creditCardDetails = creditCardDetails;
    }

    public static class Billing implements Serializable {

        private static final long serialVersionUID = -399033998073996520L;

        private final String email;
        private final Address address;

        public Billing(String email, Address address) {
            this.email = email;
            this.address = address;
        }

        public String getEmail() {
            return email;
        }

        public Address getAddress() {
            return address;
        }

        public static class Address implements Serializable {

            private static final long serialVersionUID = -8092145998657374456L;

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

    public static class CreditCardDetails implements Serializable {

        private static final long serialVersionUID = -7116502367420005644L;

        private String creditCardId;
        private String creditCardHash;

        private boolean storeCreditCardData;

        public CreditCardDetails(String creditCardId) {
            this.creditCardId = creditCardId;
        }

        public CreditCardDetails(String creditCardHash, boolean storeCreditCardData) {
            this.creditCardHash = creditCardHash;
            this.storeCreditCardData = storeCreditCardData;
        }

        public String getCreditCardId() {
            return creditCardId;
        }

        public String getCreditCardHash() {
            return creditCardHash;
        }

        public boolean isStoreCreditCardData() {
            return storeCreditCardData;
        }

    }

    public Billing getBilling() {
        return billing;
    }

    public CreditCardDetails getCreditCardDetails() {
        return creditCardDetails;
    }

}