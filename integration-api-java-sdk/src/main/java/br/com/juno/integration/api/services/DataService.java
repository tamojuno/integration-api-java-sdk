package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.utils.ResponseUtils.validateSuccess;

import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import br.com.juno.integration.api.model.Bank;
import br.com.juno.integration.api.model.BusinessArea;
import br.com.juno.integration.api.model.CompanyType;
import br.com.juno.integration.api.model.response.Responses;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public final class DataService extends BaseService {

    DataService() {
        // NTD
    }

    public List<Bank> getBanks() {
        if (banks.isExpired()) {
            HttpResponse<Resources<Resource<Bank>>> httpResponse = Unirest.get(
                    JunoApiManager.config().getEnvironmentUrl() + "/api-integration/data/banks") //
                    .headers(JunoApiManager.resources().authorization().getAuthorizationHeader()) //
                    .asObject(new GenericType<Resources<Resource<Bank>>>() {
                        //NTD
                    });

            validateSuccess(httpResponse);

            banks.setCache(new Responses<>(httpResponse.getBody()).getAbsoluteContent());
        }

        return banks.getCache();
    }

    public List<CompanyType> getCompanyTypes() {
        if (companyTypes.isExpired()) {
            HttpResponse<JsonNode> httpResponse = Unirest.get(JunoApiManager.config().getEnvironmentUrl() + "/api-integration/data/company-types") //
                    .headers(JunoApiManager.resources().authorization().getAuthorizationHeader()) //
                    .asJson();

            validateSuccess(httpResponse);

            companyTypes.getCache().clear();
            httpResponse.getBody().getObject().getJSONArray("companyTypes").forEach(str -> companyTypes.getCache().add(new CompanyType((String)str)));
            companyTypes.resetTimestamp();
        }

        return companyTypes.getCache();
    }

    public List<BusinessArea> getBusinessAreas() {
        if (businessAreas.isExpired()) {
            HttpResponse<Resources<Resource<BusinessArea>>> httpResponse = Unirest.get(
                    JunoApiManager.config().getEnvironmentUrl() + "/api-integration/data/business-areas") //
                    .headers(JunoApiManager.resources().authorization().getAuthorizationHeader()) //
                    .asObject(new GenericType<Resources<Resource<BusinessArea>>>() {
                        //NTD
                    });

            validateSuccess(httpResponse);

            businessAreas.setCache(new Responses<>(httpResponse.getBody()).getAbsoluteContent());
        }

        return businessAreas.getCache();
    }

    private CachedResource<Bank> banks = new CachedResource<>();
    private CachedResource<CompanyType> companyTypes = new CachedResource<>();
    private CachedResource<BusinessArea> businessAreas = new CachedResource<>();
}