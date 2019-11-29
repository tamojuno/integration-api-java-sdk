package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_TYPE_HEADER;
import static br.com.juno.integration.api.services.JunoApiManager.X_RESOURCE_TOKEN;
import static br.com.juno.integration.api.utils.ResponseUtils.validateSuccess;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;

import br.com.juno.integration.api.base.exception.Assert;
import br.com.juno.integration.api.model.TokenizedCreditCard;
import br.com.juno.integration.api.services.request.BaseRequest;
import br.com.juno.integration.api.services.request.credentials.CredentialsRequest;
import br.com.juno.integration.api.services.request.creditcard.CreditCardTokenizationRequest;
import br.com.juno.integration.api.services.response.Response;
import br.com.juno.integration.api.utils.CryptoUtils;
import br.com.juno.integration.api.utils.JacksonUtils;
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
        String creditCardHash = request.getCreditCardHash();

        if (request.hasCreditCard() && !request.hasCreditCardHash()) {
            PublicKey publicKey = JunoApiManager.getCredentialsService().getPublicCredentials(new CredentialsRequest()).getPublicKey();

            byte[] creditCardData = JacksonUtils.toJsonBytes(request.getCreditCard());
            String encryptCreditCard = CryptoUtils.encryptCreditCard(publicKey, creditCardData);
            creditCardHash = generateCreditCardHash(encryptCreditCard);
        }

        Assert.isTrue(StringUtils.isNotBlank(creditCardHash), "Unable to recover creditCardHash");
        return tokenize(creditCardHash);
    }

    private String generateCreditCardHash(String encryptedCreditCard) {
        CreditCardGenerateHashRequest request = new CreditCardGenerateHashRequest(JunoApiManager.config().getPublicToken(), encryptedCreditCard);

        HttpResponse<String> response = Unirest.post( //
                JunoApiManager.config().getResourceEndpoint() + "/credit-cards/generate-card-hash") //
                .headers(JunoApiManager.getAuthorizationService().getAuthorizationHeader()) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .body(JacksonUtils.toJson(request)) //
                .asString();

        validateSuccess(response);

        return response.getBody();
    }

    private TokenizedCreditCard tokenize(String creditCardHash) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("creditCardHash", creditCardHash);
        JSONObject jsonObject = new JSONObject(requestBody);

        HttpResponse<Resource<TokenizedCreditCard>> response = Unirest.post( //
                JunoApiManager.config().getResourceEndpoint() + "/credit-cards/tokenization") //
                .headers(JunoApiManager.getAuthorizationService().getAuthorizationHeader()) //
                .header(X_RESOURCE_TOKEN, JunoApiManager.config().getResourceToken()) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .body(jsonObject.toString()) //
                .asObject(new GenericType<Resource<TokenizedCreditCard>>() { //
                    // NTD
                });//

        validateSuccess(response);

        return new Response<>(response.getBody()).getContent();
    }

    static class CreditCardGenerateHashRequest extends BaseRequest {

        private static final long serialVersionUID = -6327428778899405325L;

        private final String publicToken;
        private final String encryptedData;

        CreditCardGenerateHashRequest(String publicToken, String encryptedData) {
            this.publicToken = publicToken;
            this.encryptedData = encryptedData;
        }

        public String getPublicToken() {
            return publicToken;
        }

        public String getEncryptedData() {
            return encryptedData;
        }

    }

}
