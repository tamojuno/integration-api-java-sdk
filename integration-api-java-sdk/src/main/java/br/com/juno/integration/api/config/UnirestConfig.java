package br.com.juno.integration.api.config;

import java.lang.reflect.Type;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import br.com.juno.integration.api.base.exception.JunoApiException;
import br.com.juno.integration.api.utils.ResponseUtils;
import kong.unirest.GenericType;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;

public final class UnirestConfig {

    public static void configure() {
        Unirest.config().setDefaultHeader("X-API-Version", "2");
        Unirest.config().setObjectMapper(new ObjectMapper() {

            @Override
            public String writeValue(Object value) {
                try {
                    return ResponseUtils.getObjectMapper().writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new JunoApiException(e);
                }
            }

            @Override
            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return ResponseUtils.getObjectMapper().readValue(value, valueType);
                } catch (JsonProcessingException e) {
                    throw new JunoApiException(e);
                }
            }

            @Override
            public <T> T readValue(String value, GenericType<T> genericType) {
                try {
                    return ResponseUtils.getObjectMapper().readValue(value, new TypeReference<T>() {

                        @Override
                        public Type getType() {
                            return genericType.getType();
                        }
                    });
                } catch (JsonProcessingException e) {
                    throw new JunoApiException(e);
                }
            }
        });
    }

}
