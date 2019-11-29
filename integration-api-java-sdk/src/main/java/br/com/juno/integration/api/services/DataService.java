package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_TYPE_HEADER;

import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;

import br.com.juno.integration.api.model.Bank;
import br.com.juno.integration.api.model.BusinessArea;
import br.com.juno.integration.api.model.CompanyType;
import br.com.juno.integration.api.services.response.Responses;
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
            HttpResponse<Resources<Resource<Bank>>> response = Unirest.get(JunoApiManager.config().getResourceEndpoint() + "/data/banks") //
                    .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                    .asObject(new GenericType<Resources<Resource<Bank>>>() {
                        //NTD
                    });

            banks.setCache(new Responses<>(response.getBody()).getAbsoluteContent());
        }

        return banks.getCache();
    }

    public List<CompanyType> getCompanyTypes() {
        if (companyTypes.isExpired()) {
            HttpResponse<JsonNode> response = Unirest.get(JunoApiManager.config().getResourceEndpoint() + "/data/company-types") //
                    .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                    .asJson();

            companyTypes.getCache().clear();
            response.getBody().getObject().getJSONArray("companyTypes").forEach(str -> companyTypes.getCache().add(new CompanyType((String)str)));
            companyTypes.resetTimestamp();
        }

        return companyTypes.getCache();
    }

    public List<BusinessArea> getBusinessAreas() {
        if (businessAreas.isExpired()) {
            HttpResponse<Resources<Resource<BusinessArea>>> response = Unirest.get(
                    JunoApiManager.config().getResourceEndpoint() + "/data/business-areas") //
                    .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                    .asObject(new GenericType<Resources<Resource<BusinessArea>>>() {
                        //NTD
                    });

            businessAreas.setCache(new Responses<>(response.getBody()).getAbsoluteContent());
        }

        return businessAreas.getCache();
    }

    private CachedResource<Bank> banks = new CachedResource<>();
    private CachedResource<CompanyType> companyTypes = new CachedResource<>();
    private CachedResource<BusinessArea> businessAreas = new CachedResource<>();
}