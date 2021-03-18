package br.com.juno.integration.api.services;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.model.Plan;
import br.com.juno.integration.api.services.request.plans.PlanCreateRequest;
import br.com.juno.integration.api.services.request.plans.PlanListRequest;
import br.com.juno.integration.api.services.request.plans.PlanRequest;
import br.com.juno.test.AbstractTest;

public class PlanServiceTest extends AbstractTest {

    @Test
    public void testCreatePlan() {
        PlanCreateRequest plan = new PlanCreateRequest("Premium", BigDecimal.valueOf(500.0D));
        System.out.println(plan);
    }

    @Test
    public void testListPlans() {
        List<Plan> plans = JunoApiManager.getPlanService().listPlans(new PlanListRequest());
        plans.forEach(System.out::println);
    }

    @Test
    public void testFindPlan() {
        PlanRequest listById = new PlanRequest("pln_FB19C73B4EF9E2F1");
        Plan foundPlan = JunoApiManager.getPlanService().findPlan(listById);
        System.out.println(foundPlan);
    }

    @Test
    public void testActivePlan() {
        PlanRequest activePlanById = new PlanRequest("pln_FB19C73B4EF9E2F1");
        Plan activePlan = JunoApiManager.getPlanService().activePlan(activePlanById);
        System.out.println(activePlan);
    }

    @Test
    public void testDeactivePlan() {
        PlanRequest deactiveById = new PlanRequest("pln_FB19C73B4EF9E2F1");
        Plan deactivedPlan = JunoApiManager.getPlanService().deactivePlan(deactiveById);
        System.out.println(deactivedPlan);
    }

}
