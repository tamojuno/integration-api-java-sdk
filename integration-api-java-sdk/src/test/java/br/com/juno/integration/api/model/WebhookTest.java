package br.com.juno.integration.api.model;

import static br.com.juno.test.FixtureHelper.BASE_URI;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import br.com.juno.integration.api.model.Webhook.WebhookStatusEnum;
import br.com.juno.integration.api.services.response.Response;
import br.com.juno.integration.api.services.response.Responses;
import br.com.juno.test.AbstractTest;

public class WebhookTest extends AbstractTest {

    private static final String URL = "https://webhook.site/00517f0e-c254-418d-90cb-ed482433ae6d";
    private static final String SECRET = "12f26abe5053e7356529c16ab73ff0ed358b28ea6cb87fff857894312deaee2f";
    private static final WebhookStatusEnum STATUS = WebhookStatusEnum.ACTIVE;
    private static final Set<EventType> EVENT_TYPES = new HashSet<>();

    @Test
    public void constructors() {
        Webhook webhook = new Webhook();
        webhook.setUrl(URL);
        webhook.setSecret(SECRET);
        webhook.setStatus(STATUS);
        webhook.setEventTypes(EVENT_TYPES);

        assertEquals(URL, webhook.getUrl());
        assertEquals(SECRET, webhook.getSecret());
        assertEquals(STATUS, webhook.getStatus());
        assertEquals(EVENT_TYPES, webhook.getEventTypes());
    }

    @Test
    public void toStringComplete() {
        Webhook webhook = new Webhook();
        webhook.setUrl(URL);
        webhook.setSecret(SECRET);
        webhook.setStatus(STATUS);
        webhook.setEventTypes(EVENT_TYPES);
        assertEquals(
                "Webhook[<null>,https://webhook.site/00517f0e-c254-418d-90cb-ed482433ae6d,12f26abe5053e7356529c16ab73ff0ed358b28ea6cb87fff857894312deaee2f,ACTIVE,[]]",
                webhook.toString());
    }

    @Test
    public void toStringEmpty() {
        Webhook webhook = new Webhook();
        assertEquals("Webhook[<null>,<null>,<null>,<null>,[]]", webhook.toString());
    }

    @Test
    public void jsonToObject() throws Exception {
        Response<Webhook> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<Webhook>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        Webhook webhook = res.getContent();

        assertEquals(URL, webhook.getUrl());
        assertEquals(SECRET, webhook.getSecret());
        assertEquals(STATUS, webhook.getStatus());
        assertEquals(EVENT_TYPES, webhook.getEventTypes());
    }

    @Test
    public void jsonToCollection() throws Exception {
        Responses<Webhook> res = new Responses<>(getObjectMapper().readValue(findAll(), new TypeReference<Resources<Resource<Webhook>>>() {
            // NTD
        }));

        assertEquals(BASE_URI + "/notifications/webhooks", res.getHrefSelf());
        assertEquals(null, res.getHrefNext());
        assertEquals(null, res.getHrefPrevious());

        List<Response<Webhook>> list = res.getContent();

        assertEquals(URL, list.get(0).getContent().getUrl());
        assertEquals(SECRET, list.get(0).getContent().getSecret());
        assertEquals(STATUS, list.get(0).getContent().getStatus());
        assertEquals(EVENT_TYPES, list.get(0).getContent().getEventTypes());

        assertEquals("https://webhook.site/c2a31b79-25f9-49c9-b372-cad2cacf2456", list.get(1).getContent().getUrl());
        assertEquals("92ef67f7ade41b3603bca3c292a948ab26e28095e429430c51af07c8c7e5a2da", list.get(1).getContent().getSecret());
        assertEquals(STATUS, list.get(1).getContent().getStatus());
        assertEquals(EVENT_TYPES, list.get(1).getContent().getEventTypes());
    }

    private String findOne() {
        return "{\"id\":\"wbh_AACE6E3682C03337\",\"url\":\"https://webhook.site/00517f0e-c254-418d-90cb-ed482433ae6d\",\"secret\":\"12f26abe5053e7356529c16ab73ff0ed358b28ea6cb87fff857894312deaee2f\",\"status\":\"ACTIVE\",\"eventTypes\":[]}";
    }

    private String findAll() {
        return "{\"_embedded\":{\"webhooks\":[{\"id\":\"wbh_AACE6E3682C03337\",\"url\":\"https://webhook.site/00517f0e-c254-418d-90cb-ed482433ae6d\",\"secret\":\"12f26abe5053e7356529c16ab73ff0ed358b28ea6cb87fff857894312deaee2f\",\"status\":\"ACTIVE\",\"eventTypes\":[],\"_links\":{\"self\":{\"href\":\"https://sandbox.boletobancario.com/api-integration/notifications/webhooks/wbh_AACE6E3682C03337\"}}},{\"id\":\"wbh_FC859F4C63999027\",\"url\":\"https://webhook.site/c2a31b79-25f9-49c9-b372-cad2cacf2456\",\"secret\":\"92ef67f7ade41b3603bca3c292a948ab26e28095e429430c51af07c8c7e5a2da\",\"status\":\"ACTIVE\",\"eventTypes\":[],\"_links\":{\"self\":{\"href\":\"https://sandbox.boletobancario.com/api-integration/notifications/webhooks/wbh_FC859F4C63999027\"}}},{\"id\":\"wbh_BFF1B19C78654434\",\"url\":\"https://a9254d052467.ngrok.io\",\"secret\":\"f4d01cfae94753443652b305b4390452bf25ea8eef00ed3f4c3daa8d415715b0\",\"status\":\"ACTIVE\",\"eventTypes\":[],\"_links\":{\"self\":{\"href\":\"https://sandbox.boletobancario.com/api-integration/notifications/webhooks/wbh_BFF1B19C78654434\"}}}]},\"_links\":{\"self\":{\"href\":\"https://sandbox.boletobancario.com/api-integration/notifications/webhooks\"}}}";
    }
}
