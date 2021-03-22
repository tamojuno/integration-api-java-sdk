package br.com.juno.integration.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.model.Plan;
import br.com.juno.integration.api.services.request.plans.PlanCreateRequest;
import br.com.juno.integration.api.services.request.plans.PlanRequest;
import br.com.juno.test.AbstractServiceTest;

@Disabled
public class PlanServiceTest extends AbstractServiceTest {

    @Test
    public void createPlan() {
        PlanCreateRequest request = new PlanCreateRequest("Premium", BigDecimal.valueOf(100.00));

        mockServer().expectCreatePlan(request);

        Plan createPlan = JunoApiManager.getPlanService().createPlan(request);
        assertEquals("2021-03-19 14:42:13", createPlan.getCreatedOn());
        assertEquals("Premium", createPlan.getName());
        assertEquals("MONTHLY", createPlan.getFrequency());
        assertEquals("ACTIVE", createPlan.getStatus());
        assertEquals(BigDecimal.valueOf(100.00).setScale(2), createPlan.getAmount());
    }

    @Test
    public void findPlan() {
        PlanRequest listById = new PlanRequest("pln_FB19C73B4EF9E2F1");
        Plan foundPlan = JunoApiManager.getPlanService().findPlan(listById);
        System.out.println(foundPlan);
    }

    @Test
    public void activePlan() {
        PlanRequest activePlanById = new PlanRequest("pln_FB19C73B4EF9E2F1");
        Plan activePlan = JunoApiManager.getPlanService().activePlan(activePlanById);
        System.out.println(activePlan);
    }

    @Test
    public void deactivePlan() {
        PlanRequest deactiveById = new PlanRequest("pln_FB19C73B4EF9E2F1");
        Plan deactivedPlan = JunoApiManager.getPlanService().deactivePlan(deactiveById);
        System.out.println(deactivedPlan);
    }

}
