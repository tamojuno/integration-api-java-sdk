package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_TYPE_HEADER;
import static br.com.juno.integration.api.services.JunoApiManager.X_RESOURCE_TOKEN;

import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;

import br.com.juno.integration.api.model.Subscription;
import br.com.juno.integration.api.services.request.subscriptions.SubscriptionCreateRequest;
import br.com.juno.integration.api.services.request.subscriptions.SubscriptionListRequest;
import br.com.juno.integration.api.services.request.subscriptions.SubscriptionRequest;
import br.com.juno.integration.api.services.response.Response;
import br.com.juno.integration.api.services.response.Responses;
import br.com.juno.integration.api.utils.JacksonUtils;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class SubscriptionService extends BaseService {

	public static final String SUBSCRIPTIONS_ENDPOINT = "/subscriptions";
	public static final String SUBSCRIPTIONS_TEMPLATE_ENDPOINT = SUBSCRIPTIONS_ENDPOINT + "/{id}";
	
	SubscriptionService() {
		// NTD
	}
	
	public Subscription createSubscription(SubscriptionCreateRequest request) {
		HttpResponse<Resource<Subscription>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + SUBSCRIPTIONS_ENDPOINT) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken())//
                .body(JacksonUtils.toJson(request)) //
                .asObject(new GenericType<Resource<Subscription>>() { //
                    //NTD
                }); //

        return new Response<>(response.getBody()).getContent();
	}
	
	public List<Subscription> listSubscriptions(SubscriptionListRequest request) {
		HttpResponse<Resources<Resource<Subscription>>> response = Unirest.get(JunoApiManager.config().getResourceEndpoint() + SUBSCRIPTIONS_ENDPOINT) //
        		.header(JunoApiManager.X_RESOURCE_TOKEN, request.getResourceToken()) //
        		.header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
        		.asObject(new GenericType<Resources<Resource<Subscription>>>() {
                    // NTD
                });

		return new Responses<>(response.getBody()).getAbsoluteContent();
	}
	
	public Subscription findSubscription(SubscriptionRequest request) {
		HttpResponse<Resource<Subscription>> response = Unirest.get(JunoApiManager.config().getResourceEndpoint() + SUBSCRIPTIONS_TEMPLATE_ENDPOINT) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken())//
                .routeParam("id", request.getId()) //
                .asObject(new GenericType<Resource<Subscription>>() {
                    //NTD
                });

        return new Response<>(response.getBody()).getContent();

	}
	
	public Subscription deactiveSubscription(SubscriptionRequest request) {
		HttpResponse<Resource<Subscription>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + SUBSCRIPTIONS_TEMPLATE_ENDPOINT + "/deactivation") //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken())//
                .routeParam("id", request.getId()) //
                .asObject(new GenericType<Resource<Subscription>>() {
                    //NTD
                });
        
        return new Response<>(response.getBody()).getContent();
    }
	
	public Subscription activeSubscription(SubscriptionRequest request) {
		HttpResponse<Resource<Subscription>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + SUBSCRIPTIONS_TEMPLATE_ENDPOINT + "/activation") //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken())//
                .routeParam("id", request.getId()) //
                .asObject(new GenericType<Resource<Subscription>>() {
                    //NTD
                });
        
        return new Response<>(response.getBody()).getContent();
    }
	
	public Subscription cancelSubscription(SubscriptionRequest request) {
		HttpResponse<Resource<Subscription>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + SUBSCRIPTIONS_TEMPLATE_ENDPOINT + "/cancelation") //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken())//
                .routeParam("id", request.getId()) //
                .asObject(new GenericType<Resource<Subscription>>() {
                    //NTD
                });
        
        return new Response<>(response.getBody()).getContent();
    }

	public Subscription completeSubscription(SubscriptionRequest request) {
		HttpResponse<Resource<Subscription>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + SUBSCRIPTIONS_TEMPLATE_ENDPOINT + "/completion") //
				.header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
				.header(X_RESOURCE_TOKEN, request.getResourceToken())//
				.routeParam("id", request.getId()) //
				.asObject(new GenericType<Resource<Subscription>>() {
					//NTD
				});
		
		return new Response<>(response.getBody()).getContent();
	}
	
}
