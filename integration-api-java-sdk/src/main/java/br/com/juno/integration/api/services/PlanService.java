package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_TYPE_HEADER;
import static br.com.juno.integration.api.services.JunoApiManager.X_RESOURCE_TOKEN;

import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;

import br.com.juno.integration.api.model.Plan;
import br.com.juno.integration.api.services.request.plans.PlanCreateRequest;
import br.com.juno.integration.api.services.request.plans.PlanListRequest;
import br.com.juno.integration.api.services.request.plans.PlanRequest;
import br.com.juno.integration.api.services.response.Response;
import br.com.juno.integration.api.services.response.Responses;
import br.com.juno.integration.api.utils.JacksonUtils;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class PlanService extends BaseService {
	
	private static final String PLANS_ENDPOINT = "/plans";
	private static final String PLANS_TEMPLATED_ENDPOINT = PLANS_ENDPOINT + "/{id}"; 

	PlanService() {
		// NTD
	}
	
	public Plan createPlan(PlanCreateRequest request) {
		HttpResponse<Resource<Plan>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + PLANS_ENDPOINT) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken())//
                .body(JacksonUtils.toJson(request)) //
                .asObject(new GenericType<Resource<Plan>>() { //
                    //NTD
                }); //

        return new Response<>(response.getBody()).getContent();
		
	}
	
	public List<Plan> listPlans(PlanListRequest request) {
		HttpResponse<Resources<Resource<Plan>>> response = Unirest.get(JunoApiManager.config().getResourceEndpoint() + PLANS_ENDPOINT) //
        		.header(JunoApiManager.X_RESOURCE_TOKEN, request.getResourceToken()) //
        		.header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
        		.asObject(new GenericType<Resources<Resource<Plan>>>() {
                    // NTD
                });
		
		return new Responses<>(response.getBody()).getAbsoluteContent();

	}
	
	public Plan findPlan(PlanRequest request) {
		HttpResponse<Resource<Plan>> response = Unirest.get(JunoApiManager.config().getResourceEndpoint() + PLANS_TEMPLATED_ENDPOINT) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken())//
                .routeParam("id", request.getId()) //
                .asObject(new GenericType<Resource<Plan>>() {
                    //NTD
                });

        return new Response<>(response.getBody()).getContent();

	}
	
	public Plan deactivePlan(PlanRequest request) {
		HttpResponse<Resource<Plan>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + PLANS_TEMPLATED_ENDPOINT + "/deactivation") //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken())//
                .routeParam("id", request.getId()) //
                .asObject(new GenericType<Resource<Plan>>() {
                    //NTD
                });
        
        return new Response<>(response.getBody()).getContent();
    }
	
	public Plan activePlan(PlanRequest request) {
		HttpResponse<Resource<Plan>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + PLANS_TEMPLATED_ENDPOINT + "/activation") //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken())//
                .routeParam("id", request.getId()) //
                .asObject(new GenericType<Resource<Plan>>() {
                    //NTD
                });
        
        return new Response<>(response.getBody()).getContent();
    }
}
