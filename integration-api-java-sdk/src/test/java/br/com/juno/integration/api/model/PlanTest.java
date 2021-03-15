package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.juno.test.AbstractTest;

public class PlanTest extends AbstractTest {

    @Test
    public void constructors() {
        // NTD
        assertEquals(findOneComplete(), findCompleteObject());
    }

    @Test
    public void toStringEmpty() {
        // NTD
        assertEquals(findOneNull(), findIncompleteObject());
    }

    @Test
    public void toStringComplete() {
        // NTD
        assertEquals(findOneComplete(), findCompleteObject());
    }

    @Test
    public void equality() {
        // NTD
    }

    public String findOneComplete() {
        // NTD
        return "{\"id\":\"pln_FB19C73B4EF9E2F1\",\"createdOn\":\"2021-03-15 12:30:09\",\"name\":\"Primeiro plano\",\"frequency\":\"MONTHLY\",\"status\":\"ACTIVE\",\"amount\":100.0}";
    }

    public String findOneNull() {
        // NTD
        return "{\"id\":null,\"createdOn\":null,\"name\":null,\"frequency\":null,\"status\":null,\"amount\":null}";
    }

    public String findCompleteObject() {
        // NTD
        Plan plan = new Plan();
        plan.setId("pln_FB19C73B4EF9E2F1");
        plan.setCreatedOn("2021-03-15 12:30:09");
        plan.setName("Primeiro plano");
        plan.setFrequency("MONTHLY");
        plan.setStatus("ACTIVE");
        plan.setAmount(BigDecimal.valueOf(100.00D));
        return plan.toString();
    }

    public String findIncompleteObject() {
        Plan plan = new Plan();
        plan.getId();
        plan.getCreatedOn();
        plan.getName();
        plan.getFrequency();
        plan.getStatus();
        plan.getAmount();
        return plan.toString();
    }
}
