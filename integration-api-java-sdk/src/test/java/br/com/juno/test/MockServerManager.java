package br.com.juno.test;

import static br.com.juno.integration.api.services.AuthorizationService.AUTHORIZATION_HEADER;
import static br.com.juno.integration.api.services.JunoApiManager.X_API_VERSION;
import static br.com.juno.integration.api.services.JunoApiManager.X_RESOURCE_TOKEN;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.mockserver.client.MockServerClient;
import org.mockserver.model.Header;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.MediaType;
import org.mockserver.model.Parameter;
import org.mockserver.model.ParameterBody;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.utils.JacksonUtils;
import kong.unirest.HttpMethod;

public final class MockServerManager {

    public MockServerManager(MockServerClient client) {
        this.mockServer = client;
        configureDefaultExpectations();
    }

    private void configureDefaultExpectations() {
        expectAccessToken();
    }

    private void expectAccessToken() {
        mockServer.when( //
                request() //
                        .withMethod(HttpMethod.POST.name()) //
                        .withPath("/oauth/token") //
                        .withBody(ParameterBody.params(new Parameter("grant_type", "client_credentials"))) //
                        .withContentType(MediaType.APPLICATION_FORM_URLENCODED) //
                        .withHeader(new Header(AUTHORIZATION_HEADER, FixtureHelper.BASIC_AUTHENTICATION)) //
        ) //
                .respond( //
                        response(getResource("oauth", "token", "POST.mock")) //
                                .withContentType(MediaType.APPLICATION_JSON) //
                                .withStatusCode(200)); //
    }

    public void expectCreateCharge(Object object) {
        mockServer.when( //
                getRequestExpectation() //
                        .withMethod(HttpMethod.POST.name()) //
                        .withPath("/charges") //
                        .withBody(toJson(object))) //
                .respond( //
                        response(getResource("charges", "POST.mock")) //
                                .withContentType(MediaType.APPLICATION_JSON) //
                                .withStatusCode(200)); //
    }

    public void expectCreditCardTokenization(Object object) {
        mockServer.when( //
                getRequestExpectation() //
                        .withMethod(HttpMethod.POST.name()) //
                        .withPath("/credit-cards/tokenization") //
                        .withBody(toJson(object))) //
                .respond( //
                        response(getResource("credit-cards", "tokenization", "POST.mock")) //
                                .withContentType(MediaType.APPLICATION_JSON) //
                                .withStatusCode(200)); //
    }

    // BALANCE
    public void expectBalance() {
        mockServer.when( //
                getRequestExpectation() //
                        .withMethod(HttpMethod.GET.name()) //
                        .withPath("/balance")) //
                .respond( //
                        response(getResource("balance", "GET.mock")) //
                                .withContentType(MediaType.APPLICATION_JSON) //
                                .withStatusCode(200)); //
    }

    // DIGITAL-ACCOUNTS
    public void expectCreateDigitalAccount(Object object) {
        mockServer.when( //
                getRequestExpectation() //
                        .withMethod(HttpMethod.POST.name()) //
                        .withPath("/digital-accounts") //
                        .withBody(toJson(object))) //
                .respond( //
                        response(getResource("digital-accounts", "POST.mock")) //
                                .withContentType(MediaType.APPLICATION_JSON) //
                                .withStatusCode(200)); //
    }

    public void expectFindDigitalAccount() {
        mockServer.when( //
                getRequestExpectation() //
                        .withMethod(HttpMethod.GET.name()) //
                        .withPath("/digital-accounts")) //
                .respond( //
                        response(getResource("digital-accounts", "GET.mock")) //
                                .withContentType(MediaType.APPLICATION_JSON) //
                                .withStatusCode(200)); //
    }

    public void expectUpdateDigitalAccount(Object object) {
        mockServer.when( //
                getRequestExpectation() //
                        .withMethod(HttpMethod.PATCH.name()) //
                        .withPath("/digital-accounts") //
                        .withBody(toJson(object))) //
                .respond( //
                        response(getResource("digital-accounts", "PATCH.mock")) //
                                .withContentType(MediaType.APPLICATION_JSON) //
                                .withStatusCode(200)); //
    }

    // PLAN
    public void expectCreatePlan(Object object) {
        mockServer.when( //
                getRequestExpectation() //
                        .withMethod(HttpMethod.POST.name()) //
                        .withPath("/plans") //
                        .withBody(toJson(object))) //
                .respond( //
                        response(getResource("plans", "POST.mock")) //
                                .withContentType(MediaType.APPLICATION_JSON) //
                                .withStatusCode(200)); //
    }

    public void expectListPlans() {
        mockServer.when( //
                getRequestExpectation() //
                        .withMethod(HttpMethod.GET.name()) //
                        .withPath("/plans")) //
                .respond( //
                        response(getResource("plans", "GET.mock")) //
                                .withContentType(MediaType.APPLICATION_JSON) //
                                .withStatusCode(200)); //
    }

    public void expectFindPlan(Object object) {
        mockServer.when( //
                getRequestExpectation() //
                        .withMethod(HttpMethod.GET.name()) //
                        .withPath("/plans") //
                        .withBody(toJson(object))) //
                .respond( //
                        response(getResource("plans", "id", "POST.mock")) //
                                .withContentType(MediaType.APPLICATION_JSON) //
                                .withStatusCode(200)); //
    }

    public void expectActivePlan(Object object) {
        mockServer.when( //
                getRequestExpectation() //
                        .withMethod(HttpMethod.POST.name()) //
                        .withPath("/plans") //
                        .withBody(toJson(object))) //
                .respond( //
                        response(getResource("plans", "id", "activation", "POST.mock")) //
                                .withContentType(MediaType.APPLICATION_JSON) //
                                .withStatusCode(200)); //
    }

    public void expectDeactivePlan(Object object) {
        mockServer.when( //
                getRequestExpectation() //
                        .withMethod(HttpMethod.POST.name()) //
                        .withPath("/plans") //
                        .withBody(toJson(object))) //
                .respond( //
                        response(getResource("plans", "id", "activation", "POST.mock")) //
                                .withContentType(MediaType.APPLICATION_JSON) //
                                .withStatusCode(200)); //
    }

    private HttpRequest getRequestExpectationWithoutResourceToken() {
        return request() //
                .withContentType(MediaType.APPLICATION_JSON) //
                .withHeader(new Header(X_API_VERSION, "2")) //
                .withHeader(new Header(AUTHORIZATION_HEADER, FixtureHelper.DUMMY_BEARER_AUTHORIZATION)); //
    }

    private HttpRequest getRequestExpectation() {
        return getRequestExpectationWithoutResourceToken() //
                .withHeader(new Header(X_RESOURCE_TOKEN, JunoApiManager.config().getResourceToken())); //
    }

    private String toJson(Object object) {
        try {
            return JacksonUtils.getObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            fail("Failed to convert object to json", e);
        }
        return null;
    }

    private String getResource(String... resources) {
        List<String> resourcesList = new ArrayList<>();
        resourcesList.add("mockserver");
        Stream.of(resources).forEach(resourcesList::add);
        return FixtureHelper.getResource(resourcesList.toArray(new String[resourcesList.size()]));
    }

    private MockServerClient mockServer;
}
