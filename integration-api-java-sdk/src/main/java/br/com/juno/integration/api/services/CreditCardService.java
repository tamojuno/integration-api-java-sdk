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
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

public class CreditCardService extends BaseService {

    CreditCardService() {
        // NTD
    }

    public TokenizedCreditCard tokenize(CreditCardTokenizationRequest request) {
        Assert.isTrue(JunoApiManager.config().hasPublicTokenConfigured(),
                "To perform this operation your Public Token must be configured, check our integration manual to see how to generate the Public Token");

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("creditCardHash", request.getCreditCardHash());
        JSONObject jsonObject = new JSONObject(requestBody);

        HttpResponse<Resource<TokenizedCreditCard>> response = Unirest.post( //
                JunoApiManager.config().getResourceEndpoint() + "/credit-cards/tokenization") //
                .header(X_RESOURCE_TOKEN, JunoApiManager.config().getResourceToken()) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .body(jsonObject.toString()) //
                .asObject(new GenericType<Resource<TokenizedCreditCard>>() { //
                    // NTD
                });//

        return new Response<>(response.getBody()).getContent();
    }

}
