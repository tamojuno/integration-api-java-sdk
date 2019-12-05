package br.com.juno.integration.api.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import br.com.juno.integration.api.base.exception.JunoApiException;

public final class JacksonUtils {

    private JacksonUtils() {
        // Utility class
    }

    public static ObjectMapper getObjectMapper() {
        if (mapper == null) {
            // @formatter:off
            mapper = Jackson2ObjectMapperBuilder.json()
                    .modules(
                            new ParameterNamesModule(),
                            new Jdk8Module(),
                            new JavaTimeModule(),
                            new Jackson2HalModule()
                    )
                    .mixIn(Resource.class, ResourceMixIn.class)
                    .failOnUnknownProperties(true)
                    .serializationInclusion(Include.NON_NULL)
                    .build();
            // @formatter:on
        }

        return mapper;
    }

    public static String toJson(Object object) {
        try {
            return JacksonUtils.getObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new JunoApiException("Error generating JSON Payload", e);
        }
    }

    public static byte[] toJsonBytes(Object object) {
        try {
            return JacksonUtils.getObjectMapper().writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            throw new JunoApiException("Error generating JSON Payload", e);
        }
    }

    private static ObjectMapper mapper;

    private abstract static class ResourceMixIn extends ResourceSupport {

        @Override
        @JsonIgnore(false)
        public abstract Link getId();
    }
}
