package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_TYPE_HEADER;

import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;

import br.com.juno.integration.api.model.DigitalAccount;
import br.com.juno.integration.api.services.request.digitalaccounts.DigitalAccountCreateRequest;
import br.com.juno.integration.api.services.request.digitalaccounts.DigitalAccountRequest;
import br.com.juno.integration.api.services.request.digitalaccounts.DigitalAccountUpdateRequest;
import br.com.juno.integration.api.services.response.Response;
import br.com.juno.integration.api.utils.JacksonUtils;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class DigitalAccountService extends BaseService {

    public static final String DIGITALACCOUNTS_ENDPOINT = "/digital-accounts";

    DigitalAccountService() {
        // NTD
    }

    public DigitalAccount findDigitalAccount(DigitalAccountRequest request) {
        HttpResponse<Resource<DigitalAccount>> response = Unirest.get(JunoApiManager.config().getResourceEndpoint() + DIGITALACCOUNTS_ENDPOINT) //
                .header(JunoApiManager.X_RESOURCE_TOKEN, request.getResourceToken()) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .asObject(new GenericType<Resource<DigitalAccount>>() {
                    // NTD
                });

        return new Response<>(response.getBody()).getContent();
    }

    public DigitalAccount createDigitalAccount(DigitalAccountCreateRequest request) {

        HttpResponse<Resource<DigitalAccount>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + DIGITALACCOUNTS_ENDPOINT) //
                .header(JunoApiManager.X_RESOURCE_TOKEN, request.getResourceToken()) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .body(JacksonUtils.toJson(request)).asObject(new GenericType<Resource<DigitalAccount>>() {
                    // NTD
                });

        return new Response<>(response.getBody()).getContent();

    }

    public DigitalAccount updateDigitalAccount(DigitalAccountUpdateRequest request) {
        HttpResponse<Resource<DigitalAccount>> response = Unirest.patch(JunoApiManager.config().getResourceEndpoint() + DIGITALACCOUNTS_ENDPOINT) //
                .header(JunoApiManager.X_RESOURCE_TOKEN, request.getResourceToken()) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .body(JacksonUtils.toJson(request)).asObject(new GenericType<Resource<DigitalAccount>>() {
                    // NTD
                });

        return new Response<>(response.getBody()).getContent();
    }
}
