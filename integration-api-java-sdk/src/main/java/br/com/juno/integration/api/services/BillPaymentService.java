package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_TYPE_HEADER;

import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;

import br.com.juno.integration.api.model.BillPayment;
import br.com.juno.integration.api.services.request.billpayment.RegisterBillPaymentRequest;
import br.com.juno.integration.api.services.response.Response;
import br.com.juno.integration.api.utils.JacksonUtils;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public final class BillPaymentService extends BaseService {

    public static final String BILL_PAYMENT_ENDPOINT = "/bill-payments";

    BillPaymentService() {
        // NTD
    }

    public BillPayment registerBillPayment(RegisterBillPaymentRequest request) {
        HttpResponse<Resource<BillPayment>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + BILL_PAYMENT_ENDPOINT) //
                .header(JunoApiManager.X_RESOURCE_TOKEN, request.getResourceToken()) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .body(JacksonUtils.toJson(request)) //
                .asObject(new GenericType<Resource<BillPayment>>() {
                    // NTD
                });

        return new Response<>(response.getBody()).getContent();
    }

}
