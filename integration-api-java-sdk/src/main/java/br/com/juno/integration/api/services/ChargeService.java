package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.X_RESOURCE_TOKEN;
import static br.com.juno.integration.api.utils.ResponseUtils.validateSuccess;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import br.com.juno.integration.api.base.exception.JunoApiException;
import br.com.juno.integration.api.model.Charge;
import br.com.juno.integration.api.model.LabeledEnum;
import br.com.juno.integration.api.model.response.Responses;
import br.com.juno.integration.api.utils.CalendarUtils;
import br.com.juno.integration.api.utils.JacksonUtils;
import kong.unirest.GenericType;
import kong.unirest.GetRequest;
import kong.unirest.HttpRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class ChargeService extends BaseService {

    private static final Double MIN_RECORDS_PER_REQUEST = 20D;
    private static final Double MAX_RECORDS_PER_REQUEST = 100D;

    ChargeService() {
        // NTD
    }

    public ChargeCreateBuilder create() {
        return new ChargeCreateBuilder();
    }

    public ChargeListBuilder list() {
        return new ChargeListBuilder();
    }

    public static class ChargeCreateBuilder {

        private ChargeHolder chargeHolder;

        ChargeCreateBuilder() {
            chargeHolder = new ChargeHolder(this);
        }

        public List<br.com.juno.integration.api.model.Charge> create() {
            return create(JunoApiManager.config().getResourceToken());
        }

        public List<br.com.juno.integration.api.model.Charge> create(String resourceToken) {

            String requestBody;
            try {
                requestBody = JacksonUtils.getObjectMapper().writeValueAsString(chargeHolder());
            } catch (JsonProcessingException e) {
                throw new JunoApiException(e);
            }

            HttpResponse<Resources<Resource<br.com.juno.integration.api.model.Charge>>> httpResponse = Unirest.post( //
                    JunoApiManager.config().getEnvironmentUrl() + "/api-integration/charges") //
                    .headers(JunoApiManager.resources().authorization().getAuthorizationHeader()) //
                    .header(X_RESOURCE_TOKEN, resourceToken) //
                    .body(requestBody) //
                    .asObject(new GenericType<Resources<Resource<br.com.juno.integration.api.model.Charge>>>() { //
                        // NTD
                    });//

            validateSuccess(httpResponse);

            return new Responses<>(httpResponse.getBody()).getAbsoluteContent();
        }

        public Charge charge() {
            return chargeHolder.getCharge();
        }

        public Billing billing() {
            return chargeHolder.getBilling();
        }

        private ChargeHolder chargeHolder() {
            return chargeHolder;
        }

        public static class ChargeHolder {

            private ChargeCreateBuilder builder;

            public ChargeHolder(ChargeCreateBuilder builder) {
                this.builder = builder;
                this.charge = new Charge(builder, this);
                this.billing = new Billing(builder, this);

                this.billing.setCharge(this.charge);
                this.charge.setBilling(this.billing);
            }

            private Charge charge;
            private Billing billing;

            public Charge getCharge() {
                return charge;
            }

            public Billing getBilling() {
                return billing;
            }
        }

        public static class Charge implements Serializable {

            private static final long serialVersionUID = 209164858682596232L;

            @JsonProperty
            private String description;
            @JsonProperty
            private List<String> references = new LinkedList<>();
            @JsonProperty
            private BigDecimal totalAmount;
            @JsonProperty
            private BigDecimal amount;
            @JsonProperty
            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CalendarUtils.API_DATE_FORMAT)
            private LocalDate dueDate;
            @JsonProperty
            private Integer installments;
            @JsonProperty
            private Integer maxOverdueDays;
            @JsonProperty
            private BigDecimal fine;
            @JsonProperty
            private BigDecimal interest;
            @JsonProperty
            private BigDecimal discountAmount;
            @JsonProperty
            private Integer discountDays;
            @JsonProperty
            private Set<PaymentType> paymentTypes = new HashSet<>();
            @JsonProperty
            private Boolean paymentAdvance;

            @JsonIgnore
            private Billing billing;

            @JsonIgnore
            private ChargeCreateBuilder builder;

            @JsonIgnore
            private ChargeHolder holder;

            public Charge(ChargeCreateBuilder builder, ChargeHolder holder) {
                this.builder = builder;
                this.holder = holder;
            }

            private void setBilling(Billing billing) {
                this.billing = billing;
            }

            public Billing billing() {
                return billing;
            }

            public List<br.com.juno.integration.api.model.Charge> create(String resourceToken) {
                return builder.create(resourceToken);
            }

            public List<br.com.juno.integration.api.model.Charge> create() {
                return builder.create();
            }

            public enum PaymentType {
                BOLETO,
                CREDIT_CARD;
            }

            public Charge description(String description) {
                this.description = description;
                return this;
            }

            public Charge references(List<String> references) {
                this.references.addAll(references);
                return this;
            }

            public Charge reference(String reference) {
                this.references.add(reference);
                return this;
            }

            public Charge totalAmount(BigDecimal totalAmount) {
                this.totalAmount = totalAmount;
                return this;
            }

            public Charge amount(BigDecimal amount) {
                this.amount = amount;
                return this;
            }

            public Charge dueDate(LocalDate dueDate) {
                this.dueDate = dueDate;
                return this;
            }

            public Charge installments(Integer installments) {
                this.installments = installments;
                return this;
            }

            public Charge maxOverdueDays(Integer maxOverdueDays) {
                this.maxOverdueDays = maxOverdueDays;
                return this;
            }

            public Charge fine(BigDecimal fine) {
                this.fine = fine;
                return this;
            }

            public Charge interest(BigDecimal interest) {
                this.interest = interest;
                return this;
            }

            public Charge discountAmount(BigDecimal discountAmount) {
                this.discountAmount = discountAmount;
                return this;
            }

            public Charge discountDays(Integer discountDays) {
                this.discountDays = discountDays;
                return this;
            }

            public Charge paymentTypes(Set<PaymentType> paymentTypes) {
                this.paymentTypes.addAll(paymentTypes);
                return this;
            }

            public Charge paymentType(PaymentType paymentType) {
                this.paymentTypes.add(paymentType);
                return this;
            }

            public Charge paymentAdvance(Boolean paymentAdvance) {
                this.paymentAdvance = paymentAdvance;
                return this;
            }

        }

        public static class Billing implements Serializable {

            private static final long serialVersionUID = -399033998073996520L;

            @JsonProperty
            private String name;
            @JsonProperty
            private String document;
            @JsonProperty
            private String email;
            @JsonProperty
            private String secondaryEmail;
            @JsonProperty
            private String phone;
            @JsonProperty
            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CalendarUtils.API_DATE_FORMAT)
            private LocalDate birthDate;
            @JsonProperty
            private Boolean notify;

            @JsonIgnore
            private Charge charge;

            @JsonIgnore
            private ChargeCreateBuilder builder;

            @JsonIgnore
            private ChargeHolder holder;

            public Billing(ChargeCreateBuilder builder, ChargeHolder holder) {
                this.builder = builder;
                this.holder = holder;
            }

            public List<br.com.juno.integration.api.model.Charge> create(String resourceToken) {
                return builder.create(resourceToken);
            }

            public List<br.com.juno.integration.api.model.Charge> create() {
                return builder.create();
            }

            private void setCharge(Charge charge) {
                this.charge = charge;
            }

            public Charge charge() {
                return charge;
            }

            public Billing name(String name) {
                this.name = name;
                return this;
            }

            public Billing document(String document) {
                this.document = document;
                return this;
            }

            public Billing email(String email) {
                this.email = email;
                return this;
            }

            public Billing secondaryEmail(String secondaryEmail) {
                this.secondaryEmail = secondaryEmail;
                return this;
            }

            public Billing phone(String phone) {
                this.phone = phone;
                return this;
            }

            public Billing birthDate(LocalDate birthDate) {
                this.birthDate = birthDate;
                return this;
            }

            public Billing notify(Boolean notify) {
                this.notify = notify;
                return this;
            }
        }

    }

    public static class ChargeListBuilder {

        ChargeListBuilder() {
            // NTD
        }

        private Calendar createdOnStart;
        private Calendar createdOnEnd;
        private Calendar dueDateStart;
        private Calendar dueDateEnd;
        private Calendar paymentDateStart;
        private Calendar paymentDateEnd;
        private Boolean showUnarchived;
        private Boolean showArchived;
        private Boolean showDue;
        private Boolean showNotDue;
        private Boolean showPaid;
        private Boolean showNotPaid;
        private Boolean showCancelled;
        private Boolean showNotCancelled;
        private Boolean showManualReconciliation;
        private Boolean showNotManualReconciliation;
        private Boolean showNotFailed;
        private OrderBy orderBy;
        private Boolean orderAsc;
        private Integer pageSize;

        public enum OrderBy implements LabeledEnum {
            ID("id"),
            DUE_DATE("dueDate"),
            AMOUNT("amount"),
            PAYMENT_DATE("paymentDate");

            private OrderBy(String label) {
                this.label = label;
            }

            private String label;

            @Override
            public String getLabel() {
                return label;
            }
        }

        public Responses<Charge> get() {
            return get(JunoApiManager.config().getResourceToken());
        }

        public Responses<Charge> get(String resourceToken) {
            List<Responses<Charge>> responsePages = new LinkedList<>();

            Responses<Charge> currentPage = getFirstPage(resourceToken);

            if (getTotalPages() > 1) {
                for (int pageIndex = 1; pageIndex < getTotalPages(); pageIndex++) {
                    responsePages.add(currentPage);
                    currentPage = getNextPage(currentPage);
                }
            }

            responsePages.add(currentPage);

            return new Responses<>(responsePages, resourceToken);
        }

        public Responses<Charge> getNextPage(Responses<Charge> currentPage) {
            Responses<Charge> responses = null;

            if (StringUtils.isNotBlank(currentPage.getHrefNext())) {
                responses = getPage(currentPage.getResourceToken(), currentPage.getHrefNext());
            }

            return responses != null ? responses : new Responses<>(new LinkedList<>(), currentPage.getResourceToken());
        }

        private Responses<Charge> getPage(String resourceToken, String hateoasLink) {
            GetRequest httpRequest = Unirest.get(hateoasLink) //
                    .headers(JunoApiManager.resources().authorization().getAuthorizationHeader()) //
                    .header(X_RESOURCE_TOKEN, resourceToken);

            return exchange(httpRequest);
        }

        private Responses<Charge> getPage(String resourceToken) {
            GetRequest httpRequest = Unirest.get(JunoApiManager.config().getEnvironmentUrl() + "/api-integration/charges") //
                    .headers(JunoApiManager.resources().authorization().getAuthorizationHeader()) //
                    .header(X_RESOURCE_TOKEN, resourceToken);

            populateParameters(httpRequest);

            return exchange(httpRequest);
        }

        private Responses<Charge> getFirstPage(String resourceToken) {
            return getPage(resourceToken);
        }

        private Responses<Charge> exchange(GetRequest httpRequest) {
            HttpResponse<Resources<Resource<Charge>>> httpResponse = httpRequest.asObject(new GenericType<Resources<Resource<Charge>>>() {
                // NTD
            });

            validateSuccess(httpResponse);

            return new Responses<>(httpResponse.getBody(), httpRequest.getHeaders().getFirst(X_RESOURCE_TOKEN));
        }

        private void populateParameters(HttpRequest<GetRequest> httpRequest) {
            try {
                Field[] fields = this.getClass().getDeclaredFields();

                for (Field field : fields) {
                    if (field.get(this) != null) {
                        if (field.getType().isEnum()) {
                            httpRequest.queryString(field.getName(), ((LabeledEnum)field.get(this)).getLabel());
                        } else {
                            httpRequest.queryString(field.getName(), field.get(this));
                        }
                    }
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new JunoApiException(e);
            }
        }

        public ChargeListBuilder createdOnStart(Calendar createdOnStart) {
            this.createdOnStart = createdOnStart;
            return this;
        }

        public ChargeListBuilder createdOnEnd(Calendar createdOnEnd) {
            this.createdOnEnd = createdOnEnd;
            return this;
        }

        public ChargeListBuilder dueDateStart(Calendar dueDateStart) {
            this.dueDateStart = dueDateStart;
            return this;
        }

        public ChargeListBuilder dueDateEnd(Calendar dueDateEnd) {
            this.dueDateEnd = dueDateEnd;
            return this;
        }

        public ChargeListBuilder paymentDateStart(Calendar paymentDateStart) {
            this.paymentDateStart = paymentDateStart;
            return this;
        }

        public ChargeListBuilder paymentDateEnd(Calendar paymentDateEnd) {
            this.paymentDateEnd = paymentDateEnd;
            return this;
        }

        public ChargeListBuilder showUnarchived(Boolean showUnarchived) {
            this.showUnarchived = showUnarchived;
            return this;
        }

        public ChargeListBuilder showArchived(Boolean showArchived) {
            this.showArchived = showArchived;
            return this;
        }

        public ChargeListBuilder showDue(Boolean showDue) {
            this.showDue = showDue;
            return this;
        }

        public ChargeListBuilder showNotDue(Boolean showNotDue) {
            this.showNotDue = showNotDue;
            return this;
        }

        public ChargeListBuilder showPaid(Boolean showPaid) {
            this.showPaid = showPaid;
            return this;
        }

        public ChargeListBuilder showNotPaid(Boolean showNotPaid) {
            this.showNotPaid = showNotPaid;
            return this;
        }

        public ChargeListBuilder showCancelled(Boolean showCancelled) {
            this.showCancelled = showCancelled;
            return this;
        }

        public ChargeListBuilder showNotCancelled(Boolean showNotCancelled) {
            this.showNotCancelled = showNotCancelled;
            return this;
        }

        public ChargeListBuilder showManualReconciliation(Boolean showManualReconciliation) {
            this.showManualReconciliation = showManualReconciliation;
            return this;
        }

        public ChargeListBuilder showNotManualReconciliation(Boolean showNotManualReconciliation) {
            this.showNotManualReconciliation = showNotManualReconciliation;
            return this;
        }

        public ChargeListBuilder showNotFailed(Boolean showNotFailed) {
            this.showNotFailed = showNotFailed;
            return this;
        }

        public ChargeListBuilder orderBy(OrderBy orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        public ChargeListBuilder orderAsc(Boolean orderAsc) {
            this.orderAsc = orderAsc;
            return this;
        }

        public ChargeListBuilder pageSize(Integer pageSize) {
            this.pageSize = pageSize != null && pageSize > MIN_RECORDS_PER_REQUEST ? Math.abs(pageSize) : MIN_RECORDS_PER_REQUEST.intValue();
            return this;
        }

        private Double getTotalPages() {
            return pageSize != null ? Double.valueOf(pageSize) / MAX_RECORDS_PER_REQUEST : 1D;
        }

    }

}
