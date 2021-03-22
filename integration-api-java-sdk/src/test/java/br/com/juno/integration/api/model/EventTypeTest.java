package br.com.juno.integration.api.model;

import static br.com.juno.test.FixtureHelper.BASE_URI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import br.com.juno.integration.api.model.EventType.EventStatus;
import br.com.juno.integration.api.services.response.Response;
import br.com.juno.integration.api.services.response.Responses;
import br.com.juno.test.AbstractTest;

public class EventTypeTest extends AbstractTest {

    private static final String NAME = "DOCUMENT_STATUS_CHANGED";
    private static final String LABEL = "O status de um documento foi alterado";
    private static final EventStatus STATUS = EventStatus.ENABLED;

    @Test
    public void constructors() {
        EventType eventType = new EventType();
        assertNull(eventType.getName());
        assertNull(eventType.getLabel());
        assertNull(eventType.getStatus());

        eventType = new EventType();
        eventType.setName(NAME);
        eventType.setLabel(LABEL);
        eventType.setStatus(STATUS);

        assertEquals(NAME, eventType.getName());
        assertEquals(LABEL, eventType.getLabel());
        assertEquals(STATUS, eventType.getStatus());
    }

    @Test
    public void toStringComplete() {
        EventType eventType = new EventType();
        eventType.setId("evt_DC2E7E8848B08C62");
        eventType.setName(NAME);
        eventType.setLabel(LABEL);
        eventType.setStatus(STATUS);
        assertEquals("EventType[evt_DC2E7E8848B08C62,DOCUMENT_STATUS_CHANGED,O status de um documento foi alterado,ENABLED]", eventType.toString());
    }

    @Test
    public void toStringEmpty() {
        EventType eventType = new EventType();
        assertEquals("EventType[<null>,<null>,<null>,<null>]", eventType.toString());
    }

    @Test
    public void jsonToObject() throws Exception {
        Response<EventType> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<EventType>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        EventType eventType = res.getContent();

        assertEquals(NAME, eventType.getName());
        assertEquals(LABEL, eventType.getLabel());
        assertEquals(STATUS, eventType.getStatus());
    }

    @Test
    public void jsonToCollection() throws Exception {
        Responses<EventType> res = new Responses<>(getObjectMapper().readValue(findAll(), new TypeReference<Resources<Resource<EventType>>>() {
            // NTD
        }));

        assertEquals(BASE_URI + "/notifications/event-types", res.getHrefSelf());
        assertEquals(null, res.getHrefNext());
        assertEquals(null, res.getHrefPrevious());

        List<Response<EventType>> list = res.getContent();

        assertEquals(null, list.get(0).getHrefSelf());
        assertEquals(NAME, list.get(0).getContent().getName());
        assertEquals(LABEL, list.get(0).getContent().getLabel());
        assertEquals(STATUS, list.get(0).getContent().getStatus());

        assertEquals(null, list.get(1).getHrefSelf());
        assertEquals("DIGITAL_ACCOUNT_STATUS_CHANGED", list.get(1).getContent().getName());
        assertEquals("O estado de uma conta digital foi alterado", list.get(1).getContent().getLabel());
        assertEquals(STATUS, list.get(1).getContent().getStatus());
    }

    private String findOne() {
        return "{\"id\":\"evt_DC2E7E8848B08C62\",\"name\":\"DOCUMENT_STATUS_CHANGED\",\"label\":\"O status de um documento foi alterado\",\"status\":\"ENABLED\"}";
    }

    private String findAll() {
        return "{\"_embedded\":{\"eventTypes\":[{\"id\":\"evt_DC2E7E8848B08C62\",\"name\":\"DOCUMENT_STATUS_CHANGED\",\"label\":\"O status de um documento foi alterado\",\"status\":\"ENABLED\"},{\"id\":\"evt_4B3A979C94349E9E\",\"name\":\"DIGITAL_ACCOUNT_STATUS_CHANGED\",\"label\":\"O estado de uma conta digital foi alterado\",\"status\":\"ENABLED\"}]},\"_links\":{\"self\":{\"href\":\"https://sandbox.boletobancario.com/api-integration/notifications/event-types\"}}}";
    }
}
