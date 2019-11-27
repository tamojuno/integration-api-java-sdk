package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.X_RESOURCE_TOKEN;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import br.com.juno.integration.api.base.exception.JunoApiException;
import br.com.juno.integration.api.model.Charge;
import br.com.juno.integration.api.model.LabeledEnum;
import br.com.juno.integration.api.utils.Responses;
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

    public ChargeListBuilder list() {
        return new ChargeListBuilder();
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
        private Integer page;
        private String firstObjectId;
        private String firstValue;
        private String lastObjectId;
        private String lastValue;

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
            System.out.println(hateoasLink);

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

        private ChargeListBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        private ChargeListBuilder firstObjectId(String firstObjectId) {
            this.firstObjectId = firstObjectId;
            return this;
        }

        private ChargeListBuilder firstValue(String firstValue) {
            this.firstValue = firstValue;
            return this;
        }

        private ChargeListBuilder lastObjectId(String lastObjectId) {
            this.lastObjectId = lastObjectId;
            return this;
        }

        private ChargeListBuilder lastValue(String lastValue) {
            this.lastValue = lastValue;
            return this;
        }

        private Double getTotalPages() {
            return pageSize != null ? Double.valueOf(pageSize) / MAX_RECORDS_PER_REQUEST : 1D;
        }

    }

}
