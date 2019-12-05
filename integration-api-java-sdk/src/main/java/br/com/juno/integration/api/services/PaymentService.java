package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_TYPE_HEADER;
import static br.com.juno.integration.api.services.JunoApiManager.X_RESOURCE_TOKEN;

import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;

import br.com.juno.integration.api.model.PaymentRefundTransaction;
import br.com.juno.integration.api.model.PaymentTransaction;
import br.com.juno.integration.api.services.request.payment.PaymentCreateRequest;
import br.com.juno.integration.api.services.request.payment.PaymentRefundRequest;
import br.com.juno.integration.api.services.response.Response;
import br.com.juno.integration.api.utils.JacksonUtils;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class PaymentService extends BaseService {

    private static final String PAYMENTS_ENDPOINT = "/payments";
    private static final String PAYMENT_REFUNDS_ENDPOINT = PAYMENTS_ENDPOINT + "/{id}/refunds";

    public PaymentTransaction createPayment(PaymentCreateRequest request) {
        HttpResponse<Resource<PaymentTransaction>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + PAYMENTS_ENDPOINT) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken()) //
                .body(JacksonUtils.toJson(request))//
                .asObject(new GenericType<Resource<PaymentTransaction>>() {
                    // NTD
                });

        return new Response<>(response.getBody()).getContent();

    }

    public PaymentRefundTransaction refundPayment(PaymentRefundRequest request) {
        HttpResponse<Resource<PaymentRefundTransaction>> response = Unirest.post(
                JunoApiManager.config().getResourceEndpoint() + PAYMENT_REFUNDS_ENDPOINT) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken()) //
                .routeParam("id", request.getId()) //
                .asObject(new GenericType<Resource<PaymentRefundTransaction>>() {
                    // NTD
                });

        return new Response<>(response.getBody()).getContent();
    }
}
