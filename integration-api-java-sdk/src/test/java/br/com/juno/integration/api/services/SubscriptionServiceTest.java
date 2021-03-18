package br.com.juno.integration.api.services;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.juno.integration.api.model.Subscription;
import br.com.juno.integration.api.services.request.subscriptions.SubscriptionCreateRequest;
import br.com.juno.integration.api.services.request.subscriptions.SubscriptionCreateRequest.Billing;
import br.com.juno.integration.api.services.request.subscriptions.SubscriptionCreateRequest.Billing.Address;
import br.com.juno.integration.api.services.request.subscriptions.SubscriptionCreateRequest.CreditCardDetails;
import br.com.juno.integration.api.services.request.subscriptions.SubscriptionListRequest;
import br.com.juno.integration.api.services.request.subscriptions.SubscriptionRequest;
import br.com.juno.test.AbstractTest;

public class SubscriptionServiceTest extends AbstractTest {

    @Test
    public void testCreateSubscription() {
        SubscriptionCreateRequest.Billing billing = new Billing();
        billing.setName(HOLDER_NAME);
        billing.setDocument(HOLDER_DOCUMENT);
        billing.setEmail(PAYER_EMAIL);
        SubscriptionCreateRequest.Billing.Address address = new Address();
        address.setStreet("R. Mariano Torres");
        address.setNumber("729");
        address.setCity("Curitiba");
        address.setState("PR");
        address.setPostCode("80060120");
        billing.setAddress(address);

        CreditCardDetails creditCardDetails = new SubscriptionCreateRequest.CreditCardDetails("623b7652-4fb4-4ee9-984b-e5a18f2806c0");

        SubscriptionCreateRequest subscriptionRequest = new SubscriptionCreateRequest(21, "pln_B4E77D3D731AFDB4", "PlanCreated for Plan Premium",
                creditCardDetails, billing, null);
        Subscription subscription = JunoApiManager.getSubscriptionService().createSubscription(subscriptionRequest);
        System.out.println(subscription);
    }

    @Test
    public void testListSubscriptions() {
        List<Subscription> subscriptions = JunoApiManager.getSubscriptionService().listSubscriptions(new SubscriptionListRequest());
        subscriptions.forEach(System.out::println);
    }

    @Test
    public void testFindSubscription() {
        SubscriptionRequest listById = new SubscriptionRequest("sub_282CF614F0E3B04B");
        Subscription foundSubscription = JunoApiManager.getSubscriptionService().findSubscription(listById);
        System.out.println(foundSubscription);
    }

    @Test
    public void testDeactiveSubscription() {
        SubscriptionRequest deactiveById = new SubscriptionRequest("sub_9C8F069813B15F08");
        Subscription deactivedSubscription = JunoApiManager.getSubscriptionService().deactiveSubscription(deactiveById);
        System.out.println(deactivedSubscription);
    }

    @Test
    public void testActiveSubscription() {
        SubscriptionRequest activeById = new SubscriptionRequest("sub_9C8F069813B15F08");
        Subscription activedSubscription = JunoApiManager.getSubscriptionService().activeSubscription(activeById);
        System.out.println(activedSubscription);
    }

    @Test
    public void testCancelSubscription() {
        SubscriptionRequest cancelById = new SubscriptionRequest("sub_C52AEECDF63BB342");
        Subscription canceledSubscription = JunoApiManager.getSubscriptionService().cancelSubscription(cancelById);
        System.out.println(canceledSubscription);
    }

    @Test
    public void testCompleteSubscription() {
        SubscriptionRequest completeById = new SubscriptionRequest("sub_514C4262E3CCF39C");
        Subscription completedSubscription = JunoApiManager.getSubscriptionService().completeSubscription(completeById);
        System.out.println(completedSubscription);
    }

}
