package br.com.juno.integration.api.config;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.juno.integration.api.base.exception.ErrorDetail;
import br.com.juno.integration.api.base.exception.JunoApiException;
import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.utils.JacksonUtils;
import kong.unirest.Config;
import kong.unirest.HttpRequest;
import kong.unirest.HttpRequestSummary;
import kong.unirest.HttpResponse;
import kong.unirest.Interceptor;
import kong.unirest.Unirest;
import kong.unirest.UnirestParsingException;

public final class UnirestConfig {

    public static void configure() {
        Unirest.config().setDefaultHeader(JunoApiManager.X_API_VERSION, JunoApiManager.X_API_VERSION_VALUE);
        Unirest.config().setObjectMapper(ObjectMapperConfig.objectMapper());
        Unirest.config().interceptor(requestInterceptor());
    }

    private static Interceptor requestInterceptor() {
        return new Interceptor() {

            @Override
            public void onRequest(HttpRequest<?> request, Config config) {
                if (!request.getUrl().contains("/oauth/token")) {
                    request.headers(JunoApiManager.getAuthorizationService().getAuthorizationHeader());
                }
            }

            @Override
            public void onResponse(HttpResponse<?> response, HttpRequestSummary request, Config config) {

                if (!response.isSuccess()) {
                    UnirestParsingException parsingException = response.getParsingError().orElse(null);
                    if (parsingException != null) {
                        ErrorDetail errorDetail;
                        try {
                            errorDetail = JacksonUtils.getObjectMapper().readValue(parsingException.getOriginalBody(), ErrorDetail.class);
                        } catch (JsonProcessingException e) {
                            throw new JunoApiException("Failed to read error response from Juno. Please contact the support team.", e);
                        }
                        throw new JunoApiException(errorDetail);
                    }
                    throw new JunoApiException(response.mapError(ErrorDetail.class));
                }

            }

            @Override
            public HttpResponse<?> onFail(Exception e, HttpRequestSummary request, Config config) {
                if (e instanceof JunoApiException) {
                    throw (JunoApiException)e;
                }
                throw new JunoApiException(e);
            }

        };
    }
}
