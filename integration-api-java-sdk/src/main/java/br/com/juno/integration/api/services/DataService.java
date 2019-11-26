package br.com.juno.integration.api.services;

import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import br.com.juno.integration.api.model.Bank;
import br.com.juno.integration.api.utils.Clock;
import br.com.juno.integration.api.utils.ResponseUtils;
import br.com.juno.integration.api.utils.Responses;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public final class DataService {

    DataService() {
        // NTD
    }

    public List<Bank> getBanks() {
        if (timestampBanks == null || Clock.getTimeInMillis() - timestampBanks > ApiConfig.VALIDITY_DATA_RESOURCE || banks == null) {
            refresh(ApiManager.getInstance().getApiConfig(), ApiManager.getInstance().getAuthorizationService());
        }

        return banks;
    }

    private void refresh(ApiConfig apiConfig, AuthorizationService authService) {
        HttpResponse<JsonNode> httpResponse = Unirest.get(apiConfig.getEnv().getUrl() + "/api-integration/data/banks") //
                .header("Authorization", "Bearer " + authService.getToken()) //
                .asJson();

        if (httpResponse.getStatus() / 100 != 2) {
            throw new RuntimeException(httpResponse.getStatusText());
        }

        Responses<Bank> responses = null;

        try {
            responses = new Responses<>(ResponseUtils.getObjectMapper().readValue(httpResponse.getBody().toString(), new TypeReference<Resources<Resource<Bank>>>() {}));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        banks = responses.getAbsoluteContent();
    }

    private Long timestampBanks;
    private List<Bank> banks;
}