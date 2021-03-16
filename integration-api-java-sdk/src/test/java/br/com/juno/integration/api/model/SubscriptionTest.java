package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.test.AbstractTest;

public class SubscriptionTest extends AbstractTest {

    @Test
    public void constructors() {
        Subscription subscription = new Subscription();
        assertNull(subscription.getCreatedOn());
        assertNull(subscription.getDueDay());
        assertNull(subscription.getStatus());
        assertNull(subscription.getStartsOn());
        assertNull(subscription.getLastBillingDate());
        assertNull(subscription.getNextBillingDate());

        subscription = new Subscription("2021-03-15 14:57:11", "1", "ACTIVE", "2021-04-01", null, "2021-04-01");

        assertEquals("2021-03-15 14:57:11", subscription.getCreatedOn());
        assertEquals("1", subscription.getDueDay());
        assertEquals("ACTIVE", subscription.getStatus());
        assertEquals("2021-04-01", subscription.getStartsOn());
        assertEquals(null, subscription.getLastBillingDate());
        assertEquals("2021-04-01", subscription.getNextBillingDate());
    }

    @Test
    public void toStringEmpty() {
        Subscription subscription = findEmptyObject();
        assertEquals("Subscription[<null>,<null>,<null>,<null>,<null>,<null>,<null>]", subscription.toString());
    }

    @Test
    public void toStringComplete() {
        Subscription subscription = findCompleteObject();
        assertEquals("Subscription[<null>,2021-03-15 14:57:11,1,ACTIVE,2021-04-01,<null>,2021-04-01]", subscription.toString());
    }

    @Test
    public void equality() {
        Subscription target = new Subscription("2021-03-15 14:57:11", "1", "ACTIVE", "2021-04-01", null, "2021-04-01");
        Subscription equal = new Subscription("2021-03-15 14:57:11", "1", "ACTIVE", "2021-04-01", null, "2021-04-01");
        Subscription diff1 = new Subscription();
        Subscription diff2 = new Subscription("2021-03-15 14:57:11", "1", "ACTIVE", "2021-04-01", null, "2021-04-01");

        assertFalse(equal.equals(target));
        assertFalse(target.equals(null));

        assertNotEquals(null, target);
        assertNotEquals(diff1, target);
        assertNotEquals(diff2, target);
    }

    @Test
    public void jsonToObject() throws Exception {
        Response<Subscription> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<Subscription>>() {
            // NTD
        }));

        assertNull(res.getHrefSelf());

        Subscription subscription = res.getContent();

        assertEquals("2021-03-15 14:57:11", subscription.getCreatedOn());
        assertEquals("1", subscription.getDueDay());
        assertEquals("ACTIVE", subscription.getStatus());
        assertEquals("2021-04-01", subscription.getStartsOn());
        assertEquals(null, subscription.getLastBillingDate());
        assertEquals("2021-04-01", subscription.getNextBillingDate());
    }

    public Subscription findCompleteObject() {
        return new Subscription("2021-03-15 14:57:11", "1", "ACTIVE", "2021-04-01", null, "2021-04-01");
    }

    public Subscription findWrongCompleteObject() {
        return new Subscription("2021-03-15 14:57:11", "1", "DEACTIVE", "2021-04-01", null, "2021-04-01");
    }

    public Subscription findEmptyObject() {
        return new Subscription();
    }

    private String findOne() {
        return "{\"createdOn\":\"2021-03-15 14:57:11\",\"dueDay\":\"1\",\"status\":\"ACTIVE\",\"startsOn\":\"2021-04-01\",\"lastBillingDate\":null,\"nextBillingDate\":\"2021-04-01\"}";
    }
}
