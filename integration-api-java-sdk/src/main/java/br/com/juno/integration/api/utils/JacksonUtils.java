package br.com.juno.integration.api.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

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
                    .build();
            mapper.setSerializationInclusion(Include.NON_NULL);
            // @formatter:on
        }

        return mapper;
    }

    private static ObjectMapper mapper;
}
