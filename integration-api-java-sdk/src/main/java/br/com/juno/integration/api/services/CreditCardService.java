package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_TYPE_HEADER;
import static br.com.juno.integration.api.services.JunoApiManager.X_RESOURCE_TOKEN;

import java.util.HashMap;
import java.util.Map;

import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;

import br.com.juno.integration.api.base.exception.Assert;
import br.com.juno.integration.api.model.TokenizedCreditCard;
import br.com.juno.integration.api.services.request.creditcard.CreditCardTokenizationRequest;
import br.com.juno.integration.api.services.response.Response;
import br.com.juno.integration.api.utils.JacksonUtils;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class CreditCardService extends BaseService {

    private static final String CREDIT_CARDS_ENDPOINT = "/credit-cards/tokenization";

    CreditCardService() {
        // NTD
    }

    public TokenizedCreditCard tokenize(CreditCardTokenizationRequest request) {
        Assert.isTrue(JunoApiManager.config().hasPublicTokenConfigured(),
                "To perform this operation your Public Token must be configured, check our integration manual to see how to generate the Public Token");

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("creditCardHash", request.getCreditCardHash());

        HttpResponse<Resource<TokenizedCreditCard>> response = Unirest.post( //
                JunoApiManager.config().getResourceEndpoint() + CREDIT_CARDS_ENDPOINT) //
                .header(X_RESOURCE_TOKEN, JunoApiManager.config().getResourceToken()) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .body(JacksonUtils.toJson(request)) //
                .asObject(new GenericType<Resource<TokenizedCreditCard>>() { //
                    // NTD
                });//

        return new Response<>(response.getBody()).getContent();
    }

}
