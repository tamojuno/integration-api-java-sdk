package br.com.juno.integration.api.services.request.payment;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseResourceRequest;
import br.com.juno.integration.api.utils.CalendarUtils;

public class PaymentCreateRequest extends BaseResourceRequest {

    private static final long serialVersionUID = 2955775000707665606L;

    private final String chargeId;
    private final Billing billing;
    private final CreditCardDetails creditCardDetails;

    public PaymentCreateRequest(String id, Billing billing, CreditCardDetails creditCardDetails) {
        this(JunoApiManager.config().getResourceToken(), id, billing, creditCardDetails);
    }

    public PaymentCreateRequest(String resourceToken, String chargeId, Billing billing, CreditCardDetails creditCardDetails) {
        super(resourceToken);
        this.chargeId = chargeId;
        this.billing = billing;
        this.creditCardDetails = creditCardDetails;
    }

    public static class Billing implements Serializable {

        private static final long serialVersionUID = 2168079270412107521L;

        private String name;
        private String document;
        private String email;
        private Address address;
        private String secondaryEmail;
        private String phone;
        private Boolean notify;

        public String getName() {
            return name;
        }

        public String getDocument() {
            return document;
        }

        public String getEmail() {
            return email;
        }

        public Address getAddress() {
            return address;
        }

        public String getSecondaryEmail() {
            return secondaryEmail;
        }

        public String getPhone() {
            return phone;
        }

        public Boolean getNotify() {
            return notify;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDocument(String document) {
            this.document = document;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public void setSecondaryEmail(String secondaryEmail) {
            this.secondaryEmail = secondaryEmail;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setNotify(Boolean notify) {
            this.notify = notify;
        }

        public void setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
        }

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CalendarUtils.API_DATE_FORMAT)
        private LocalDate birthDate;

        public static class Address implements Serializable {

            private static final long serialVersionUID = -2343326568851744536L;

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
    }

    public static class CreditCardDetails implements Serializable {

        private static final long serialVersionUID = -7116502367420005644L;

        private String creditCardId;
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

    public Billing getBilling() {
        return billing;
    }

    public CreditCardDetails getCreditCardDetails() {
        return creditCardDetails;
    }

    public String getChargeId() {
        return chargeId;
    }

}