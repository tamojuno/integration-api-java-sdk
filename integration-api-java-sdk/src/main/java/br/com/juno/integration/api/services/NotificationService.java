package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_TYPE_HEADER;
import static br.com.juno.integration.api.services.JunoApiManager.X_RESOURCE_TOKEN;

import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;

import br.com.juno.integration.api.model.EventType;
import br.com.juno.integration.api.model.Webhook;
import br.com.juno.integration.api.services.request.notification.webhook.WebhookCreateRequest;
import br.com.juno.integration.api.services.request.notification.webhook.WebhookDeleteRequest;
import br.com.juno.integration.api.services.request.notification.webhook.WebhookFindRequest;
import br.com.juno.integration.api.services.request.notification.webhook.WebhookListRequest;
import br.com.juno.integration.api.services.request.notification.webhook.WebhookUpdateRequest;
import br.com.juno.integration.api.services.response.Response;
import br.com.juno.integration.api.services.response.Responses;
import br.com.juno.integration.api.utils.JacksonUtils;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class NotificationService extends BaseService {

    public List<EventType> listEventTypes() {
        if (eventTypes.isExpired()) {
            HttpResponse<Resources<Resource<EventType>>> response = Unirest.get(
                    JunoApiManager.config().getResourceEndpoint() + "/notifications/event-types") //
                    .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                    .asObject(new GenericType<Resources<Resource<EventType>>>() {
                        //NTD
                    });

            eventTypes.setCache(new Responses<>(response.getBody()).getAbsoluteContent());
        }

        return eventTypes.getCache();
    }

    public List<Webhook> listWebhooks(WebhookListRequest request) {
        HttpResponse<Resources<Resource<Webhook>>> response = Unirest.get(JunoApiManager.config().getResourceEndpoint() + "/notifications/webhooks") //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken()).asObject(new GenericType<Resources<Resource<Webhook>>>() {
                    //NTD
                });

        return new Responses<>(response.getBody()).getAbsoluteContent();
    }

    public Webhook createWebhook(WebhookCreateRequest request) {
        HttpResponse<Resource<Webhook>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + "/notifications/webhooks") //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken()).body(JacksonUtils.toJson(request)).asObject(
                        new GenericType<Resource<Webhook>>() {
                            //NTD
                        });

        return new Response<>(response.getBody()).getContent();
    }

    public Webhook findWebhook(WebhookFindRequest request) {
        HttpResponse<Resource<Webhook>> response = Unirest.get(JunoApiManager.config().getResourceEndpoint() + "/notifications/webhooks/{id}") //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .routeParam("id", request.getId()) //
                .asObject(new GenericType<Resource<Webhook>>() {
                    //NTD
                });

        return new Response<>(response.getBody()).getContent();
    }

    public void deleteWebhook(WebhookDeleteRequest request) {
        Unirest.delete(JunoApiManager.config().getResourceEndpoint() + "/notifications/webhooks/{id}") //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .routeParam("id", request.getId()) //
                .asEmpty(); //
    }

    public Webhook updateWebhook(WebhookUpdateRequest request) {
        HttpResponse<Resource<Webhook>> response = Unirest.patch(JunoApiManager.config().getResourceEndpoint() + "/notifications/webhooks/{id}") //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .routeParam("id", request.getId()) //
                .asObject(new GenericType<Resource<Webhook>>() {
                    //NTD
                });

        return new Response<>(response.getBody()).getContent();
    }

    private CachedResource<EventType> eventTypes = new CachedResource<>();

}
