package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_TYPE_HEADER;
import static br.com.juno.integration.api.services.JunoApiManager.X_RESOURCE_TOKEN;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;

import br.com.juno.integration.api.base.exception.JunoApiException;
import br.com.juno.integration.api.model.Charge;
import br.com.juno.integration.api.model.LabeledEnum;
import br.com.juno.integration.api.services.request.charge.ChargeCreateRequest;
import br.com.juno.integration.api.services.request.charge.ChargeListRequest;
import br.com.juno.integration.api.services.response.Responses;
import br.com.juno.integration.api.utils.JacksonUtils;
import kong.unirest.GenericType;
import kong.unirest.GetRequest;
import kong.unirest.HttpRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public final class ChargeService extends BaseService {

    private static final String CHARGES_ENDPOINT = "/charges";

    ChargeService() {
        // NTD
    }

    public List<Charge> create(ChargeCreateRequest request) {
        HttpResponse<Resources<Resource<br.com.juno.integration.api.model.Charge>>> response = Unirest.post( //
                JunoApiManager.config().getResourceEndpoint() + CHARGES_ENDPOINT) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken()) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .body(JacksonUtils.toJson(request)) //
                .asObject(new GenericType<Resources<Resource<br.com.juno.integration.api.model.Charge>>>() { //
                    // NTD
                });//

        return new Responses<>(response.getBody()).getAbsoluteContent();
    }

    public Responses<Charge> list(ChargeListRequest request) {
        GetRequest httpRequest = Unirest.get(JunoApiManager.config().getResourceEndpoint() + CHARGES_ENDPOINT) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken()) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE); //

        populateParameters(httpRequest, request);

        return exchange(httpRequest);
    }

    public Responses<Charge> listNextPage(Responses<Charge> currentPage) {
        Responses<Charge> responses = null;

        if (StringUtils.isNotBlank(currentPage.getHrefNext())) {
            responses = getPage(currentPage.getResourceToken(), currentPage.getHrefNext());
        }

        return responses != null ? responses : new Responses<>(new LinkedList<>(), currentPage.getResourceToken());
    }

    private Responses<Charge> getPage(String resourceToken, String hateoasLink) {
        GetRequest httpRequest = Unirest.get(hateoasLink) //
                .header(X_RESOURCE_TOKEN, resourceToken)//
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE); //

        return exchange(httpRequest);
    }

    private Responses<Charge> exchange(GetRequest httpRequest) {
        HttpResponse<Resources<Resource<Charge>>> response = httpRequest.asObject(new GenericType<Resources<Resource<Charge>>>() {
            // NTD
        });

        return new Responses<>(response.getBody(), httpRequest.getHeaders().getFirst(X_RESOURCE_TOKEN));
    }

    private void populateParameters(HttpRequest<GetRequest> httpRequest, ChargeListRequest request) {
        try {
            Field[] fields = request.getClass().getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                if (isNonStaticFinal(field) && field.get(request) != null) {
                    if (field.getType().isEnum()) {
                        httpRequest.queryString(field.getName(), ((LabeledEnum)field.get(request)).getLabel());
                    } else {
                        httpRequest.queryString(field.getName(), field.get(request));
                    }
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            throw new JunoApiException(e);
        }
    }

    private boolean isNonStaticFinal(Field field) {
        return !Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers());
    }

}
