package br.com.juno.integration.api.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

public final class ResponseUtils {

    private ResponseUtils() {
        // NTD
    }

    public static ObjectMapper getObjectMapper() {
        if (mapper == null) {
            mapper = Jackson2ObjectMapperBuilder.json() //
                    .modules( //
                            new ParameterNamesModule(), //
                            new Jdk8Module(), //
                            new JavaTimeModule(), //
                            new Jackson2HalModule()//
                    ) //
                    .build(); //
            mapper.setSerializationInclusion(Include.NON_NULL);
        }

        return mapper;
    }

    public static Link getLink(ResourceSupport resource, String rel) {
        return resource.getLink(rel);
    }

    public static String getHrefLink(ResourceSupport resource, String rel) {
        Link link = getLink(resource, rel);
        return link == null ? null : link.getHref();
    }

    private static ObjectMapper mapper;
}